package com.example.seven.androidfirstbookalldemo.c6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;
/**
 * 该Activity 主要用于测试LitePal数据库的功能
 * @author Seven
 * @date 2017-6-4
 */
public class LitePalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c6_activity_lite_pal);
        Button createDatabase = (Button)findViewById(R.id.c6_btn_create_database2);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });
        Button c6_btn_add_data2= (Button)findViewById(R.id.c6_btn_add_data2);
        c6_btn_add_data2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//创表
                Book book = new Book();
                book.setName("Seven");
                book.setAuthor("Seven");
                book.setPages(777);
                book.setPrice(77.77);
                book.setPress("seven");
                book.save();
            }
        });
        Button c6_btn_update_data2 = (Button) findViewById(R.id.c6_btn_update_data2);
        c6_btn_update_data2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//更新数据
                Book book = new Book();
                book.setPrice(99.99);
                book.setPress("seven222");
                book.updateAll("price = ? and name = ?","88.88","Seven");
            }
        });
        Button c6_btn_delete_data2 = (Button) findViewById(R.id.c6_btn_delete_data2);
        c6_btn_delete_data2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//删除数据
                DataSupport.deleteAll(Book.class,"price < ?","80");
            }
        });
        Button c6_btn_query_data2 = (Button) findViewById(R.id.c6_btn_query_data2);
        c6_btn_query_data2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//查询数据
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book:books){
                    Log.d("LitePalActivity",book.getAuthor());
                    Log.d("LitePalActivity",book.getName());
                    Log.d("LitePalActivity",book.getPress());
                    Log.d("LitePalActivity"," "+book.getId());
                    Log.d("LitePalActivity"," "+book.getPages());
                    Log.d("LitePalActivity"," "+book.getPrice());
                }
            }
        });
    }
}
