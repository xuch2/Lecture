package com.example.advtouchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);

        View v1 = (View)findViewById(R.id.view1);
        v1.setOnTouchListener(new View.OnTouchListener() {
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
        tv1.append(data + "\n");
    }
}
