package com.example.seven.androidfirstbookalldemo.c2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

public class C2FristActivity extends C2BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("C2FristActivity","Task id is "+getTaskId());   //输出类的TaskId
        setContentView(R.layout.activity_c2_frist);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("C2FristActivity",data);
        Toast.makeText(C2FristActivity.this,data,Toast.LENGTH_LONG).show(); //输出得到的数据

        Log.d("C2FristActivity", this.toString());    //输出自身

        //放入需要返回带数据,并结束当前活动,
        Button button_back = (Button)findViewById(R.id.button_frist_back);
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return","return !!!!!!!!!");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //跳转到活动2
        Button button_FriAct = (Button)findViewById(R.id.button_frist_FriAct);
        button_FriAct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //使用规范的传残启动方法
                C2SecondActivity.actionStart(C2FristActivity.this,"data1","data2");

            }
        });
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("C2FristActivity","onRestart");
    }
}

