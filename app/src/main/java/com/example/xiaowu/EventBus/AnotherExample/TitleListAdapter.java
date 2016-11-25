package com.example.xiaowu.EventBus.AnotherExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xiaowu.androidutils.R;

import java.util.ArrayList;

/**
 * Created by matingting on 2016/11/25.
 */

public class TitleListAdapter extends BaseAdapter {
//    private OnItemClickListener mOnItemClickListener;
    private Context mContext;
    private ArrayList<String> mDataset;
    private LoadNewsContentEvent mLoadNewsContentEvent;

    public TitleListAdapter(Context context, ArrayList<String> dataset) {
        mContext = context;
        mDataset = dataset;
        mLoadNewsContentEvent=new LoadNewsContentEvent();
    }

//    public void setOnItemClickListener(
//            OnItemClickListener onItemClickListener) {
//        mOnItemClickListener = onItemClickListener;
//    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TitleItemHolder itemHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.title_list_item,parent,false);
             itemHolder=new TitleItemHolder();
            convertView.setTag(itemHolder);
        }else {
            itemHolder= (TitleItemHolder) convertView.getTag();
        }
        itemHolder.tvTitle= (TextView) convertView.findViewById(R.id.tv_title);
        itemHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoadNewsContentEvent.loadNewsContent(""+position);

            }
        });
        return convertView;
    }

    class TitleItemHolder{
        public TextView tvTitle;
    }

//    interface OnItemClickListener{
//        void onItemClick();
//    }

}
