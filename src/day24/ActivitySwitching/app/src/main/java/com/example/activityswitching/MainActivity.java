package com.example.activityswitching;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menuBtn = (Button)findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MenuActivity.class
                );
                startActivityForResult(
                        intent,
                        REQUEST_CODE_MENU
                );
            }
        });
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(
                getApplicationContext(),
                "onActivityResult Called: " + requestCode,
                Toast.LENGTH_SHORT
            ).show();

            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(
                    getApplicationContext(),
                    "Response name: " + name,
                    Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}
