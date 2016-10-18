package com.example.xiaowu.statusbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.xiaowu.androidutils.R;

public class ImmersiveActivity extends AppCompatActivity {
    private View decorview;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive);
        initVariables();
        hideSystemUI();
    }
    public void initVariables(){
        decorview=getWindow().getDecorView();
        imageView= (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSystemUI();
            }
        });
    }

    /**
     * View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION(这个标志不能单独使用)|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN:
     * 这两个flag是在确保隐藏导航栏和状态栏后，content区域大小不会改变(原SystemUI区域被系统
     * 默认填充，也可以通过重写fitSystemWindow(Rect)来修改填充内容)
     *
     * View.SYSTEM_UI_FLAG_LAYOUT_STABLE ：有这个flag，标题栏不可见，没有的话，标题栏可见
     * 上面三个标志要同时使用
     *
     * SYSTEM_UI_FLAG_IMMERSIVE_STICKY：当使用了STICKY沉浸式标签时，向内滑动会让系统栏临时显示，处于半透明
     * 状态，此时没有flag会被消除，系统UI可见性监听器也不会被触发，如果没有用户进行操作，系统一段时间会自动消失
     *
     * */
    public void hideSystemUI(){
        //在不改变conent区域大小的情况下，隐藏状态栏和导航栏
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
        View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE  //有这个flag，标题栏不可见，没有的话，标题栏可见
        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );


        //STICKY的沉浸式
//        decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
//                View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE  //有这个flag，标题栏不可见，没有的话，标题栏可见
//                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//        );

    }

    public void showSystemUI(){
        // This snippet shows the system bars. It does this by removing all the flags
        // except for the ones that make the content appear under the system bars.
        decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }
}
