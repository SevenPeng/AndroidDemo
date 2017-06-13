package com.example.seven.androidfirstbookalldemo.c2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

public class C2MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);   //载入menu
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //menu的触发事件
        switch (item.getItemId()) {
            case R.id.first_item:
                Toast.makeText(this, "You click first item!", Toast.LENGTH_SHORT).show();
            case R.id.second_item:
                Toast.makeText(this, "You click second item!", Toast.LENGTH_SHORT).show();
            case R.id.thrid_item:
                Toast.makeText(this, "You click third item!", Toast.LENGTH_SHORT).show();
            case R.id.fourth_item:
                Toast.makeText(this, "You click fourth item!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ////输出其他活动返回带零食数据
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Toast.makeText(C2MainActivity.this, returnData, Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(C2MainActivity.this, "OnStart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        //测试活动的生命周期
        super.onResume();
        Toast.makeText(C2MainActivity.this, "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(C2MainActivity.this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(C2MainActivity.this, "OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(C2MainActivity.this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(C2MainActivity.this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempDate1 = "something you just type";
        int tempDate2 = 100;
        outState.putString("data_key_String", tempDate1);
        outState.putInt("data_key_int", tempDate2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_main);
        //无法通过
        if (savedInstanceState != null) {
            String tempData1 = savedInstanceState.getString("data_key_String");
            Toast.makeText(C2MainActivity.this, tempData1, Toast.LENGTH_SHORT).show();
        }

        //Log使用
        Log.v("C2MainActivity", "Log.v Test");
        Log.d("C2MainActivity", "Log.d Test");
        Log.i("C2MainActivity", "Log.i Test");
        Log.w("C2MainActivity", "Log.w Test");
        Log.e("C2MainActivity", "Log.e Test");

        Button button_1 = (Button) findViewById(R.id.button_main_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(C2MainActivity.this, "You Click Button_main_1", Toast.LENGTH_LONG).show();
            }
        });

        //结束活动
        Button button_finish = (Button) findViewById(R.id.button_main_finish);
        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //放入临时数据,跳转到活动1
        Button button_goFriAct = (Button) findViewById(R.id.button_main_GoFriAct);
        button_goFriAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "This is the data for C2FristActivity!!";
                Intent intent = new Intent(C2MainActivity.this, C2FristActivity.class);
                intent.putExtra("extra_data", data);
                startActivityForResult(intent, 1);
            }
        });

        //隐士使用intent,跳转到活动2
        Button button_goSecAct = (Button) findViewById(R.id.button_main_GoSecAct);
        button_goSecAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activity.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        //使用intent跳转的制定网页
        Button button_baidu = (Button) findViewById(R.id.button_main_baidu);
        button_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        })
        ;
        //使用intent跳转的电话界面
        Button button_tel = (Button) findViewById(R.id.button_main_tel);
        button_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{//try防止程序崩溃
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0123456789"));
                    startActivity(intent);
                }catch (SecurityException e){
                    e.printStackTrace();
                }

            }
        });
        //拨打电话版本2
        Button button_tel_v2 = (Button) findViewById(R.id.button_main_tel_v2);
        button_tel_v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(ContextCompat.checkSelfPermission(C2MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){//判读是否获得权限
                   ActivityCompat.requestPermissions(C2MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);//获取权限
               }else {
                   call();
               }

            }
        });


        //跳转活动
        Button button_goNorAct = (Button) findViewById(R.id.button_main_GoNorAct);
        Button button_goDiaAct = (Button) findViewById(R.id.button_main_GoDiaAct);
        button_goNorAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C2MainActivity.this, C2NormalActivity.class);
                startActivity(intent);
            }
        });
        button_goDiaAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C2MainActivity.this, C2DialogActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 拨打电话版本2内使用的函数
     */
    private  void call(){
        try{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0123456789"));
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
}
