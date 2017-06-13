package com.example.seven.androidfirstbookalldemo.c5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

/**
 * Created by Seven on 2017/6/2.
 */

public class BaseActivity extends android.app.Activity {
    private ForceOfflineReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onResume() {//注册ForceOfflineReceiver
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.seven.androidfirstbookalldemo.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {//取消注册ForceOfflineReceiver
        super.onPause();
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning!");
            builder.setMessage("You are forced to be offline. Please try to login again! ");
            builder.setCancelable(false);//设置为不可取消,当用户点击Back按钮不可继续使用程序
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();  //销毁所有活动
                    Intent intent = new Intent(context,LoginActivity.class);
                    context.startActivity(intent);//重启LoginActivity活动
                }
            });
            builder.show();
        }
    }


}
