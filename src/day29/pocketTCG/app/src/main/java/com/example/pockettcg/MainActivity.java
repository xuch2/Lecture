package com.example.pockettcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import android.database.Cursor;
import android.net.Uri;

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
                if (chkUserInfo() == true) {
                    Intent intent = new Intent(
                            getApplicationContext(),
                            WaitRoomActivity.class
                    );
                    startActivityForResult(
                            intent,
                            REQUEST_CODE_WAITROOM
                    );
                } else {
                    Intent intent = new Intent(
                            getApplicationContext(),
                            RegisterActivity.class
                    );
                    startActivityForResult(
                            intent,
                            REQUEST_CODE_WAITROOM
                    );
                }

                return true;
            }
        });
    }

    public boolean chkUserInfo() {
        String uriString = "content://com.example.pockettcg/info";

        Uri uri = new Uri.Builder().build().parse(uriString);

        String[] columns = new String[]{"email"};
        Cursor cursor = getContentResolver().query(uri, columns, null, null, "name ASC");

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
