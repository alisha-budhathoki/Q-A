package com.alisha.qa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.notificationdemo.R;

public class MainActivity extends AppCompatActivity {
    Button yesTxt, noTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yesTxt = findViewById(R.id.answr1);
        noTxt = findViewById(R.id.answr2);

        yesTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotificationyes();
                System.out.println("sjnjsad");
            }
        });

    }

    private void addNotificationyes() {
        System.out.println("snajhbjs");
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("Notifications Example")
                        .setContentText("This is a test notification");
        System.out.println("123"+ builder);
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
// Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        System.out.println("kjnsajdsb");
        // === Removed some obsoletes
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            System.out.println("bjsjsdjs");
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        manager.notify(0, builder.build());

    }
}