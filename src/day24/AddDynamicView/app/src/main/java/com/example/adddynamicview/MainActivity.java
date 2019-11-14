package com.example.adddynamicview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int CONTAINER = 10000;
    final int CHK = 20000;

    final int MAX_LAYOUT = 100;
    LinearLayout[] container = new LinearLayout[MAX_LAYOUT];

    LinearLayout base;

    int cnt = 0;

    public void makeSubScene() {
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );

        container[cnt] = new LinearLayout(this);
        container[cnt].setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("Sub Scene");

        CheckBox chk = new CheckBox(this);
        chk.setText("Load Complete");

        container[cnt].addView(tv);
        container[cnt].addView(chk);
        container[cnt].setId(CONTAINER + cnt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );

        base = new LinearLayout(this);
        base.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("Press Button to add Scene");

        Button btn = new Button(this);
        btn.setText("Button");

        base.addView(tv);
        base.addView(btn);

        setContentView(base, params);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSubScene();
                base.addView(container[cnt++]);
            }
        });
    }
}
