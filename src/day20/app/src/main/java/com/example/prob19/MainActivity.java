package com.example.prob19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/* 문제 19. 두 개의 Button 을 만듭니다.
            Layout 은 LinearLayout 으로 만듭니다.
            그나마 보기 좋게 vertical 로 만듭니다.
            오늘 배운 padding 한 번 해주세요 ~
            TextView 를 1 개 만듭니다.
            1 번째 Button 을 누르면 Toast 메시지 출력
            2 번째 Button 을 누르면 TextView 의 글자를 변경 */
public class MainActivity extends AppCompatActivity {
    Button btn, btn2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Pressed Button",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tv = (TextView)findViewById(R.id.resText);
        tv.setText("잘.된.다.?");

        btn2 = (Button)findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText("변경 완료!");
            }
        });
    }
}
