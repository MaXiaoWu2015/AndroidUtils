package com.example.xiaowu.MVP;

/**
 * Created by xiaowu on 2016-9-19.
 */
public interface LoginPresenter {
     interface onLoginFinishListener{
        void onSuccess();
         void onError();
    }
    void validateCredentials(String username,String password);
}
