package com.example.xiaowu.WDJAppDetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaowu.androidutils.R;

import java.util.ArrayList;

/**
 * Created by matingting on 2017/1/16.
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppInfoHolder> {
    private Context mContext;
    private ArrayList<AppInfo> mAppInfos;
    private IOnItemClickListener mItemClickListener;

    public void setItemClickListener(
            IOnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public AppListAdapter(Context context,
            ArrayList<AppInfo> appInfos) {
        mContext = context;
        mAppInfos = appInfos;
    }

    @Override
    public AppInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.app_info_item,parent,false);
        return new AppInfoHolder(view);
    }

    @Override
    public void onBindViewHolder(AppInfoHolder holder, int position) {
        AppInfo appInfo=mAppInfos.get(position);
        if (appInfo!=null){
            holder.tv_name.setText(appInfo.appName);
            holder.tv_size.setText(appInfo.appSize);
            holder.tv_desc.setText(appInfo.appDesc);
            holder.tv_state.setText(appInfo.appState);
        }
    }

    @Override
    public int getItemCount() {
        return mAppInfos.size();
    }

     class AppInfoHolder extends RecyclerView.ViewHolder {
        public ImageView iv_icon;
        public TextView tv_name;
        public TextView tv_size;
        public TextView tv_state;
        public TextView tv_desc;

        public AppInfoHolder(View itemView) {
            super(itemView);
            iv_icon= (ImageView) itemView.findViewById(R.id.iv_app_icon);
            tv_name= (TextView) itemView.findViewById(R.id.tv_app_name);
            tv_size= (TextView) itemView.findViewById(R.id.tv_app_size);
            tv_desc= (TextView) itemView.findViewById(R.id.tv_app_desc);
            tv_state= (TextView) itemView.findViewById(R.id.tv_app_state);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener!=null){
                        mItemClickListener.onItemViewClick(view);
                    }
                }
            });


        }


    }


    public interface IOnItemClickListener {
        void onItemViewClick(View ItemView);
    }

}
