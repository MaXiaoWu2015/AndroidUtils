package com.example.xiaowu.MVP;

/**
 * Created by xiaowu on 2016-9-19.
 */
public interface LoginView {
    void showProgress();
    void hideProgress();
    void usernameError();
    void passwordError();
}
