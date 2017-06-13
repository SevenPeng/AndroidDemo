package com.example.seven.androidfirstbookalldemo.c3;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.seven.androidfirstbookalldemo.R;

public class C3ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c3_view);
        //添加类自编actionBar把自带的隐藏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null ){
            actionBar.hide();
        }
    }
}
