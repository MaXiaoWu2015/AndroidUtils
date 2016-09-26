package com.example.xiaowu.MVP;

import dagger.Component;

/**
 * Created by xiaowu on 2016-9-21.
 */
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void injectLoginActivity(LoginActivity loginActivity);
}
