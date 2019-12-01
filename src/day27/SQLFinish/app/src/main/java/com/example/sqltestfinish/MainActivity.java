package com.example.sqltestfinish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);

        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertInfo();
            }
        });

        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryInfo();
            }
        });

        Button button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInfo();
            }
        });

        Button button4 = findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteInfo();
            }
        });
    }

    public void insertInfo() {
        println("insertInfo() Called");

        /* content:// 까지는 모두 동일함
           다음이 패키지 정보가 배치됨(com.example.sqltestfinish)
           이후에 뒤쪽의 info 라는 것은 DB 이름을 info.db 로 만들기 때문 */
        String uriString = "content://com.example.sqltestfinish/info";
        /* 아래 코드를 통해서 실제 DB 에 대한 정보를 해석할 준비를 한다.
           *.db 파일에 기록된 정보들을 파싱해서
           적절하게 사용할 수 있는 형태로 가지고 있는 것이라 보면 됨 */
        Uri uri = new Uri.Builder().build().parse(uriString);

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        String[] columns = cursor.getColumnNames();
        /* 위의 두 줄을 통해서 DB 테이블에 있는 컬럼 이름들을 가져온다.
           테이블 구조를 해석한다라고 생각해도 무방함.
           columns.length 는 테이블에 몇 개의 요소가 있는지를 나타냄 */
        println("columns count -> " + columns.length);
        for (int i = 0; i < columns.length; i++) {
            println("#" + i + " : " + columns[i]);
        }

        /* ContentValues 라는 녀석은
           실제 테이블에 데이터를 넣는 작업을 지원해준다.
           ContentValues 의 객체인 values.put() 을 통해서 이를 수행한다.
           첫 번째 인자는 컬럼 이름이 오고,
           두 번째 인자에 컬럼에 넣을 값을 설정하면 된다. */
        ContentValues values = new ContentValues();
        values.put("name", "Jessica");
        values.put("age", 20);
        values.put("mobile", "010-3333-7777");

        // 최종적으로 DB 에 값을 집어넣는 작업은 여기서 진행된다.
        uri = getContentResolver().insert(uri, values);
        println("insert 결과 -> " + uri.toString());
    }

    /* 조회 */
    public void queryInfo() {
        println("queryInfo() Called");

        /* try catch 구문을 사용한 이유는
           실제 DB 에 정보가 없는 상황에서
           데이터에 접근하면 오류가 나기 때문이다.
           그래서 예외 처리를 할 수 있도록 try catch 사이에 넣었다.

           사실 이 try catch 구문이 C 언어에서 goto 랑 동일한 녀석이다.
           물론 엄밀하게는 setjmp(), longjmp() 라는 두 개의 함수로 구성됨
           이유: goto 는 함수(매서드)간에 사용이 불가능하지만
           setjmp() 와 longjmp() 는 저것이 가능하다.

           try 쪽에는 예외 상황이 발생할 수도 있는 코드를 적는다.
           그리고 catch 쪽에는 예외를 어떻게 처리할지 적는다. */
        try {
            String uriString = "content://com.example.sqltestfinish/info";
            Uri uri = new Uri.Builder().build().parse(uriString);

            /* 조회를 할 경우에는
               보고 싶은 정보를 같이 날려줘야 한다.
               그래서 아래쪽 query() 에 uri 와
               보고자 하는 columns 를 같이 넘긴다. */
            String[] columns = new String[] {"name", "age", "mobile"};
            Cursor cursor = getContentResolver().query(uri, columns, null, null, "name ASC");
            // 테이블 개수(현재 DB 에 몇명의 정보가 있는지)를 얻어온다.
            println("query res : " + cursor.getCount());

            int index = 0;
            /* cursor.moveToNext() 는 다음 정보가 존재한다면 */
            while(cursor.moveToNext()) {
                /* column[0] 은 "name" 이므로
                   "name" 에 대한 컬럼 인덱스를 가져오고
                   이 정보를 다시 String 타입으로 변환한다.
                   그러므로 DB 테이블 "name" 있던 이름 값을 얻어오게 된다. */
                String name = cursor.getString(cursor.getColumnIndex(columns[0]));
                int age = cursor.getInt(cursor.getColumnIndex(columns[1]));
                String mobile = cursor.getString(cursor.getColumnIndex(columns[2]));

                println("#" + index + " -> " + name + ", " + age + ", " + mobile);
                index += 1;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /* 개인 정보 변경 */
    public void updateInfo() {
        println("updateInfo() Called");

        String uriString = "content://com.example.sqltestfinish/info";
        Uri uri = new Uri.Builder().build().parse(uriString);

        /* selection 에는 DB 테이블 상에서 변경을 적용할 녀석을 적는다.
           예를 들어서 폰 번호를 바꾸는 상황이라면
           mobile 을 적고 이후에 = ? 를 적어줘야 한다.
           원래 SQL 은 기본적으로 명령이 들어오면 바로바로 처리한다.
           그러나 ? 가 있을 경우엔 ? 의 값이 채워지기까지 대기한 이후
           처리할 수 있는 형식의 구조를 지원하게 된다. */
        String selection = "mobile = ?";
        /* selectionArgs 는 mobile 이라는 컬럼 이름에서
           010-3333-7777 이라는 번호를 가진 녀석을 찾기 위해 적은 것이다.
           만약 다른 무언가를 찾고한다면
           찾고하는 정보를 여기에 적으면 된다.
           필요하다면 DB Query 를 사용해도 무방하다. */
        String[] selectionArgs = new String[]{"010-3333-7777"};
        /* 아래 두 줄은 값(mobile)을
           특정한 값(010-3377-2473)으로 변경하고자 사용하는 코드 */
        ContentValues updateValue = new ContentValues();
        updateValue.put("mobile", "010-3377-2473");

        int count = getContentResolver().update(uri, updateValue, selection, selectionArgs);
        println("update res : " + count);
    }

    /* 탈퇴 혹은 밴(블랙) */
    public void deleteInfo() {
        println("deleteInfo() Called");

        String uriString = "content://com.example.sqltestfinish/info";
        Uri uri = new Uri.Builder().build().parse(uriString);

        String selection = "name = ?";
        String[] selectionArgs = new String[] {"Jessica"};

        int count = getContentResolver().delete(uri, selection, selectionArgs);
        println("delete res : " + count);
    }

    public void println(String data) {
        textView.append(data + "\n");
    }
}
