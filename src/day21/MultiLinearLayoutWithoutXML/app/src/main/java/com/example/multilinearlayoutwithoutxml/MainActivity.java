package com.example.multilinearlayoutwithoutxml;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout innerLL1;
    LinearLayout innerLL2;

    int blue = Color.rgb(0, 0, 255);
    int red = Color.rgb(255, 0, 0);

    int arr[] = {blue, red};
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );

        LinearLayout base = new LinearLayout(this);
        base.setOrientation(LinearLayout.VERTICAL);
        base.setBackgroundColor(
                Color.rgb(0, 0, 0)
        );

        innerLL1 = new LinearLayout(getApplicationContext());
        innerLL1.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        1f
                )
        );
        innerLL1.setOrientation(LinearLayout.VERTICAL);
        innerLL1.setBackgroundColor(
                Color.rgb(255, 0, 0)
        );

        innerLL2 = new LinearLayout(getApplicationContext());
        innerLL2.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        1f
                )
        );
        innerLL2.setOrientation(LinearLayout.VERTICAL);
        innerLL2.setBackgroundColor(
                Color.rgb(0, 0, 255)
        );

        base.addView(innerLL1);
        base.addView(innerLL2);

        setContentView(base, params);

        Button btn = new Button(this);
        btn.setText("Click this button");
        btn.setBackgroundColor(Color.MAGENTA);
        base.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "색상 변환",
                        Toast.LENGTH_SHORT).show();

                innerLL1.setBackgroundColor(arr[cnt++ % 2]);
                innerLL2.setBackgroundColor(arr[cnt % 2]);
            }
        });
    }
}
