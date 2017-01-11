package com.example.xiaowu.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by matingting on 2017/1/11.
 */

public class TestViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentArrayList;
    private Context mContext;
    public TestViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments,Context context) {
        super(fm);
        this.mFragmentArrayList=fragments;
        this.mContext=context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentArrayList==null?0:mFragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Test"+position;
    }
}
