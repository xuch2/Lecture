package com.example.activityswitching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* finish() 로 끝나기 때문에
                   Context 저장이 필요 없다.
                   그리고 다시 원래 Activity 로 귀환할 때
                   name 에 대한 값으로 back 을 전달한다.
                   (되돌아가기)를 눌렀다는 의미가 된다.
                   그리고 resultCode 로 RESULT_OK 를 전달한다. */
                Intent intent = new Intent();
                intent.putExtra("name", "back");
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}
