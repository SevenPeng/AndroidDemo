package com.example.seven.androidfirstbookalldemo.c2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Seven on 2017/5/24.
 * 所有Activity要继承的父类,目前用于了解各个Activity的所在的类
 * 适用于新接手项目是寻找对应的类
 */

public class C2BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("C2BaseActivity", getClass().getSimpleName());  //输出类名
        C2ActivityCollector.addActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        C2ActivityCollector.removeActivity(this);
    }
}
