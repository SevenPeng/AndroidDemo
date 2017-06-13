package com.example.seven.androidfirstbookalldemo.c8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;

public class C8MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c8_activity_main);
        Button btn_notification = (Button)findViewById(R.id.c8_btn_notification);
        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C8MainActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });
        Button btn_cameraAlbum = (Button)findViewById(R.id.c8_btn_cameraAlbum);
        btn_cameraAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C8MainActivity.this,CameraAlbumActivity.class);
                startActivity(intent);
            }
        });
    }
}
