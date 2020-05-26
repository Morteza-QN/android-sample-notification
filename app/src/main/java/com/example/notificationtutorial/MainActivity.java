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

        Button notificationBtn = findViewById(R.id.btn_main_simpleNotification);
        notificationBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_simpleNotification:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                Notification notification = new NotificationCompat.Builder(this, App.KEY_MY_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentTitle("My notification test").setContentText("this is my first notification")
                        .setContentIntent(pendingIntent).build();
                NotificationManager notificationManager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
                if (notificationManager != null) {
                    notificationManager.notify(NOTIFICATION_ID, notification);
                }
                break;

        }
    }
}
