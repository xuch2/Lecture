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

        /* 버튼 1 에 대한 클릭 이벤트 등록
           사용자 -> 이벤트를 등록
           운영체제 -> 특정 상황을 만족하면 실행 */
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti();
            }
        });

        // 버튼 2 도 버튼 1 과 마찬가지다.
        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetailNoti();
            }
        });
    }

    public void showNoti() {
        /* 휴대폰에 알림 서비스를 제공하는 시스템 객체를 얻어옴 */
        manager = (NotificationManager)getSystemService(
                NOTIFICATION_SERVICE
        );

        /* android 버전이 여러 가지 있어서
           호환이 가능한 NotificationCompat 을 사용한다.
           그리고 Builder 는 알림을 어떤식으로 만들지를 결정한다. */
        NotificationCompat.Builder builder = null;

        /* SDK 버전이 26 보다 높다면 if 문을 만족한다.
           안드로이드 SDK 버전 26 이후부터는
           Notification 을 사용하기 위해
           휴대폰에서 별도의 설정이 필요해졌습니다.
           그래서 구분을 26 을 기준으로 하고 있습니다.

           우리가 초기 프로젝트 생성시
           minimum support 를 15 로 놨기 때문에
           이 부분은 거짓이 된다. */
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
            /* 알림 객체를 만든다.
               그러나 정보는 아무것도 설정되지 않은 상태 */
            builder = new NotificationCompat.Builder(this);
        }

        /* setContentTitle() 은 알림의 제목을 설정합니다. */
        builder.setContentTitle("Simple Notification");
        /* setContentText() 는 알림의 메시지를 설정합니다. */
        builder.setContentText("Alarm Message");
        /* setSmallIcon() 은 아이콘을 배치하는 작업 */
        builder.setSmallIcon(android.R.drawable.ic_menu_view);
        /* 최종적으로 알림 객체를 완성한다. */
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

        /* 큰 글자로 보다 강조하고 싶은 경우 사용함
           초기 설정과의 차이점이라면
           setContentTitle 등에 Big 이 붙어서
           setBigContentTitle 정도로 변경된 형태라 보면 된다.
           setSummaryText() 은 ContentTitle 안쪽에 들어가는 내용 */
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
