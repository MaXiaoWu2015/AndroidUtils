package com.example.xiaowu.MVP.mvp_retrofit_rxjava;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiaowu on 2016-9-26.
 */
@Module
public class SplashModule {
    private ApkUpdateView apkUpdateView;
    public SplashModule(ApkUpdateView view){
        apkUpdateView=view;
    }

    @Provides
    ApkUpdateView getApkUpdateView(){
        return apkUpdateView;
    }
}
