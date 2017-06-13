package com.example.seven.androidfirstbookalldemo.c4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;


public class C4MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c4_main);
        Button button = (Button)findViewById(R.id.C4_leftlayout_btn_1);
        button.setOnClickListener(this);
        Button button2 = (Button)findViewById(R.id.C4_leftlayout_btn_2);
        button2.setOnClickListener(this);
        replaceFragment(new C4RightFragment());//添加碎片

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.C4_leftlayout_btn_1:
                replaceFragment(new C4RightFragment2());
                break;
            case R.id.C4_leftlayout_btn_2:
                Intent intent = new Intent(C4MainActivity.this,C4Main2Activity.class);
                startActivity(intent);
            default:
                break;
        }
    }

    /**在容器中添加或替换的碎片
     * @param fragment 需要添加或替换的碎片
     */
    private void  replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();  //2.获取FragmentManager
//        FragmentTransaction transaction = fragmentManager.beginTransaction();//3.开启一个事务
//        transaction.replace(R.id.c4_layout_right,fragment);//4.向容器内添加或替换碎片
//        transaction.addToBackStack(null); //模拟返回栈
//        transaction.commit();//5.提交事务
    }

}
