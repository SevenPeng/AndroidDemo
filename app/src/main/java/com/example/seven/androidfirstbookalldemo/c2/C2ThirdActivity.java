package com.example.seven.androidfirstbookalldemo.c2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;

public class C2ThirdActivity extends C2BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_thrid);
        Log.d("C2ThirdActivity","Task id is "+getTaskId());
        Button button_finish = (Button)findViewById(R.id.button_thrid_finish);
        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C2ActivityCollector.finishAll();
               // android.os.killProcess(android.os.Process.myPid());   //用于杀死当前进程,目前不知道代码该放位置
            }
        });
    }
}
