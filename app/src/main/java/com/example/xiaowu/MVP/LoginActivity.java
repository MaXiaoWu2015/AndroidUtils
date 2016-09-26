package com.example.xiaowu.MVP;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiaowu.androidutils.R;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    @Inject
    LoginPresenterImpl loginPresenter;
    private LoginComponent loginComponent;
    private EditText username;
    private EditText password;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        loginPresenter=new LoginPresenterImpl(this);
        username= (EditText) findViewById(R.id.editText);
        password= (EditText) findViewById(R.id.editText2);
        button= (Button) findViewById(R.id.button);
        loginComponent=DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build();
        loginComponent.injectLoginActivity(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        button.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        Toast.makeText(this,"progressbar",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void usernameError() {
        Toast.makeText(this,"usernameError",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordError() {

    }

    @Override
    public void onClick(View view) {
        loginPresenter.validateCredentials(username.getText().toString(),password.getText().toString());
    }

}
