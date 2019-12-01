package com.example.sdr.gametutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_ENHANCE = 3;
    public static final int REQUEST_CODE_PROMOTION = 7;
    public static final int REQUEST_CODE_ITEM = 33;
    public static final int REQUEST_CODE_RANK = 77;
    public static final int REQUEST_CODE_BATTLE = 333;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enhanceBtn = (Button)findViewById(R.id.enhanceBtn);
        enhanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        EnhanceActivity.class
                );
                startActivityForResult(
                        intent,
                        REQUEST_CODE_ENHANCE
                );
            }
        });

        Button promotionBtn = (Button)findViewById(R.id.promotionBtn);
        promotionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        PromotionActivity.class
                );
                startActivityForResult(
                        intent,
                        REQUEST_CODE_PROMOTION
                );
            }
        });

        Button itemBtn = (Button)findViewById(R.id.itemBtn);
        itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        ItemActivity.class
                );
                startActivityForResult(
                        intent,
                        REQUEST_CODE_ITEM
                );
            }
        });

        Button rankBtn = (Button)findViewById(R.id.rankBtn);
        rankBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        RankActivity.class
                );
                startActivityForResult(
                        intent,
                        REQUEST_CODE_RANK
                );
            }
        });

        Button battleBtn = (Button)findViewById(R.id.battleBtn);
        battleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        BattleActivity.class
                );
                startActivityForResult(
                        intent,
                        REQUEST_CODE_BATTLE
                );
            }
        });
    }
}
