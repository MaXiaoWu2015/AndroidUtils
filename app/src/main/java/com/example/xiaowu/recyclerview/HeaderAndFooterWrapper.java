package com.example.xiaowu.recyclerview;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by maxiaowu on 16/7/20.
 */
public class HeaderAndFooterWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView.Adapter mInnerAdapter;
    private Context mContext;
    private SparseArrayCompat<View> mHeadersView;
    private SparseArrayCompat<View> mFootersView;
    private static final int BASE_HEADER_ITEM=10000;
    private static final int BASE_FOOTER_ITEM=20000;
    public HeaderAndFooterWrapper(Context context, RecyclerView.Adapter adapter) {
        mContext=context;
        mInnerAdapter=adapter;
        mHeadersView=new SparseArrayCompat<>();
        mFootersView=new SparseArrayCompat<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeadersView.get(viewType)!=null)
        {
            //返回头部ViewHolder
        }else if (mFootersView.get(viewType)!=null)
        {
            //返回尾部ViewHolder
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mHeadersView.size()+mFootersView.size()+getRealItemCount();
    }

    public int getRealItemCount()
    {
        return mInnerAdapter.getItemCount();
    }
    public void addHeaderView(View view)
    {
        mHeadersView.put(mHeadersView.size()+BASE_HEADER_ITEM,view);
    }
    public void addFooterView(View view)
    {
        mFootersView.put(mFootersView.size()+BASE_FOOTER_ITEM,view);
    }

    public boolean isHeaderView(int position)
    {
        return position<mHeadersView.size();
    }
    public boolean isFooterView(int position)
    {
        return position>=getRealItemCount()+mFootersView.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position))
        {
            return mHeadersView.keyAt(position);
        }else if (isFooterView(position))
        {
            return mFootersView.keyAt(position);
        }
        return super.getItemViewType(position);
    }
}
