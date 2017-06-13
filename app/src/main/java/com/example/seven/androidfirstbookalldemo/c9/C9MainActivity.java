package com.example.seven.androidfirstbookalldemo.c9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;

public class C9MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c9_activity_main);
        Button webView = (Button)findViewById(R.id.c9_btn_web_view);
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(C9MainActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });
        Button network = (Button)findViewById(R.id.c9_btn_net_work);
        network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(C9MainActivity.this,NetworkActivity.class);
                startActivity(intent);
            }
        });
    }
}
