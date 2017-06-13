package com.example.seven.androidfirstbookalldemo.c3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seven.androidfirstbookalldemo.R;

import java.util.List;

/**RecyclerVIew 的适配器,用于提供拖拽的性能
 * Created by Seven on 2017/5/30.
 */

public class C3RecyclerFruitAdapter extends RecyclerView.Adapter<C3RecyclerFruitAdapter.ViewHolder> {
    /**
     * 数据容器
     */
    private List<C3Fruit> mFruirList;

    /**
     * 内部类
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        /**
         * 获取布局中的ImageView和TextView实例
         *
         * @param view 最外层布局
         */
        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.C3_image_fruitImage);
            fruitName = (TextView) view.findViewById(R.id.C3_textview_fruitName);
        }
    }

    /**
     * 构造函数,用于把展示的数据源传进来,并赋值给全局变量mFruitList
     *
     * @param fruitList 展示的数据源
     */
    public C3RecyclerFruitAdapter(List<C3Fruit> fruitList) {
        mFruirList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_c3_fruit_item, parent, false);  //向View中加载数据项
        final ViewHolder holder = new ViewHolder(view); //实例ViewHolder
        holder.fruitView.setOnClickListener(new View.OnClickListener() {//view注册事件
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                C3Fruit fruit = mFruirList.get(position);
                Toast.makeText(v.getContext(), "You click view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {//图片注册事件
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                C3Fruit fruit = mFruirList.get(position);
                Toast.makeText(v.getContext(), "You click image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        C3Fruit fruit = mFruirList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());//设置图片
        holder.fruitName.setText(fruit.getName());//设置文字
    }

    @Override
    public int getItemCount() {
        return mFruirList.size();
    }


}
