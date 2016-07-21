package com.example.xiaowu;

import android.app.Application;
import android.content.Context;

/**
 * Created by xiaowu on 2016-7-20.
 */
public class APP extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
