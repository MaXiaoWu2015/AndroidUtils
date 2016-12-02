package com.example.xiaowu.listview.pinnedheaderlistview.demo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaowu.androidutils.R;

import java.util.List;


public class CustomAdapter extends BaseAdapter  
		implements OnScrollListener , PinnedHeaderListView.PinnedHeaderAdapter {
	
	// ===========================================================
	// Constants
	// ===========================================================

	private static final String TAG = CustomAdapter.class.getSimpleName();
	private static final int TASK_TITLE=0;
	private static final int TASK_TODAY=1;
	private static final int TASK_DAILY=2;
	private static final int TASK_REWARD=3;
	private final List<ItemEntity1> mData1;
	private final List<ItemEntity2> mData2;

	// ===========================================================
	// Fields
	// ===========================================================

	private Context mContext;
	private List<ItemEntity> mData;
	private SparseArray<List<?>> mDataType;
	private LayoutInflater mLayoutInflater;
	
	// ===========================================================
	// Constructors
	// ===========================================================

	public CustomAdapter(Context pContext, List<ItemEntity> pData,List<ItemEntity1> pData1,List<ItemEntity2> pData2) {
		mContext = pContext;
		mData = pData;
		mData1 = pData1;
		mData2 = pData2;
//		mDataType.put(TASK_DAILY,mData);
//		mDataType.put(TASK_TODAY,mData1);
//		mDataType.put(TASK_REWARD,mData2);
		mLayoutInflater = LayoutInflater.from(mContext);
	}
	
	
	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================


	@Override
	public int getItemViewType(int position) {
		if (position==0 || position==mData.size()|| position==mData.size()+mData1.size()+1){
			return TASK_TITLE;
		}
		if (position>0 && position<mData.size()+1){
			return TASK_DAILY;
		}else if (position>mData.size()+1 && position<mData.size()+mData1.size()+2){
			return TASK_TODAY;
		}else if (position>mData.size()+mData1.size()+2 && position<mData.size()+mData1.size()+mData2.size()+3){
			return TASK_REWARD;
		}
		return -1;
	}

	@Override
	public int getViewTypeCount() {
		return 4;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		switch (getItemViewType(position)) {
			case TASK_DAILY: {
				if (null == convertView) {
					convertView = mLayoutInflater.inflate(R.layout.listview_item, null);
					viewHolder = new ViewHolder();
					viewHolder.title = (TextView) convertView.findViewById(R.id.title);
					viewHolder.content = (TextView) convertView.findViewById(R.id.content);
					viewHolder.contentIcon = (ImageView) convertView.findViewById(
							R.id.content_icon);
					convertView.setTag(viewHolder);
				} else {
					viewHolder = (ViewHolder) convertView.getTag();
				}

				// ��ȡ����
				ItemEntity itemEntity = (ItemEntity) getItem(position);
				viewHolder.content.setText(itemEntity.getContent());
				viewHolder.contentIcon.setImageResource(R.mipmap.ic_launcher);

				if (needTitle(position)) {
					// ��ʾ���Ⲣ��������
					viewHolder.title.setText(itemEntity.getTitle());
					viewHolder.title.setVisibility(View.VISIBLE);
				} else {
					// ���������ر���
					viewHolder.title.setVisibility(View.GONE);
				}
			}
			break;
			case TASK_TODAY:
				if (null == convertView) {
					convertView = mLayoutInflater.inflate(R.layout.listview_item, null);
					viewHolder = new ViewHolder();
					viewHolder.title = (TextView) convertView.findViewById(R.id.title);
					viewHolder.content = (TextView) convertView.findViewById(R.id.content);
					viewHolder.contentIcon = (ImageView) convertView.findViewById(
							R.id.content_icon);
					convertView.setTag(viewHolder);
				} else {
					viewHolder = (ViewHolder) convertView.getTag();
				}

				// ��ȡ����
				ItemEntity1 itemEntity1 = (ItemEntity1) getItem(position);
				viewHolder.content.setText(itemEntity1.getContent());
				viewHolder.contentIcon.setImageResource(R.mipmap.ic_launcher);

				if (needTitle(position)) {
					// ��ʾ���Ⲣ��������
					viewHolder.title.setText(itemEntity1.getTitle());
					viewHolder.title.setVisibility(View.VISIBLE);
					viewHolder = new ViewHolder();
					viewHolder.title = (TextView) convertView.findViewById(R.id.title);
					viewHolder.content = (TextView) convertView.findViewById(R.id.content);
					viewHolder.contentIcon = (ImageView) convertView.findViewById(
							R.id.content_icon);
					convertView.setTag(viewHolder);
				} else {
					// ���������ر���
					viewHolder.title.setVisibility(View.GONE);
				}

					break;
				case TASK_REWARD:
					if (null == convertView) {
						convertView = mLayoutInflater.inflate(R.layout.listview_item, null);
						viewHolder = new ViewHolder();
						viewHolder.title = (TextView) convertView.findViewById(R.id.title);
						viewHolder.content = (TextView) convertView.findViewById(R.id.content);
						viewHolder.contentIcon = (ImageView) convertView.findViewById(R.id.content_icon);
						convertView.setTag(viewHolder);
					}else {
						viewHolder = (ViewHolder) convertView.getTag();
					}
					// ��ȡ����
					ItemEntity2 itemEntity2 = (ItemEntity2) getItem(position);
					viewHolder.content.setText(itemEntity2.getContent());
					viewHolder.contentIcon.setImageResource(R.mipmap.ic_launcher);

					if ( needTitle(position) ) {
						// ��ʾ���Ⲣ��������
						viewHolder.title.setText(itemEntity2.getTitle());
						viewHolder.title.setVisibility(View.VISIBLE);
					} else {
						// ���������ر���
						viewHolder.title.setVisibility(View.GONE);
					}
					break;


        }

		convertView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext,""+getItemViewType(position),Toast.LENGTH_SHORT).show();
			}
		});
        
        return convertView;
	}
	
	@Override
	public int getCount() {
		if (null != mData) {
			return mData.size()+mData1.size()+mData2.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		switch (getItemViewType(position)){
			case TASK_DAILY:
			if (position>0 && position< mData.size())	{
				return mData.get(position);
			}
			case TASK_TODAY:
				if (position>=mData.size() && position< mData.size()+mData1.size())	{
					return mData1.get(position-mData.size());
				}
			case TASK_REWARD:
				if (position>=mData.size()+mData1.size() && position< mData.size()+mData1.size()+mData2.size())	{
					return  mData2.get(position-mData.size()-mData1.size());
				}
		}
//		if (null != mData && position < getCount()) {
//			return mData.get(position);
//		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		
		if ( view instanceof PinnedHeaderListView) {
			((PinnedHeaderListView) view).controlPinnedHeader(firstVisibleItem);	
		}
	}
	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
	}
	
	
	@Override
	public int getPinnedHeaderState(int position) {
		if (getCount() == 0 || position < 0) {
			return PinnedHeaderListView.PinnedHeaderAdapter.PINNED_HEADER_GONE;
		}
		
		if (isMove(position) == true) {
			return PinnedHeaderListView.PinnedHeaderAdapter.PINNED_HEADER_PUSHED_UP;
		}
		
		return PinnedHeaderListView.PinnedHeaderAdapter.PINNED_HEADER_VISIBLE;
	}


	@Override
	public void configurePinnedHeader(View headerView, int position, int alpaha) {
		// ���ñ��������
		Entity itemEntity = (Entity) getItem(position);
		String headerValue = itemEntity.getTitle();
		
		Log.e(TAG, "header = " + headerValue);
		
		if (!TextUtils.isEmpty(headerValue)) {
			TextView headerTextView = (TextView) headerView.findViewById(R.id.header);
			headerTextView.setText( headerValue );
		}
		
	}
	
	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * �ж��Ƿ���Ҫ��ʾ����
	 * 
	 * @param position
	 * @return
	 */
	private boolean needTitle(int position) {
		// ��һ���϶��Ƿ���
		if (position == 0) {
			return true;
		}
		
		// �쳣����
        if (position < 0) {
            return false;
        }
		 
		// ��ǰ  // ��һ��
		Entity currentEntity = (Entity) getItem(position);
		Entity previousEntity = (Entity) getItem(position - 1);
		if (null == currentEntity || null == previousEntity) {
            return false;
        }
		
		String currentTitle = currentEntity.getTitle();
		String previousTitle = previousEntity.getTitle();
		if (null == previousTitle || null == currentTitle) {
            return false;
        }
		
		// ��ǰitem����������һ��item��������ͬ�����ʾ��item���ڲ�ͬ����
		if (currentTitle.equals(previousTitle)) {
			return false;
		}
		
		return true;
	}


	private boolean isMove(int position) {
	    // ��ȡ��ǰ����һ��
	    Entity currentEntity = (Entity) getItem(position);
	    Entity nextEntity = (Entity) getItem(position + 1);
	    if (null == currentEntity || null == nextEntity) {
            return false;
        }

	    // ��ȡ����header����
	    String currentTitle = currentEntity.getTitle();
	    String nextTitle = nextEntity.getTitle();
	    if (null == currentTitle || null == nextTitle) {
            return false;
        }
	    
	    // ��ǰ��������һ��header����ǰ����Ҫ�ƶ���
	    if (!currentTitle.equals(nextTitle)) {
            return true;
        }
	    
	    return false;
	}
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	
	private class ViewHolder {
        TextView title;
        TextView content;
        ImageView contentIcon;
    }
	
}
