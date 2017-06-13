package com.example.seven.androidfirstbookalldemo.c3;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

public class C3UIWidgestTestActivity extends AppCompatActivity implements OnClickListener {
    private EditText editText_1;
    private ImageView imageView_1;
    private ProgressBar progressBar_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c3_uiwidgest_test);
        Button button_ChaImg = (Button) findViewById(R.id.C3_button_ChaImg);
        Button button_DeTxOut = (Button) findViewById(R.id.C3_button_DeTxOut);
        Button button_ProBarUp = (Button) findViewById(R.id.C3_button_PorBarUp);
        Button button_ProBarGONE = (Button) findViewById(R.id.C3_button_PorBarGONE);
        Button button_AlertDialog= (Button) findViewById(R.id.C3_button_AlertDialog);
        Button button_ProgressDialog= (Button) findViewById(R.id.C3_button_ProgressDialog);
        button_DeTxOut.setOnClickListener(this);//响应事件必须注册!
        button_ChaImg.setOnClickListener(this);//响应事件必须注册!
        button_ProBarGONE.setOnClickListener(this); //响应事件必须注册!
        button_ProBarUp.setOnClickListener(this); //响应事件必须注册!
        button_AlertDialog.setOnClickListener(this); //响应事件必须注册!
        button_ProgressDialog.setOnClickListener(this); //响应事件必须注册!
        editText_1 = (EditText) findViewById(R.id.C3_editxt_1);
        imageView_1 = (ImageView) findViewById(R.id.C3_image_no1);
        progressBar_1 = (ProgressBar) findViewById(R.id.C3_progressbar_1);
    }

    @Override
    public void onClick(View v) {//使用接口实现Click事件
        switch (v.getId()) {
            case R.id.C3_button_DeTxOut:
                //提示输入文字
                String inputText = editText_1.getText().toString();
                Toast.makeText(C3UIWidgestTestActivity.this, inputText, Toast.LENGTH_SHORT).show();
            case R.id.C3_button_ChaImg:
                //改变图片
                imageView_1.setImageResource(R.drawable.img_no2);
            case R.id.C3_button_PorBarUp:
                //改变进度条,只可加不可减
                int progress1 = progressBar_1.getProgress();
                progress1 += 10;
                progressBar_1.setProgress(progress1);
               break;
            case R.id.C3_button_PorBarGONE:
                //来回出现和消失
                if (progressBar_1.getVisibility() == View.GONE) {
                    progressBar_1.setVisibility(View.VISIBLE);
                } else {
                    progressBar_1.setVisibility(View.GONE);
                }
                break;
            case R.id.C3_button_AlertDialog:
                AlertDialog.Builder dialog = new AlertDialog.Builder(C3UIWidgestTestActivity.this);
                dialog.setTitle("This is a Dialog");
                dialog.setMessage("Something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
            case R.id.C3_button_ProgressDialog:
                ProgressDialog progressDialog = new ProgressDialog(C3UIWidgestTestActivity.this);
                progressDialog.setTitle("ProgressDialog");
                progressDialog.setMessage("Loading....");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
