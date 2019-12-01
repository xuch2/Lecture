package com.example.touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.btn3);
        btn1 = (Button)findViewById(R.id.btn1);

        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float curX = event.getX();
                float curY = event.getY();

                if(action == MotionEvent.ACTION_DOWN) {
                    println("Pressed : " + curX + ", " + curY);
                } else if(action == MotionEvent.ACTION_MOVE) {
                    println("Pressed : " + curX + ", " + curY);
                } else if(action == MotionEvent.ACTION_UP) {
                    println("Pressed : " + curX + ", " + curY);
                }

                return true;
            }
        });
    }

    public void println(String data) {
        tv.append(data + "\n");
    }
}

/* 문제 23. 여태까지 배웠던 모든 내용을 총 동원하여
            포켓몬 TCG 카드 게임을 만들어보자!
            온라인 기능은 필요 없다.
            튜토리얼 모드만 만들어보자!
            (공격 - 평타딜, 방어, 스킬 - 맘대로)
            상대편은 그냥 허수아비 세워놓을까 ? (알아서) */