package com.example.xiaowu.listview.pinnedheaderlistview.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class PinnedHeaderListViewActivity extends Activity {

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        PinnedHeaderListView listView = (PinnedHeaderListView) findViewById(R.id.listview);
        
        List<ItemEntity> data = createTestData();
        
        // * �����µ�HeaderView�����ö���HeaderView
        View HeaderView = getLayoutInflater().inflate(R.layout.listview_item_header, listView, false);
        listView.setPinnedHeader(HeaderView);
        
        CustomAdapter customAdapter = new CustomAdapter(getApplication(), data);
        listView.setAdapter(customAdapter);
        
        listView.setOnScrollListener(customAdapter);
    }
    
    // ===========================================================
    // Methods
    // ===========================================================

    private List<ItemEntity> createTestData() {
        
        List<ItemEntity> data = new ArrayList<ItemEntity>();
        
        ItemEntity itemEntity1 = new ItemEntity("·�˼�", "������");
        ItemEntity itemEntity2 = new ItemEntity("·�˼�", "�Ա�ɽ");
        ItemEntity itemEntity3 = new ItemEntity("·�˼�", "���¸�");
        ItemEntity itemEntity4 = new ItemEntity("·�˼�", "������");
        ItemEntity itemEntity5 = new ItemEntity("�¼���", "**̰��");
        ItemEntity itemEntity6 = new ItemEntity("�¼���", "**����");
        ItemEntity itemEntity7 = new ItemEntity("�鼮��", "10��ѧ��***");
        ItemEntity itemEntity8 = new ItemEntity("�鼮��", "**��ȫ");
        ItemEntity itemEntity9 = new ItemEntity("�鼮��", "7�쾫ͨ**");
        ItemEntity itemEntity10 = new ItemEntity("�鼮��", "**�ؼ�");
        ItemEntity itemEntity11 = new ItemEntity("�鼮��", "**����");
        ItemEntity itemEntity12 = new ItemEntity("�ط���", "����");
        ItemEntity itemEntity13 = new ItemEntity("�ط���", "���");
        ItemEntity itemEntity14 = new ItemEntity("�ط���", "����");
        ItemEntity itemEntity15 = new ItemEntity("�ط���", "�Ϻ�");
        ItemEntity itemEntity16 = new ItemEntity("�ط���", "����");
        ItemEntity itemEntity17 = new ItemEntity("�ط���", "����");
        ItemEntity itemEntity18 = new ItemEntity("�ط���", "����");
        ItemEntity itemEntity19 = new ItemEntity("�ط���", "ɽ��");
        ItemEntity itemEntity20 = new ItemEntity("�ط���", "����");
        
        data.add(itemEntity1);
        data.add(itemEntity2);
        data.add(itemEntity3);
        data.add(itemEntity4);
        data.add(itemEntity5);
        data.add(itemEntity6);
        data.add(itemEntity7);
        data.add(itemEntity8);
        data.add(itemEntity9);
        data.add(itemEntity10);
        data.add(itemEntity11);
        data.add(itemEntity12);
        data.add(itemEntity13);
        data.add(itemEntity14);
        data.add(itemEntity15);
        data.add(itemEntity16);
        data.add(itemEntity17);
        data.add(itemEntity18);
        data.add(itemEntity19);
        data.add(itemEntity20);
        
        return data;
        
    }
    
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
	
	class ItemEntity {
		private String mTitle;
		private String mContent;
		
		public ItemEntity(String pTitle, String pContent) {
			mTitle = pTitle;
			mContent = pContent;
		}
		
		public String getTitle() {
			return mTitle;
		}
		public String getContent() {
			return mContent;
		}
	}
	
}