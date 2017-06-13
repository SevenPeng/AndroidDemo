package com.example.seven.androidfirstbookalldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.seven.androidfirstbookalldemo.C10.C10MainActivity;
import com.example.seven.androidfirstbookalldemo.C12.C12MainActivity;
import com.example.seven.androidfirstbookalldemo.c2.C2MainActivity;
import com.example.seven.androidfirstbookalldemo.c3.C3MainActivity;
import com.example.seven.androidfirstbookalldemo.c4.C4MainActivity;
import com.example.seven.androidfirstbookalldemo.c5.C5MainActivity;
import com.example.seven.androidfirstbookalldemo.c6.C6MainActivity;
import com.example.seven.androidfirstbookalldemo.c7.C7MainActivity;
import com.example.seven.androidfirstbookalldemo.c8.C8MainActivity;
import com.example.seven.androidfirstbookalldemo.c9.C9MainActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_main_GoToC2 = (Button) findViewById(R.id.button_main_GoToC2);
        button_main_GoToC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C2MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC3 = (Button) findViewById(R.id.button_main_GoToC3);
        button_main_GoToC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C3MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC4 = (Button) findViewById(R.id.button_main_GoToC4);
        button_main_GoToC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C4MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC5 = (Button) findViewById(R.id.button_main_GoToC5);
        button_main_GoToC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C5MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC6 = (Button) findViewById(R.id.button_main_GoToC6);
        button_main_GoToC6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C6MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC7 = (Button) findViewById(R.id.button_main_GoToC7);
        button_main_GoToC7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C7MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC8 = (Button) findViewById(R.id.button_main_GoToC8);
        button_main_GoToC8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C8MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC9 = (Button) findViewById(R.id.button_main_GoToC9);
        button_main_GoToC9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C9MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC10 = (Button) findViewById(R.id.button_main_GoToC10);
        button_main_GoToC10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C10MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_main_GoToC12 = (Button) findViewById(R.id.button_main_GoToC12);
        button_main_GoToC12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,C12MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
