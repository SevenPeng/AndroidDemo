package com.example.seven.androidfirstbookalldemo.C12;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

public class C12MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c12_activity_main);
        Toolbar toolbar  = (Toolbar)findViewById(R.id.c12_toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.c12_drawer_layout_1);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null  ){
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.img_no5);//设置图标
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.c12_menu_backup:
                Toast.makeText(this,"Backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.c12_menu_delete:
                Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.c12_menu_settings:
                Toast.makeText(this,"Setting",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
