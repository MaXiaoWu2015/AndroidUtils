package com.example.xiaowu.MVP.mvp_retrofit_rxjava;

import dagger.Component;

/**
 * Created by xiaowu on 2016-9-26.
 */
@Component(dependencies = SplashModule.class)
public interface SplashComponent {
    void injectSplashActivity(SplashActivity splashActivity);
}
