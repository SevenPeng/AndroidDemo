package com.example.seven.androidfirstbookalldemo.c4_news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.seven.androidfirstbookalldemo.R;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c4_news_content);
        String newsTitle = getIntent().getStringExtra("news_title");//获取传入的新闻标题
        String newsContent = getIntent().getStringExtra("news_content");//获取传入的新闻内容
        NewsContentFragment newsContentFragment = (NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle,newsContent);//刷新newsContent_Fragment的界面
    }

    /** 该方法使得intnet传参一目了然
     * @param context 所在的Content
     * @param newsTitle 新标题
     * @param newsContent 新内容
     */
    public static void anctionStart(Context context,String newsTitle,String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }
}
