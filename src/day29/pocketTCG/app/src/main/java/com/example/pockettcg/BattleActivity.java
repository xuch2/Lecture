package com.example.pockettcg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BattleActivity extends AppCompatActivity {
    int cnt = 0;

    ImageView mainDeck;
    TextView tv1;

    Button atk, def, skillWindow;

    RadioGroup skillSet;

    boolean mShowingBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        ImageView scareCrow = (ImageView) findViewById(R.id.target);
        mainDeck = (ImageView) findViewById(R.id.maindeck);

        atk = (Button) findViewById(R.id.attack);
        def = (Button) findViewById(R.id.defence);
        skillWindow = (Button) findViewById(R.id.skillAtk);

        skillSet = (RadioGroup) findViewById(R.id.skillGroup);

        RadioButton skill1 = (RadioButton) findViewById(R.id.phychic);
        RadioButton skill2 = (RadioButton) findViewById(R.id.shadowBall);

        tv1 = (TextView) findViewById(R.id.tv1);

        scareCrow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                println("훈련용 허수아비: hp - 200, mp - 0, pdef - 10, mdef - 0");

                return true;
            }
        });

        mainDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainDeck.setImageResource(R.drawable.card_front);
                //flipCard();
                println("뮤츠: hp - 350, mp - 200, pdef - 40, mdef - 60, atk - 40, int - 120");

                atk.setVisibility(View.VISIBLE);
                def.setVisibility(View.VISIBLE);
                skillWindow.setVisibility(View.VISIBLE);
            }
        });

        skillWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillSet.setVisibility(View.VISIBLE);
            }
        });

        /*
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.maindeck, new CardFrontFragment())
                    .commit();
        }
         */
    }

    public void println(String data) {
        tv1.append(data + "\n");
    }

    public void flipCard() {
        if (mShowingBack) {
            mShowingBack = false;
            getSupportFragmentManager().popBackStack();
        } else {
            mShowingBack = true;
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.card_flip_right_enter,
                            R.anim.card_flip_right_exit,
                            R.anim.card_flip_left_enter,
                            R.anim.card_flip_left_exit)
                    .replace(R.id.maindeck, new CardBackFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}
