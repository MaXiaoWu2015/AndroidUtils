package com.example.xiaowu.MVP;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiaowu on 2016-9-22.
 */
@Module
public class LoginModule {
    private  LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    LoginView provideLoginView(){
        return view;
    }



}
