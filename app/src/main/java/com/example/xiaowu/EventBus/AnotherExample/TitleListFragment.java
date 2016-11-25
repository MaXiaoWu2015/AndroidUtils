package com.example.xiaowu.EventBus.AnotherExample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaowu.EventBus.AnotherExample.view.TitleListLinearLayout;
import com.example.xiaowu.androidutils.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by matingting on 2016/11/25.
 */

public class TitleListFragment extends Fragment {
    private TitleListLinearLayout mTitleListLinearLayout;
    private ArrayList<String> mList=new ArrayList<>(Arrays.asList("news1","news2","news3","news4","news5","news6","news7","news8","news9"));
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.title_list_frag,container,false);
        mTitleListLinearLayout= (TitleListLinearLayout) view.findViewById(R.id.ll_title_list);
        mTitleListLinearLayout.setAdapter(new TitleListAdapter(getActivity(),mList));
        return view;
    }

}
