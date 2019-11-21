package com.example.pockettcg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import android.content.Intent;

public class RegisterActivity extends AppCompatActivity {
    EditText etName;
    EditText etAge;
    EditText etMobile;
    EditText etEmail;
    EditText etPassword;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertInfo();

                Intent intent = new Intent();
                intent.putExtra("name", "back");
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

    public void insertInfo() {
        String uriString = "content://com.example.pockettcg/info";

        Uri uri = new Uri.Builder().build().parse(uriString);

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        String[] columns = cursor.getColumnNames();

        ContentValues values = new ContentValues();
        values.put("name", etName.getText().toString());
        values.put("age", etAge.getText().toString());
        values.put("mobile", etMobile.getText().toString());
        values.put("email", etEmail.getText().toString());
        values.put("password", etPassword.getText().toString());

        // 최종적으로 DB 에 값을 집어넣는 작업은 여기서 진행된다.
        //uri = getContentResolver().insert(uri, values);
        getContentResolver().insert(uri, values);
    }
}
