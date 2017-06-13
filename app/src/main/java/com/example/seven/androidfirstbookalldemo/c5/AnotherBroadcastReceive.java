package com.example.seven.androidfirstbookalldemo.c5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcastReceive extends BroadcastReceiver {
    public AnotherBroadcastReceive() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"receive in AnotherBroadcastRecriver",Toast.LENGTH_SHORT).show();
        abortBroadcast();//截断广播
    }
}
