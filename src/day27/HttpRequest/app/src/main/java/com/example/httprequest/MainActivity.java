package com.example.httprequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.et);
        tv = (TextView)findViewById(R.id.tv);

        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String uriStr = et.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        request(uriStr);
                    }
                }).start();
            }
        });
    }

    public void request(String uriStr) {
        StringBuilder output = new StringBuilder();

        try {
            URL url = new URL(uriStr);

            HttpURLConnection con =
                    (HttpURLConnection)url.openConnection();

            if(con != null) {
                con.setConnectTimeout(10000);
                con.setRequestMethod("GET");
                con.setDoInput(true);

                int resCode = con.getResponseCode();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(con.getInputStream())
                );
                String line = null;

                while(true) {
                    line = reader.readLine();
                    if(line == null) {
                        break;
                    }

                    output.append(line + "\n");
                }

                reader.close();
                con.disconnect();
            }
        } catch (Exception e) {
            println("Exception Occurance: " + e.toString());
        }
        println("Request Code: " + output.toString());
    }

    public void println(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                tv.append(data + "\n");
            }
        });
    }
}
