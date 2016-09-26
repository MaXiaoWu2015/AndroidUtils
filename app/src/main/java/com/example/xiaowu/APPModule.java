package com.example.xiaowu;

import android.content.Context;

import com.example.xiaowu.androidutils.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiaowu on 2016-9-21.
 */
@Module
public class APPModule {

    Context context;

    public APPModule(Context context){
        this.context=context;
    }
    @Singleton
    @Provides
    public Context provideContext(){
        return context;
    }

    @Singleton
    @Provides
    public ToastUtil provideToastUtil(Context context){
        return new ToastUtil(context);
    }
}
