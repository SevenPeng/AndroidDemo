package com.example.seven.androidfirstbookalldemo.c6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;
/**
 * 该Activity 主要用于测试haredPreferences存储数据的功能
 * @author Seven
 * @date 2017-6-4
 */
public class SharedPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c6_activity_shared_preferences);
        Button btn_saveData = (Button)findViewById(R.id.c6_btn_save);
        btn_saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.apply();
            }
        });
        Button btn_restoreData = (Button)findViewById(R.id.c6_btn_restore_data);
        btn_restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                int age = pref.getInt("age",0);
                Log.d("SharedPreferences", "onClick: "+age);
            }
        });
    }
}
