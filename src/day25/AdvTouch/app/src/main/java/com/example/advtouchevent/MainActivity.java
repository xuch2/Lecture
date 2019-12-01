package com.example.advtouchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    GestureDetector detector;

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

        detector = new GestureDetector(
                this,
                new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("Call onDown()");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("Call onShowPress()");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("Call onSingleTapUp()");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1,
                                    MotionEvent e2,
                                    float distanceX,
                                    float distanceY) {
                println("Call onScroll() : " + distanceX +
                        ", " + distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("Call onLongPress()");
            }

            @Override
            public boolean onFling(MotionEvent e1,
                                   MotionEvent e2,
                                   float velocityX,
                                   float velocityY) {
                println("Call onFling() : " + velocityX +
                        ", " + velocityY);
                return true;
            }
        });

        View v2 = (View)findViewById(R.id.view2);

        v2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }

    public void println(String data) {
        tv1.append(data + "\n");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(
                    this,
                    "You Pressed [BACK] Button",
                    Toast.LENGTH_SHORT
            ).show();

            return true;
        }
        return false;
    }
}
