package com.example.sdr.gametutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BattleActivity extends AppCompatActivity {
    int cnt = 0;

    ImageView mainDeck;
    TextView tv1;

    Button atk, def, skillWindow;

    RadioGroup skillSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        ImageView scareCrow = (ImageView)findViewById(R.id.target);
        mainDeck = (ImageView)findViewById(R.id.maindeck);

        atk = (Button)findViewById(R.id.attack);
        def = (Button)findViewById(R.id.defence);
        skillWindow = (Button)findViewById(R.id.skillAtk);

        skillSet = (RadioGroup)findViewById(R.id.skillGroup);

        RadioButton skill1 = (RadioButton)findViewById(R.id.phychic);
        RadioButton skill2 = (RadioButton)findViewById(R.id.shadowBall);

        tv1 = (TextView)findViewById(R.id.tv1);

        scareCrow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                println("훈련용 허수아비: hp - 200, mp - 0, pdef - 10, mdef - 0");

                return true;
            }
        });

        mainDeck.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                if(action == MotionEvent.ACTION_DOWN) {
                    mainDeck.setImageResource(R.drawable.mewtwo);
                    println("뮤츠: hp - 350, mp - 200, pdef - 40, mdef - 60, atk - 40, int - 120");

                    atk.setVisibility(View.VISIBLE);
                    def.setVisibility(View.VISIBLE);
                    skillWindow.setVisibility(View.VISIBLE);
                }

                return true;
            }
        });

        skillWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillSet.setVisibility(View.VISIBLE);
            }
        });
    }

    public void println(String data) {
        tv1.append(data + "\n");
    }
}
