package com.example.seven.androidfirstbookalldemo.c3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seven.androidfirstbookalldemo.R;

import java.util.List;

/**
 * Created by Seven on 2017/5/27.
 */

public class C3FruitAdapter extends ArrayAdapter<C3Fruit> {
    private int resourceId;

    /**
     * 将参数数据传递进来
     *
     * @param context            上下文
     * @param textViewResourceId ListView子项布局的Id
     * @param objects            数据
     */
    public C3FruitAdapter(Context context, int textViewResourceId, List<C3Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //这个方法在每个子项被滚动到屏幕内的时候会被调用
        C3Fruit fruit = getItem(position);//获取当前项的fruit的实例

        //为子项加载我们传入的布局
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        ImageView fruitImage = (ImageView) view.findViewById(R.id.C3_image_fruitImage);
        TextView fruitName = (TextView) view.findViewById(R.id.C3_textview_fruitName);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;
    }
}
