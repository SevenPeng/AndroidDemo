package com.example.seven.androidfirstbookalldemo.c5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.MainActivity;
import com.example.seven.androidfirstbookalldemo.R;

public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c5_activity_login);
        accountEdit = (EditText) findViewById(R.id.c5_edt_account);
        passwordEdit = (EditText) findViewById(R.id.c5_edt_paddword);
        login = (Button) findViewById(R.id.c5_btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                //如果账号是admin且密码是admin,就认为登录通过
                if (account.equals("admin") && password.equals("admin")) {

                    // SharedPreference记住密码代码部分
                    editor = pref.edit();
                    if (rememberPass.isChecked()) {//检查复选框是否被选中
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    // 记住密码代码部分

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });


        pref = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass = (CheckBox) findViewById(R.id.c6_chebox_remember_pass);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            //将账号和密码都设置到文本框中
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
    }
}
