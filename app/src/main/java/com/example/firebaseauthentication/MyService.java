package com.example.firebaseauthentication;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.RemoteMessage;

public class MyService extends Service {

    public void onMessageReceived(@NonNull RemoteMessage message) {

        getFirebaseMessage(message.getNotification().getTitle(), message.getNotification().getBody());
    }
    private void getFirebaseMessage(String titel, String msg) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "my firebase notification")
                    //  .setSmallIcon()
                    .setContentTitle(titel)
                    .setContentText(msg)
                    .setAutoCancel(true);
            NotificationManagerCompat manger = NotificationManagerCompat.from(this);
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            manger.notify(101, builder.build());




        }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}