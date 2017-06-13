package com.example.seven.androidfirstbookalldemo.c9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.seven.androidfirstbookalldemo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class NetworkActivity extends AppCompatActivity implements View.OnClickListener {
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c9_activity_network);
        Button sendRequest = (Button) findViewById(R.id.c9_btn_send_request);
        Button sendRequestWithOkHttp = (Button) findViewById(R.id.c9_btn_send_request_okhttp);
        responseText = (TextView) findViewById(R.id.c9_response_text);
        sendRequest.setOnClickListener(this);
        sendRequestWithOkHttp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.c9_btn_send_request) {
            sendRequestWithHttpURLConnection();
        }
        if (v.getId() == R.id.c9_btn_send_request_okhttp) {
            sendRequestWithOkHttp();
        }
    }

    private void sendRequestWithHttpURLConnection() {
        // 开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    //注意要使用https格式.http无响应
                    URL url = new URL("https://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    //connection.setRequestMethod("POST");
                    //DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    //out.writeBytes("username=admin&password=1123456");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    // 下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            //访问指定的服务器地址是电脑主机
                            .url("http://10.0.2.2/get_data.json")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    //parseXMLWithPull(responseData);
                    //parseXMLWithSAX(responseData);
                    //parseXMLWithJSONObject(responseData);
                    parseXMLWithGSON(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseXMLWithPull(String xmldata) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//获取实例
            XmlPullParser xmlPullParser = factory.newPullParser();//获取对象
            xmlPullParser.setInput(new StringReader(xmldata));//设置服务器返回的XML数据
            int eventType = xmlPullParser.getEventType();//得到当前解析事件
            String id = "";
            String name = "";
            String version = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {//循环解析
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    //开始解析某个节点
                    case XmlPullParser.START_TAG: {
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    }
                    //完成解析某个节点
                    case XmlPullParser.END_TAG: {
                        if ("app".equals(nodeName)) {
                            Log.d("NetworkActivity", "id is " + id);
                            Log.d("NetworkActivity", "name is " + name);
                            Log.d("NetworkActivity", "version is " + version);
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            //将ContentHandler的实例设置到XMLReader中
            xmlReader.setContentHandler(handler);
            //开始执行解析
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithJSONObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("NetworkActivity", "id is " + id);
                Log.d("NetworkActivity", "name is " + name);
                Log.d("NetworkActivity", "version is " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void parseXMLWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = (List<App>) gson.fromJson(jsonData,new TypeToken<List<App>>(){}.getRawType());
        for (App app:appList){
            Log.d("NetworkActivity","id is :"+app.getId());
            Log.d("NetworkActivity","name is :"+app.getName());
            Log.d("NetworkActivity","version is :"+app.getVersion());
        }

    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //这里进行UI操作,将结果显示到界面上
                responseText.setText(response);
            }
        });
    }
}
