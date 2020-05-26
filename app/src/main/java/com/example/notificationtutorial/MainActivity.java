package com.example.notificationtutorial;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NOTIFICATION_ID = 966;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SimpleNotifyBtn = findViewById(R.id.btn_main_simpleNotification);
        Button bigPicNotifyBtn = findViewById(R.id.btn_main_bigPicStyle);
        Button bigTextNotify   = findViewById(R.id.btn_main_inboxStyle);
        SimpleNotifyBtn.setOnClickListener(this);
        bigPicNotifyBtn.setOnClickListener(this);
        bigTextNotify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        NotificationManager notificationManager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        switch (v.getId()) {
            case R.id.btn_main_simpleNotification:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                Notification SimpleNotification = new NotificationCompat.Builder(this, App.KEY_MY_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentTitle("My notification test").setContentText("this is my first notification")
                        .setContentIntent(pendingIntent).build();
                if (notificationManager != null) {
                    notificationManager.notify(NOTIFICATION_ID, SimpleNotification);
                }
                break;
            case R.id.btn_main_bigPicStyle:
                Notification bigPicNotification = new NotificationCompat.Builder(this, App.KEY_MY_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).setStyle(
                                new NotificationCompat.BigPictureStyle()
                                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.banner))
                                        .setBigContentTitle("big picture style"))
                        .setContentTitle("My notification test").setContentText("this is my first notification").build();
                if (notificationManager != null) {
                    notificationManager.notify(NOTIFICATION_ID, bigPicNotification);
                }
                break;
            case R.id.btn_main_bigTextStyle:
                Notification bigTextNotification = new NotificationCompat.Builder(this, App.KEY_MY_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(
                                "this is my first notification this is my first notification this is my first notification this is my first notification this is my first notification this is my first notification this is my first notification this is my first notification "))
                        .setContentTitle("My notification test").setContentText("this is my first notification").build();
                if (notificationManager != null) {
                    notificationManager.notify(NOTIFICATION_ID, bigTextNotification);
                }
                break;
            case R.id.btn_main_inboxStyle:
                Notification inboxNotification = new NotificationCompat.Builder(this, App.KEY_MY_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setStyle(new NotificationCompat.InboxStyle().addLine("this is my first notification")
                                                                     .addLine("this is my 2 notification")
                                                                     .addLine("this is my 3 notification")
                                                                     .addLine("this is my 4 notification"))
                        .setContentTitle("My notification test").build();
                if (notificationManager != null) {
                    notificationManager.notify(NOTIFICATION_ID, inboxNotification);
                }
                break;
        }
    }
}
