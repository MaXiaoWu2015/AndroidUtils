package com.example.xiaowu.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by maxiaowu on 16/7/20.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    public ViewHolder(Context context,View itemView) {
        super(itemView);
        mContext=context;
    }

    public static RecyclerView.ViewHolder createViewHolder(Context context, int itemLayoutId, ViewGroup parent)
    {
        View itemView= LayoutInflater.from(context).inflate(itemLayoutId,parent,false);
        return new ViewHolder(context,itemView);
    }

    public static RecyclerView.ViewHolder createViewHolder(Context context,View view)
    {
        return new ViewHolder(context,view);
    }
}
