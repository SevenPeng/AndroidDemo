package com.example.seven.androidfirstbookalldemo.c6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Seven on 2017/6/3.
 */

public class SevenDatabaseHelper extends SQLiteOpenHelper {
    public  static final String CREATE_BOOK = "create table Book(" +
            "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)";
    public  static final String CREATE_CATEGORY= "create table Category(" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)";

    private Context mContext;

    public SevenDatabaseHelper(Context context,String name,
                               SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        mContext  = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);

    }
}
