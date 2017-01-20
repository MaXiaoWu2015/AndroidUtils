package com.example.xiaowu.WDJAppDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.xiaowu.androidutils.Constant;
import com.example.xiaowu.androidutils.R;

import java.util.ArrayList;

public class WDJActivity extends AppCompatActivity {
    private RecyclerView mRvAppList;
    private AppListAdapter mAppListAdapter;
    private ArrayList<AppInfo> mAppInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wdj);
        initData();
        initView();
    }
    private void initView() {
        mRvAppList= (RecyclerView) findViewById(R.id.rv_applist);
        mAppListAdapter=new AppListAdapter(this,mAppInfos);
        mRvAppList.setAdapter(mAppListAdapter);
        mRvAppList.setLayoutManager(new LinearLayoutManager(this));
        mRvAppList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        mAppListAdapter.setItemClickListener(new AppListAdapter.IOnItemClickListener() {
            @Override
            public void onItemViewClick(View ItemView) {
                Intent intent=new Intent(WDJActivity.this,DetailActivity.class);
                intent.putExtra(Constant.ITEM_VIEW_TOP,ItemView.getTop());
                startActivity(intent);
                overridePendingTransition(0,0);//Activity无缝转场   第一个参数是Activity启动动画，第二个参数是Activity退出动画
            }
        });
    }
    private void initData(){
        mAppInfos=new ArrayList<>();

        AppInfo appInfo=new AppInfo();
        appInfo.appName="爱奇艺";
        appInfo.appIcon=R.drawable.ic_aqy;
        appInfo.appSize="30M";
        appInfo.appState="安装";
        appInfo.appDesc="爱奇艺精选视频占用内存小、耗电小、交互简单、播放流畅，在高中低档手机中均能完美运行；集中爱奇艺精心挑选内容，快速观看，找片！";
        mAppInfos.add(appInfo);

        AppInfo appInfo0=new AppInfo();
        appInfo0.appName="哔哩哔哩";
        appInfo0.appIcon=R.drawable.ic_bb;
        appInfo0.appSize="30M";
        appInfo0.appState="安装";
        appInfo0.appDesc="爱奇艺精选视频占用内存小、耗电小、交互简单、播放流畅，在高中低档手机中均能完美运行；集中爱奇艺精心挑选内容，快速观看，找片！";
        mAppInfos.add(appInfo0);

        AppInfo appInfo1=new AppInfo();
        appInfo1.appName="网易云音乐";
        appInfo1.appIcon=R.drawable.ic_yyy;
        appInfo1.appSize="30M";
        appInfo1.appState="安装";
        appInfo1.appDesc="爱奇艺精选视频占用内存小、耗电小、交互简单、播放流畅，在高中低档手机中均能完美运行；集中爱奇艺精心挑选内容，快速观看，找片！";
        mAppInfos.add(appInfo1);

        AppInfo appInfo2=new AppInfo();
        appInfo2.appName="QQ";
        appInfo2.appIcon=R.drawable.ic_qq;
        appInfo2.appSize="30M";
        appInfo2.appState="安装";
        appInfo2.appDesc="爱奇艺精选视频占用内存小、耗电小、交互简单、播放流畅，在高中低档手机中均能完美运行；集中爱奇艺精心挑选内容，快速观看，找片！";
        mAppInfos.add(appInfo2);

        AppInfo appInfo3=new AppInfo();
        appInfo3.appName="赤足";
        appInfo3.appIcon=R.drawable.ic_cz;
        appInfo3.appSize="30M";
        appInfo3.appState="安装";
        appInfo3.appDesc="爱奇艺精选视频占用内存小、耗电小、交互简单、播放流畅，在高中低档手机中均能完美运行；集中爱奇艺精心挑选内容，快速观看，找片！";
        mAppInfos.add(appInfo3);
    }
}
