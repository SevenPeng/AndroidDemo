package com.example.seven.androidfirstbookalldemo.c3;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

/**通过编写通用代码,转入TitleBar,为两个按钮编写响应事件
 * Created by Seven on 2017/5/27.
 */

public class C3TitleLayout extends LinearLayout {
    public C3TitleLayout(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        LayoutInflater.from(context).inflate(R.layout.layout_c3_title,this);
        Button titleBack = (Button)findViewById(R.id.C3_title_btn_titBack);
        Button titleEdit = (Button)findViewById(R.id.C3_title_btn_titEdit);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"You click Edit button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
