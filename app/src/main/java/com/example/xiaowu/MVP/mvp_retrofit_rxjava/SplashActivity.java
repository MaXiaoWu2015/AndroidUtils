package com.example.xiaowu.MVP.mvp_retrofit_rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.xiaowu.androidutils.R;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements ApkUpdateView{
    @Inject
     ApkVersionUpdatePresenter presenter;
    private SplashComponent splashComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashComponent=DaggerSplashComponent.builder().splashModule(new SplashModule(this)).build();
        splashComponent.injectSplashActivity(this);

//        presenter
    }

    @Override
    public void showUpdateHint() {
        Toast.makeText(this,"有新版本！",Toast.LENGTH_LONG).show();
    }
}
