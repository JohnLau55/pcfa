package example.liuqaing.com.notifytest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final int NOTYFID = 0x123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final NotificationManager notificationManager =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder notifycation = new Notification.Builder(this);
        notifycation.setAutoCancel(true);
        notifycation.setSmallIcon(R.mipmap.ic_launcher);
        notifycation.setContentTitle("奖励百万奖金");
        notifycation.setContentText("点击查看详情");
        notifycation.setDefaults(Notification.DEFAULT_SOUND| Notification.DEFAULT_VIBRATE);
        notifycation.setWhen(System.currentTimeMillis());

        Intent intent = new Intent(MainActivity.this, Detail.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        notifycation.setContentIntent(pi);
        notificationManager.notify(NOTYFID,notifycation.build());
    }
}
