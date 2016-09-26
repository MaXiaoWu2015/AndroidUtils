package com.example.xiaowu.MVP;

import javax.inject.Inject;

/**
 * Created by xiaowu on 2016-9-19.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginPresenter.onLoginFinishListener{

    @Inject
    public LoginModelImpl loginModel;
    private LoginView loginView;

    @Inject
    public LoginPresenterImpl(LoginView loginView){
        this.loginView=loginView;
    }


    @Override
    public void validateCredentials(String username, String password) {
        loginModel.login(username,password,this);
    }

    @Override
    public void onSuccess() {
        loginView.showProgress();
    }

    @Override
    public void onError() {
        loginView.usernameError();
//        loginView.passwordError();
    }
}
