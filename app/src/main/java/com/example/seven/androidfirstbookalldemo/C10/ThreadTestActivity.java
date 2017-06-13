package com.example.seven.androidfirstbookalldemo.C10;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.seven.androidfirstbookalldemo.R;

public class ThreadTestActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int UPDATE_TEXT = 1;    //用于表示更行textView这个动作
    private TextView textView;
    private Handler handlder = new Handler() {
        public void handleMessage(Message msg) {//重写方法
            switch (msg.what) {
                case UPDATE_TEXT:
                    //在这里可以进行UI操作
                    textView.setText("Nice to meet you! ");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c10_activity_thread_test);
        textView = (TextView) findViewById(R.id.c10_textview_1);
        Button changeText = (Button) findViewById(R.id.c10_btn_change_text);
        changeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.c10_btn_change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handlder.sendMessage(message);//将Message对象发送出去
                    }
                }).start();
                break;
            default:
                break;
        }

    }
}
