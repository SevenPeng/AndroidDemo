package com.example.seven.androidfirstbookalldemo.C10;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.seven.androidfirstbookalldemo.R;

public class MyService extends Service {
    private final static String TAG = "MyService";
    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {
        public void  startDownload(){
            Log.d(TAG,"startDownload executed!");
        }
        public int getProgress(){
            Log.d(TAG,"getProgress executed!");
            return 0;
        }
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onCreate() {//服务创建时调用,只执行一次
        super.onCreate();
        Log.d(TAG, "onCreate: executed!");
        Intent intent  = new Intent(this,C10MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);//此方法会让MyService变成前台服务,并在系统状态栏显示出来


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {//每次服务启动的时候调用
        Log.d(TAG, "onStartCommand: executed! ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {//服务销毁时调用
        super.onDestroy();
        Log.d(TAG, "onDestroy: executed!");
    }
}
