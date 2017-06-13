package com.example.seven.androidfirstbookalldemo.C10;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;

public class C10MainActivity extends AppCompatActivity implements View.OnClickListener{
    private  MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {//活动与服务成功绑定的时候调用
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };//创建匿名类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c10_activity_main);
        Button ThreadTest = (Button)findViewById(R.id.c10_btn_to_thread_test);
        ThreadTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C10MainActivity.this,ThreadTestActivity.class);
                startActivity(intent);
            }
        });
        Button startService = (Button)findViewById(R.id.c10_btn_start_service);
        Button stopService = (Button)findViewById(R.id.c10_btn_stop_service);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);

        Button bindService  = (Button) findViewById(R.id.c10_btn_bind_service);
        Button unbindService = (Button)findViewById(R.id.c10_btn_unbind_service);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);

        Button startIntentService = (Button)findViewById(R.id.c10_btn_start_intent_service);
        startIntentService.setOnClickListener(this);

        Button ServicePractice = (Button)findViewById(R.id.c10_btn_to_service_practice);
        ServicePractice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c10_btn_start_service:
                Intent startIntent = new Intent(this,MyService.class);
                startService(startIntent);//启动服务
                break;
            case R.id.c10_btn_stop_service:
                Intent stopIntent = new Intent(this,MyService.class);
                stopService(stopIntent);//停止服务
                break;
            case R.id.c10_btn_bind_service:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);//绑定服务
                break;
            case R.id.c10_btn_unbind_service:
                unbindService(connection);//解除服务
            case R.id.c10_btn_start_intent_service:
                //打印主线程的id
                Log.d("C10MainActivity","Thread id  is "+Thread.currentThread().getId());
                Intent intentService = new Intent(this,MyIntentService.class);
                startService(intentService);
                break;
            case R.id.c10_activity_service_practice:
                Intent practiceIntent = new Intent(this,ServicePracticeActivity.class);
                startActivity(practiceIntent);
            default:
                break;
        }
    }
}
