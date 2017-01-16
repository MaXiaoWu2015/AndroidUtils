package com.example.xiaowu.WDJAppDetail;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xiaowu.androidutils.Constant;
import com.example.xiaowu.androidutils.R;

public class DetailActivity extends AppCompatActivity {
    private int mItemViewTop;
    private AppDetailRootLinearLayout mAppDetailRoot;
    private int initAlpha=150;
    private ColorDrawable mDetailRootDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mItemViewTop=getIntent().getIntExtra(Constant.ITEM_VIEW_TOP,0);

        mAppDetailRoot= (AppDetailRootLinearLayout) findViewById(R.id.ll_app_detail);
        Drawable detailRootDrawable=mAppDetailRoot.getBackground();
        mDetailRootDrawable= (ColorDrawable) detailRootDrawable;
        mDetailRootDrawable.setAlpha(initAlpha);

         mAppDetailRoot.setInitViewMarginTop(mItemViewTop);





    }
    private void initView() {
    }

    private void initData(){

    }
}
