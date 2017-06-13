package com.example.seven.androidfirstbookalldemo.c9;

/**
 * Created by Seven on 2017/6/12.
 */

public interface HttpCallbackListener {
    void onFinish(String  response);
    void onError(Exception e );
}
