package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rC, rJava, rGo;
    Button btnOk;
    ImageView imgLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Image Gallery");

        tv1 = (TextView)findViewById(R.id.Text1);
        tv2 = (TextView)findViewById(R.id.Text2);

        chkAgree = (CheckBox)findViewById(R.id.ChkAgree);

        rGroup1 = (RadioGroup)findViewById(R.id.Rgroup1);

        rC = (RadioButton)findViewById(R.id.Rc);
        rJava = (RadioButton)findViewById(R.id.Rjava);
        rGo = (RadioButton)findViewById(R.id.Rgo);

        btnOk = (Button)findViewById(R.id.BtnOk);

        imgLang = (ImageView)findViewById(R.id.ImgLang);

        /* setOnCheckedChangeListener 는
           setOnClickListener 와 동작 방식은 유사하다.
           OnClickListener 는 클릭을 했을때 발생함
           OnCheckedChangeListener 는
           체크를 하거나 체크를 해제할 경우 동작함
         */
        chkAgree.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(
                    CompoundButton buttonView,
                    boolean isChecked) {
                if(chkAgree.isChecked() == true) {
                    tv2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgLang.setVisibility(View.VISIBLE);
                } else {
                    tv2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgLang.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* getCheckedRadioButtonId() 는
                   XML 리소스에 등록해놓은 id 값을 판정한다.
                   이를 기반으로 setImageResource 로
                   원하는 이미지를 띄워줄 수 있다.
                   setImageResource() 를 사용할 것이라면
                   반드시 res 폴더에 이미지들을 배치해야 한다.
                 */
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.Rc:
                        imgLang.setImageResource(
                                R.drawable.clang
                        );
                        break;
                    case R.id.Rjava:
                        imgLang.setImageResource(
                                R.drawable.javalang
                        );
                        break;
                    case R.id.Rgo:
                        imgLang.setImageResource(
                                R.drawable.golang
                        );
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "Select Language",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

/* 문제 20. 아무런 이미지 파일을 10 개 정도 확보한다.
            CheckBox 를 3 개 만든다.
            1 번째 체크 박스는 오늘 작성한 예제처럼
            눈에 보이게 할지 말지를 결정하도록 한다.
            2 번째 체크 박스는 랜덤 여부를 판정한다.
            즉, 1, 2 번 체크 박스를 체크하면
            무작위로 그림파일이 보이게 만들면 된다.
            (Button 을 하나 만들어서
            누를 때마다 무작위로 보이게 만들어준다.)
            3 번째 체크 박스는 순서대로 보이게 해준다.
            결론: 1, 2 번은 무작위 출력
                  1, 3 번은 순차 출력
                  2, 3 번은 동작 불가능!
                  1 번만 있을 경우엔 VISIBLE 이므로
                  메뉴만 보여준다고 생각하면 됨
                  2 번이나 3 번만 있을 경우엔
                  아무것도 보이지 않음
                  (1 번이 꺼져있기 때문) */