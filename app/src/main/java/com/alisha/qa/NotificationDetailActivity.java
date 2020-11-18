package com.alisha.qa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.notificationdemo.R;

public class NotificationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);
        TextView textView = findViewById(R.id.notifDetailTxt);
        String message = getIntent().getStringExtra("message");
        textView.setText(message);
    }
}