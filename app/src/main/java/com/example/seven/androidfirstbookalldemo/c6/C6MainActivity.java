package com.example.seven.androidfirstbookalldemo.c6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;


/**
 * 该Activity 主要用于测试各种数据库的功能
 * @author Seven
 * @date 2017-6-4
 */
public class C6MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c6_activity_main);
        Button c6_btn_FilePersistence= (Button) findViewById(R.id.c6_btn_FilePersistence);
        c6_btn_FilePersistence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C6MainActivity.this,FilePersistenceActivity.class);
                startActivity(intent);
            }
        });
        Button c6_btn_sharedPreferences= (Button) findViewById(R.id.c6_btn_sharedPreferences);
        c6_btn_sharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C6MainActivity.this,SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });
        Button c6_btn_database= (Button) findViewById(R.id.c6_btn_database);
        c6_btn_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C6MainActivity.this,DatabaseActivity.class);
                startActivity(intent);
            }
        });
        Button c6_btn_LitePal= (Button) findViewById(R.id.c6_btn_LitePal);
        c6_btn_LitePal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C6MainActivity.this,LitePalActivity.class);
                startActivity(intent);
            }
        });
    }
}
