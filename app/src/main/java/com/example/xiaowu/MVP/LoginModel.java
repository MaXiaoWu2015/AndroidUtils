package com.example.xiaowu.MVP;

/**
 * Created by xiaowu on 2016-9-19.
 */
public interface LoginModel {
    void login(String username, String password,LoginPresenter.onLoginFinishListener listener);
}
