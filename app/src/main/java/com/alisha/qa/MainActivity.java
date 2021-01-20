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
import android.widget.Toast;

import com.alisha.qa.model.AnswersModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Button yesTxt, noTxt, btnGotoAnother;
    DatabaseReference databaseReference;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("answers");
        yesTxt = findViewById(R.id.answr1);
        noTxt = findViewById(R.id.answr2);
        btnGotoAnother = findViewById(R.id.gotoAnotherPage);

        yesTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println("bshjdsjdhb");
                addNotificationyes("Yes");
            }
        });
        noTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotificationyes("no");
            }
        });

        btnGotoAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGo = new Intent(getApplicationContext(), ItemActivity.class);
                startActivity(intentGo);
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");    }


    private void addNotificationyes(String answer) {
        String id = databaseReference.push().getKey();
        System.out.println("jsbj"+id);
        AnswersModel answersModel = new AnswersModel(id, answer);
        databaseReference.child(id).setValue(answer);
        Toast.makeText(MainActivity.this,"Answers added",Toast.LENGTH_SHORT).show();
        if (answer == "Yes") {
            message = "You chosed first answer";
        }
        else {
            message = "You chosed second answer";
        }
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_message)
                        .setAutoCancel(true)
                        .setContentTitle("Notifications Example")
                        .setContentText(message);
        Intent notificationIntent = new Intent(this, NotificationDetailActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        notificationIntent.putExtra("message", message);
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

    public void openreactionScreen(View view) {
        System.out.println("ndsjksbsd");
        Intent gotoScreen = new Intent(MainActivity.this, ReactionScreen.class);
        startActivity(gotoScreen);
    }
    public void openAnimationScreen(View view) {
        System.out.println("ndsjksbsd");
        Intent gotoScreen = new Intent(MainActivity.this, AnimationScreen.class);
        startActivity(gotoScreen);
    }
}