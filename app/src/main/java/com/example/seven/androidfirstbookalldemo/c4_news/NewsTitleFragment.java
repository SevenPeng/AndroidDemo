package com.example.seven.androidfirstbookalldemo.c4_news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seven.androidfirstbookalldemo.R;

/**
 * Created by Seven on 2017/6/2.
 */

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.c4_news_title_frag, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.c4_news_content)!=null){
            isTwoPane =true;//可以找到new_content_layout布局时为双页模式
        }else {
            isTwoPane = false;//找不到new_content_layout布局时为双页模式
        }
    }
}
