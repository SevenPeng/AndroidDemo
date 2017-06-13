package com.example.seven.androidfirstbookalldemo.c8;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;

import java.io.File;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c8_activity_notification);
        Button sendNotice = (Button)findViewById(R.id.c8_btn_send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c8_btn_send_notice:
                Intent intent = new Intent(this,NotificationActionActivity.class);
                PendingIntent pi = PendingIntent.getActivities(this,0, new Intent[]{intent},0);//延迟的意图,响应通知
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.cancel(1);//点击通知后隐藏
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content titleI know a man who has terrible, corrupt beliefs but in his actions he " +
                                "is quite honest and shows great integrity. Is he a good or a bad man?")//通知大标题
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("This is content titleI know a man who has terrible, corrupt beliefs but in his actions he " +
                                "is quite honest and shows great integrity. Is he a good or a bad man?"))//设置长通知
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.img_no1)))//设置大图标
                        .setContentText("This is content text")//通知小正文
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)//通知小图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))//大图标
                        .setAutoCancel(true)//自动隐藏
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))//通知响铃
                        .setVibrate(new long[]{0,1000,1000,1000})//设置震动 立即开始,震1,静1,震1
                        .setLights(Color.GREEN,1000,1000)//设置led通知灯,绿,闪1秒,停1秒
                        .setPriority(NotificationCompat.PRIORITY_MAX)   //设置优先级
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
