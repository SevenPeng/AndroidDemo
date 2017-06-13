package com.example.seven.androidfirstbookalldemo.c5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

public class C5BroadcastActivity extends BaseActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c5_activity_boradcast);
        intentFilter = new IntentFilter();//创建IntentFilter的实例
        //网络状态发生改变时,系统发出"android.net.conn.CONNECTIVITY_CHANGE"的广播
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");//添加action
        networkChangeReceiver = new NetworkChangeReceiver();//创建NetworkChangeReceiver的实例
        registerReceiver(networkChangeReceiver, intentFilter);//注册

        Button btn_send_broadcast = (Button) findViewById(R.id.c5_btn_send_broadcast);
        btn_send_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.seven.androidfirstbookalldemo.MY_BROADCAST"); //植入需要广播的值
                //sendBroadcast(intent);//发送标准广播
                sendOrderedBroadcast(intent, null);//发送有序广播
            }
        });

        //发送本地广播
        localBroadcastManager = LocalBroadcastManager.getInstance(this);//获取实例
        Button btn_send_local_broadcast = (Button) findViewById(R.id.c5_btn_send_local_broadcast);
        btn_send_local_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.seven.androidfirstbookalldemo.LOCAL_BROADCAST"); //植入需要广播的值
                localBroadcastManager.sendBroadcast(intent);//发送本地广播
            }
        });
        intentFilter.addAction("com.example.seven.androidfirstbookalldemo.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);//注册本地广播监听器

        //强制下线
        Button btn_forceOffline = (Button)findViewById(R.id.c5_btn_force_offline);
        btn_forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.seven.androidfirstbookalldemo.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //动态注册的广播接收器必须取消注册
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //每当网络状态发生改变时就执行

            //获取ConnectivityManager的实例,该系统服务类用于管理网络连接
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            //获取NetworkInfo的实例
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                //网络可用
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            } else {//网络不可用
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class LocalReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
