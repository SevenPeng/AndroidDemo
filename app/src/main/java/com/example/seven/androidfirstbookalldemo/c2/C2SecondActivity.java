package com.example.seven.androidfirstbookalldemo.c2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;

public class C2SecondActivity extends C2BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("C2SecondActivity", "Task id is " + getTaskId());  //输出活动TaskID
        setContentView(R.layout.activity_c2_second);

        //跳转活动2
        Button button_goFriAct = (Button) findViewById(R.id.button_second_goFriAct);
        button_goFriAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C2SecondActivity.this, C2FristActivity.class);
                startActivity(intent);
            }
        });
        //跳转活动3
        Button button_goThiAct = (Button) findViewById(R.id.button_second_goThiAct);
        button_goThiAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C2SecondActivity.this, C2ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("C2SecondActivity", "onDestroy");
    }

    /** 传参启动活动的规范方法.
     * @param context   当前活动
     * @param data1 数据1
     * @param data2 数据2
     */
    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, C2SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);

    }
}
