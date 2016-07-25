package com.example.xiaowu.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.widget.TextView;

import com.example.xiaowu.androidutils.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xiaowu on 2016-7-20.
 */
public class TestActivity extends Activity {
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mAdapter;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    private ArrayList<String> mList= new ArrayList<String>(
            Arrays.asList("蜡笔小新","蜡笔小新","蜡笔小新","蜡笔小新",
            "蜡笔小新","蜡笔小新","蜡笔小新","蜡笔小新","蜡笔小新","蜡笔小新","蜡笔小新"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_test);

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.rc_list);
        recyclerView.setLayoutManager(mLinearLayoutManager=new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(mStaggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
//        recyclerView.setAdapter(mAdapter=new RecyclerAdapter(this,mList));
        mAdapter=new RecyclerAdapter(this,mList);
        recyclerView.setAdapter(mHeaderAndFooterWrapper=new HeaderAndFooterWrapper(mAdapter));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        TextView textView1=new TextView(this);
        textView1.setText("Header1");
        textView1.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView textView2=new TextView(this);
        textView2.setText("Header2");
        mHeaderAndFooterWrapper.addHeaderView(textView2);
        mHeaderAndFooterWrapper.addHeaderView(textView1);

        TextView textView3=new TextView(this);
        textView3.setText("Footer1");
        textView3.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView textView4=new TextView(this);
        textView4.setText("Footer2");
        mHeaderAndFooterWrapper.addFooterView(textView3);
        mHeaderAndFooterWrapper.addFooterView(textView4);




    }
}
