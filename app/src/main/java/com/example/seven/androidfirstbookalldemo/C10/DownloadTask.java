package com.example.seven.androidfirstbookalldemo.C10;


import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Seven on 2017/6/12.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer> {
    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_PAUSED = 2;
    public static final int TYPE_CANCELED = 3;
    private DownloadListener listener;
    private boolean isCanceled = false;
    private boolean isPaused = false;
    private int lastProgress;

    public DownloadTask(DownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        //所有代码在子线程中运行.在这里处理所有耗时任务.
        //在这个方法中不可进行ui操作.需要更新ui元素,调用publishProgress(Progreess...)方法完成
        InputStream is = null;
        RandomAccessFile saveFile = null;
        File file = null;
        try {
            long downloadedLength = 0; //记录已下载的文件长度
            String downloadUrl = params[0];
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory + fileName);
            if (file.exists()) {
                downloadedLength = file.length();
            }
            long contentLength =getContentLength(downloadUrl);
            if (contentLength ==0){
                return TYPE_FAILED;
            }else if(contentLength == downloadedLength){
                //下载的字节和文件总字节相等,说明下载已经完成了
                return TYPE_SUCCESS;
            }
            OkHttpClient client = new OkHttpClient();
            //Request request = new Request.Builder()
                    //断点下载,指定那个字节开始下载
              //      .addHeader("RANGE","bytes = "+)


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //后台任务开始之前调用,用于一些界面的初始化操作

        //  progressDialog.show();  //显示进度对话框
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //对UI进行操作,利用参数数值对界面元素进行相应带更新
    }

    private long getContentLength(String downloadUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        Response response = client.newCall(request).execute();
        if (response != null && response.isSuccessful()){
            long contentLength = response.body().contentLength();
            response.close();
            return contentLength;
        }
        return  0;
    }
}
