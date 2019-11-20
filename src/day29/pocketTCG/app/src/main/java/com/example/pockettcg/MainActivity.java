package com.example.pockettcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_WAITROOM = 1;

    RelativeLayout rLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rLayout = (RelativeLayout)findViewById(R.id.rLayout);
        rLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /* 조건: DB 에 사용자 정보가 있으면
                   WaitRoomActivity 로 넘기고
                   없으면 RegisterActivity 로 넘긴다. */
                Intent intent = new Intent(
                        getApplicationContext(),
                        WaitRoomActivity.class
                );
                startActivityForResult(
                        intent,
                        REQUEST_CODE_WAITROOM
                );

                return true;
            }
        });
    }
}
