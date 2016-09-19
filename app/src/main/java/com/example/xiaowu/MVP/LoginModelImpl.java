package com.example.xiaowu.MVP;

import android.text.TextUtils;

/**
 * Created by xiaowu on 2016-9-19.
 */
public class LoginModelImpl implements LoginModel {

    @Override
    public void login(String username, String password,LoginPresenter.onLoginFinishListener listener) {
        if (!TextUtils.isEmpty(username)&& !TextUtils.isEmpty(password)){
            listener.onSuccess();
        }else {
            listener.onError();
        }
    }
}
