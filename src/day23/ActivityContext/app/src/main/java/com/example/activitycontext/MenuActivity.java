package com.example.activitycontext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        container = (LinearLayout)findViewById(R.id.container);

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =
                        (LayoutInflater)getSystemService(
                                LAYOUT_INFLATER_SERVICE
                        );
                inflater.inflate(
                        R.layout.sub_res,
                        container,
                        true
                );
                CheckBox box = container.findViewById(R.id.chk);
                box.setText("Load Complete");
            }
        });
    }
}
