package com.example.seven.androidfirstbookalldemo.c5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;

import static com.example.seven.androidfirstbookalldemo.R.id.c5_btn_test;
import static com.example.seven.androidfirstbookalldemo.R.id.c5_btn_to_boradcast;
import static com.example.seven.androidfirstbookalldemo.R.id.c5_btn_to_pactice;

public class C5MainActivity extends BaseActivity {
    private static final String TAG = "C5MainActivity";
    private TestBroadcast testBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c5_activity_main);
        Button btn_Boradcast = (Button) findViewById(c5_btn_to_boradcast);
        btn_Boradcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C5MainActivity.this, C5BroadcastActivity.class);
                startActivity(intent);
            }
        });
        Button btn_Practice = (Button) findViewById(c5_btn_to_pactice);
        btn_Practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C5MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        Button btn_test = (Button) findViewById(c5_btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(C5MainActivity.this);
                Intent intent = new Intent("com.example.seven.androidfirstbookalldemo.TEST");
                localBroadcastManager.sendBroadcast(intent);
                Log.d(TAG, "onClick: ");
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.seven.androidfirstbookalldemo.TEST");
        testBroadcast = new TestBroadcast();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(testBroadcast, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (testBroadcast != null) {
            unregisterReceiver(testBroadcast);
            testBroadcast = null;
        }
    }

    class TestBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            Log.d(TAG, "onReceive: !!!!!!!!");  AlertDialog.Builder builder = new AlertDialog.Builder(context);
        }
    }
}
