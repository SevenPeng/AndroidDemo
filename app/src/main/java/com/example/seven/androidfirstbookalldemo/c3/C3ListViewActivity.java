package com.example.seven.androidfirstbookalldemo.c3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.seven.androidfirstbookalldemo.R;

import java.util.ArrayList;
import java.util.List;

public class C3ListViewActivity extends AppCompatActivity {
    private List<C3Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c3_list_view);
        initFruit();//初始化水果
        C3FruitAdapter adapter = new  C3FruitAdapter(C3ListViewActivity.this,R.layout.layout_c3_fruit_item, fruitList);

        ListView listView = (ListView) findViewById(R.id.C3_ListView_lv1);
        //建立ListView和数据之间的关联
        listView.setAdapter(adapter);
    }

    private void initFruit() {
        for (int i = 0; i < 4; i++) {
            C3Fruit f1 = new C3Fruit("asdff1", R.drawable.img_no1);
            fruitList.add(f1);
            C3Fruit f2 = new C3Fruit("zxcyf2", R.drawable.img_no2);
            fruitList.add(f2);
            C3Fruit f3 = new C3Fruit("adfxf3", R.drawable.img_no3);
            fruitList.add(f3);
            C3Fruit f4 = new C3Fruit("fvbnb4", R.drawable.img_no4);
            fruitList.add(f4);
            C3Fruit f5 = new C3Fruit("xcvgdf5", R.drawable.img_no5);
            fruitList.add(f5);
            C3Fruit f6 = new C3Fruit("ftyewrt6", R.drawable.img_no6);
            fruitList.add(f6);
            C3Fruit f7 = new C3Fruit("fxcvbcvb7", R.drawable.img_no7);
            fruitList.add(f7);
            C3Fruit f8 = new C3Fruit("qerqewf8", R.drawable.img_no8);
            fruitList.add(f8);
            C3Fruit f9 = new C3Fruit("iopjhdf9", R.drawable.img_no9);
            fruitList.add(f9);
        }
    }
}
