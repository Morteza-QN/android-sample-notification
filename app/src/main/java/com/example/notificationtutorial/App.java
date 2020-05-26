package com.example.notificationtutorial;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {
    public static final String KEY_MY_CHANNEL_ID = "MY_CHANNEL_ID";

    @Override
    public void onCreate() {
        super.onCreate();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager notificationManager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
            NotificationChannel notificationChannel =
                    new NotificationChannel(KEY_MY_CHANNEL_ID, "default channel", NotificationManager.IMPORTANCE_HIGH);
            //each press notification updated because id is static
            notificationChannel.setDescription("this channel for test ");
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}
