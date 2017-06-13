package com.example.seven.androidfirstbookalldemo.c6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

/**
 * 该Activity 主要用于测试SQLite数据库的功能
 * @author Seven
 * @date 2017-6-4
 */
public class DatabaseActivity extends AppCompatActivity {
    private SevenDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c6_activity_database);
        databaseHelper = new SevenDatabaseHelper(this, "BookStore.db", null, 2);//初始化数据库
        Button createDatabase = (Button) findViewById(R.id.c6_btn_create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.getWritableDatabase();//创建数据库
            }
        });


        Button c6_btn_add_data = (Button) findViewById(R.id.c6_btn_add_data);
        c6_btn_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase(); //获得数据库
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", "The Da Vinvi Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                database.insert("Book", null, values);//插入第一条数据
                values.clear();
                //开始组装第二条数据
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 16.96);
                database.insert("Book", null, values);//插入第二条数据


            }
        });
        Button c6_btn_update_data = (Button) findViewById(R.id.c6_btn_update_data);
        c6_btn_update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                database.update("Book", values, "name = ?", new String[]{"The Da Vinvi Code"});//更新数据库数据
                Toast.makeText(DatabaseActivity.this, "update success", Toast.LENGTH_SHORT).show();
            }
        });
        Button c6_btn_delete_data = (Button) findViewById(R.id.c6_btn_delete_data);
        c6_btn_delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                database.delete("Book", "pages > ?", new String[]{"500"});//删除数据库数据
                Toast.makeText(DatabaseActivity.this, "Delete success", Toast.LENGTH_SHORT).show();
            }
        });
        Button c6_btn_query_data = (Button) findViewById(R.id.c6_btn_query_data);
        c6_btn_query_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                //查询Book表中所有的数据
                Cursor cursor = database.query("Book", null, null, null, null, null, null);//获取游标
                if (cursor.moveToFirst()) {
                    do {
                        //遍历Cursor对象,取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int page = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("DatabaseActivity", name);
                        Log.d("DatabaseActivity", author);
                        Log.d("DatabaseActivity", " page: " + page);
                        Log.d("DatabaseActivity", "price: " + price);
                    } while (cursor.moveToNext());
                }cursor.close();
                Toast.makeText(DatabaseActivity.this, "Delete success", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
