package com.example.seven.androidfirstbookalldemo.C10;


import android.os.AsyncTask;

/**
 * Created by Seven on 2017/6/12.
 */

public class DownloadTaskDemo extends AsyncTask<Void,Integer,Boolean> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //后台任务开始之前调用,用于一些界面的初始化操作

        //  progressDialog.show();  //显示进度对话框
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        //所有代码在子线程中运行.在这里处理所有耗时任务.
        //在这个方法中不可进行ui操作.需要更新ui元素,调用publishProgress(Progreess...)方法完成
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //对UI进行操作,利用参数数值对界面元素进行相应带更新
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        //后台任务完成后此方法将被调用
    }
}
