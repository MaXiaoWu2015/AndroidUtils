package com.example.xiaowu.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaowu.androidutils.R;

import java.util.ArrayList;

/**
 * Created by xiaowu on 2016-7-20.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerAdapter";
    private Context mContext;
    private ArrayList<String> mItemList;
    public RecyclerAdapter(Context context,ArrayList<String> dataset) {
        this.mContext=context;
        mItemList=dataset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(mContext).inflate(R.layout.recycler_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(itemView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_text.setText(mItemList.get(position));
        holder.iv_pic.setImageResource(R.drawable.index);
        Log.d(TAG, "onBindViewHolder: "+position);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_pic;
        private TextView tv_text;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv_pic= (ImageView) itemView.findViewById(R.id.iv_pic);
            tv_text= (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}
