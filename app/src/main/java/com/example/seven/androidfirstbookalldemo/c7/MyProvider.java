package com.example.seven.androidfirstbookalldemo.c7;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Seven on 2017/6/8.
 */

public class MyProvider extends ContentProvider{
    private static final int TABLE1_DIR = 0;
    private static final int TABLE1_ITEM = 1;
    private static final int TABLE2_DIR = 2;
    private static final int TABLE2_ITEM = 3;
    private static UriMatcher uriMatcher;
    static {
        uriMatcher.addURI("com.example.seven.androidfirstbookalldemo","table1",TABLE1_DIR);
        uriMatcher.addURI("com.example.seven.androidfirstbookalldemo","table1/#",TABLE1_ITEM);
        uriMatcher.addURI("com.example.seven.androidfirstbookalldemo","table2",TABLE1_DIR);
        uriMatcher.addURI("com.example.seven.androidfirstbookalldemo","table2/#",TABLE1_ITEM);

    }
    @Override
    public boolean onCreate() {
        //初始化时调用,用于创建和升级数据库
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        //从内容提供器中查询数据
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                //查询table1中的所有数据
                break;
            case TABLE1_ITEM:
                //查询table1表中的单条数据
                break;
            case TABLE2_DIR:
                //查询table2中的所有数据
                break;
            case TABLE2_ITEM:
                //查询table2表中的单条数据
                break;
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.seven.androidfirstbookalldemo.table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.dir/vnd.com.example.seven.androidfirstbookalldemo.table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.seven.androidfirstbookalldemo.table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.dir/vnd.com.example.seven.androidfirstbookalldemo.table2";
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
