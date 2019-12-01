package com.example.homework;

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

import java.util.Random;

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
public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    CheckBox chkAgree, chkRandom, chkSequence;
    Button btnOk;
    ImageView imgLang;
    Boolean rand = false, seq = false;

    int drawArr[] = {
            R.drawable.num0,
            R.drawable.num1,
            R.drawable.num2,
            R.drawable.num3,
            R.drawable.num4,
            R.drawable.num5,
            R.drawable.num6,
            R.drawable.num7,
            R.drawable.num8,
            R.drawable.num9,
    };

    int cnt = 0;

    Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Image Gallery");

        tv1 = (TextView)findViewById(R.id.Text1);
        tv2 = (TextView)findViewById(R.id.Text2);

        chkAgree = (CheckBox)findViewById(R.id.ChkAgree);
        chkRandom = (CheckBox)findViewById(R.id.ChkRandom);
        chkSequence = (CheckBox)findViewById(R.id.ChkSequence);

        btnOk = (Button)findViewById(R.id.BtnOk);

        imgLang = (ImageView)findViewById(R.id.ImgLang);

        chkAgree.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {
                        if(chkAgree.isChecked() == true) {
                            tv2.setVisibility(View.VISIBLE);
                            btnOk.setVisibility(View.VISIBLE);
                            imgLang.setVisibility(View.VISIBLE);
                        } else {
                            tv2.setVisibility(View.INVISIBLE);
                            btnOk.setVisibility(View.INVISIBLE);
                            imgLang.setVisibility(View.INVISIBLE);
                        }
                    }
                });

        chkRandom.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {
                        if(chkRandom.isChecked() == true) {
                            rand = true;
                        } else {
                            rand = false;
                        }
                    }
                });

        chkSequence.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView,
                            boolean isChecked) {
                        if(chkSequence.isChecked() == true) {
                            seq = true;
                        } else {
                            seq = false;
                        }
                    }
                });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* 이제 사용자 인터페이스는 모두 만들었으므로
                   남은 작업은 각각의 체크박스에 따른
                   동작들을 만들어주면 된다. */
                if(rand == true && seq == true) {
                    tv2.setText("랜덤과 순차를 동시 선택했습니다.");
                } else if(rand == true) {
                    imgLang.setImageResource(
                            drawArr[ran.nextInt(10)]
                    );
                    /*
                    imgLang.setImageResource(
                            R.drawable.clang
                    );
                    이 녀석은 그림 파일의 리소스 경로를 가지고 있음
                    이것을 배열로 만들면
                    랜덤하게 출력하기가 훨씬 용이할 것임
                     */
                } else if(seq == true) {
                    imgLang.setImageResource(
                            drawArr[cnt++]
                    );
                    if(cnt == 10) {
                        cnt = 0;
                    }
                } else {
                    tv2.setText("올바른 설정이 필요합니다.");
                }
            }
        });
    }
}
