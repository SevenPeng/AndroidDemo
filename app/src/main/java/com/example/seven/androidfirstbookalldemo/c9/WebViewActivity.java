package com.example.seven.androidfirstbookalldemo.c9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.seven.androidfirstbookalldemo.R;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c9_activity_web_view);
        WebView webView = (WebView)findViewById(R.id.c9_WebView_1);
        webView.getSettings().setJavaScriptEnabled(true);//支持JavaScript脚本支持
        webView.setWebViewClient(new WebViewClient());//跳转另外页面时,仍在WebView中显示
        webView.loadUrl("http://www.baidu.com");
    }
}
