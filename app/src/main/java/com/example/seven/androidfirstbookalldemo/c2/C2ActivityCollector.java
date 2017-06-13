package com.example.seven.androidfirstbookalldemo.c2;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seven on 2017/5/24.
 * 用于管理所有的Activity
 */

public class C2ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();


    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 结束所有的activity , 目前无法结束当前进程,只能回到mainActivity
     */
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
