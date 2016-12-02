package com.example.xiaowu.listview.pinnedheaderlistview.demo;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.xiaowu.androidutils.R;

import java.util.List;

public class PinnedHeaderListViewActivity extends Activity {

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin_activity_main);
        
        PinnedHeaderListView listView = (PinnedHeaderListView) findViewById(R.id.listview);
        
        List<ItemEntity> data = ItemEntity.createTestData();
        List<ItemEntity1> data1 = ItemEntity1.createTestData();
        List<ItemEntity2> data2 = ItemEntity2.createTestData();


        // * �����µ�HeaderView�����ö���HeaderView
        View HeaderView = getLayoutInflater().inflate(R.layout.listview_item_header, listView, false);
        listView.setPinnedHeader(HeaderView);
        
        CustomAdapter customAdapter = new CustomAdapter(getApplication(), data,data1,data2);
        listView.setAdapter(customAdapter);
        
        listView.setOnScrollListener(customAdapter);
    }
    
    // ===========================================================
    // Methods
    // ===========================================================


    
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
//
//	class ItemEntity {
//		private String mTitle;
//		private String mContent;
//
//		public ItemEntity(String pTitle, String pContent) {
//			mTitle = pTitle;
//			mContent = pContent;
//		}
//
//		public String getTitle() {
//			return mTitle;
//		}
//		public String getContent() {
//			return mContent;
//		}
//	}
	
}