package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;

    private static final String CHANNEL_ID = "channel1";
    private static final String CHANNEL_NAME = "channel1";

    private static final String CHANNEL_ID2 = "channel2";
    private static final String CHANNEL_NAME2 = "channel2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti();
            }
        });

        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetailNoti();
            }
        });
    }

    public void showNoti() {
        manager = (NotificationManager)getSystemService(
                NOTIFICATION_SERVICE
        );

        NotificationCompat.Builder builder = null;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if(manager.getNotificationChannel(CHANNEL_ID) != null) {
                manager.createNotificationChannel(new NotificationChannel(
                        CHANNEL_ID,
                        CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_DEFAULT
                ));

                builder = new NotificationCompat.Builder(
                        this, CHANNEL_ID
                );
            }
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setContentTitle("Simple Notification");
        builder.setContentText("Alarm Message");
        builder.setSmallIcon(android.R.drawable.ic_menu_view);
        Notification noti = builder.build();

        manager.notify(1, noti);
    }

    public void showDetailNoti() {
        manager = (NotificationManager)getSystemService(
                NOTIFICATION_SERVICE
        );

        NotificationCompat.Builder builder = null;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if(manager.getNotificationChannel(CHANNEL_ID2) != null) {
                manager.createNotificationChannel(new NotificationChannel(
                        CHANNEL_ID2,
                        CHANNEL_NAME2,
                        NotificationManager.IMPORTANCE_DEFAULT
                ));

                builder = new NotificationCompat.Builder(
                        this, CHANNEL_ID2
                );
            }
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setContentTitle("Simple Notification");
        builder.setContentText("Alarm Message");
        builder.setSmallIcon(android.R.drawable.ic_menu_view);
        Notification noti = builder.build();

        manager.notify(2, noti);

        NotificationCompat.BigTextStyle style =
                new NotificationCompat.BigTextStyle();
        style.bigText("너만 오면 캐쉬템 지급!");
        style.setBigContentTitle(
                "지금 접속하면 10 만원 상당의 캐쉬템이 무료!"
        );
        style.setSummaryText(
                "3 주년 이벤트: 라그나로크, 봉인의 창, 피의 갑옷 지급!"
        );

        NotificationCompat.Builder builder2 =
                new NotificationCompat.Builder(
                        this, "channel3"
                ).setContentTitle("Subject"
                ).setContentText("Content"
                ).setSmallIcon(android.R.drawable.ic_menu_send
                ).setStyle(style);

        Notification noti2 = builder2.build();

        manager.notify(2, noti2);
    }
}
