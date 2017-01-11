package com.example.xiaowu.AndroidDataStorage.sharepreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.xiaowu.androidutils.R;
import com.example.xiaowu.androidutils.ToastUtil;

public class SharePfrefsActivity extends AppCompatActivity {
    private ToastUtil mToastUtil;
    private SharedPreferences mSharedPreferences;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButtonNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_pfrefs);
        initView();
        initData();
    }
    private void initData(){
        mToastUtil=new ToastUtil(this);
        mSharedPreferences=getSharedPreferences("testPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putBoolean("1",true);
        editor.putString("2","karry");
        editor.putString(null,"it's null");
        editor.putString("3","come on");
        editor.commit();
    }
    public void initView(){
        mButton1= (Button) findViewById(R.id.button5);
        mButton2= (Button) findViewById(R.id.button2);
        mButton3= (Button) findViewById(R.id.button6);
        mButtonNull= (Button) findViewById(R.id.button3);
    }
    public void clickOne(View view){
        mToastUtil.showToast(mSharedPreferences.getBoolean("1",false)+"");
    }
    public void clickTwo(View view){
        mToastUtil.showToast(mSharedPreferences.getString("2",""));
    }
    public void clickThree(View view){
        mToastUtil.showToast(mSharedPreferences.getString("3",""));
    }
    public void clickNull(View view){
        mToastUtil.showToast(mSharedPreferences.getString("null",""));
    }
}
