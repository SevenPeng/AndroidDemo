package com.example.seven.androidfirstbookalldemo.c6;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * 该Activity 主要用于测试FilePersistence存储数据
 * @author Seven
 * @date 2017-6-4
 */
public class FilePersistenceActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c6_activity_file_persistence);
        editText = (EditText) findViewById(R.id.c6_edit);
        String inputText = load();//获取保存的字符串
        if (!TextUtils.isEmpty(inputText)) {//若输入栏不为空
            editText.setText(inputText);//设置字符串
            editText.setSelection(inputText.length());//设置光标
            Toast.makeText(this, "Restoring successed", Toast.LENGTH_SHORT).show();//提示
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = editText.getText().toString();//获取输入的字符串
        save(inputText);//保存字符串
    }

    /**
     * 将字符串保存到文件中
     *
     * @param inputText 要保存的文字
     */
    public void save(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从data问价中提取所有的字符串
     *
     * @return 提取所有的字符串
     */
    public String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
