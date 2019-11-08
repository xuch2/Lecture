package com.example.advancedlinearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        /* XML 에서 <LinearLayout 이후에
           layout_width 과 layout_height 에 match_parent
           라고 줬던 작업과 동일한 작업에 해당합니다.

           아래 코드의 XML 동의어는 다음과 같다.

           <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent" */
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );

        /* LinearLayout 을 객체화함 */
        LinearLayout base = new LinearLayout(this);
        /* android:orientation="vertical" 와 동의어 */
        base.setOrientation(LinearLayout.VERTICAL);
        /* android:background="#0000ff" 와 동의어 */
        base.setBackgroundColor(
                Color.rgb(0, 0, 255));

        // 만든 내용을 실제 화면에 출력하는 부분
        setContentView(base, params);

        Button btn = new Button(this);
        btn.setText("Click this button");
        btn.setBackgroundColor(Color.MAGENTA);
        // 우리가 만든 버튼 객체를 실제 화면에 출력함
        base.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "코드로 LinearLayout 만들기",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}

/* 문제 20. XML 없이 프로그램으로 LinearLayout 안에
            2 개의 LinearLayout 과 버튼을 배치한다.
            2 개의 LinearLayout 의 색상은 서로 다르다.
            버튼을 누르면 서로간의 색상이 교환되게 한다.
            (힌트: addView, layout_weight 의 역할을
             수행할 수 있는 매서드를 활용하면 문제 해결!
             LinearLayout.LayoutParams(
                                LayoutParams.MATCH_PARENT,
                                LayoutParams.MATCH_PARENT, 1f);)
 */