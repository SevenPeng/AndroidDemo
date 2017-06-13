package com.example.seven.androidfirstbookalldemo.c3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;


public class C3MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c3_main);
        Button button_toWidgst = (Button)findViewById(R.id.C3_main_btn_toWidgst);
        button_toWidgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C3MainActivity.this,C3UIWidgestTestActivity.class);
                startActivity(intent);
            }
        });
        Button button_toLayout = (Button)findViewById(R.id.C3_main_btn_toLayout);
        button_toLayout .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C3MainActivity.this,C3LayoutActivity.class);
                startActivity(intent);
            }
        });
        Button button_toView = (Button)findViewById(R.id.C3_main_btn_toView);
        button_toView .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C3MainActivity.this,C3ViewActivity.class);
                startActivity(intent);
            }
        });
        Button button_toListView = (Button)findViewById(R.id.C3_main_btn_toListView);
        button_toListView .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C3MainActivity.this,C3ListViewActivity.class);
                startActivity(intent);
            }
        });
        Button button_toRecyclerView = (Button)findViewById(R.id.C3_main_btn_toRecyclerView);
        button_toRecyclerView .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C3MainActivity.this,C3RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
