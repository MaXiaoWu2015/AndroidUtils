package com.example.xiaowu.MVP;

/**
 * Created by xiaowu on 2016-9-19.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginPresenter.onLoginFinishListener{
    private LoginModelImpl loginModel;
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView){
        loginModel=new LoginModelImpl();
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
