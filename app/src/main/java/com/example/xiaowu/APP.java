package com.example.xiaowu;

import android.app.Application;
import android.content.Context;

import com.example.aaron.library.MLog;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by xiaowu on 2016-7-20.
 */
public class APP extends Application {
    public static Context context;
    private APPComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        MLog.init(true);
        appComponent = DaggerAPPComponent.builder().aPPModule(new APPModule(this)).build();
        Fresco.initialize(this);
    }
    public APPComponent getAppComponent(){
        return appComponent;
    }
}
