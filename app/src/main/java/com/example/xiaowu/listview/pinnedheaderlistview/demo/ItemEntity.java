package com.example.xiaowu.listview.pinnedheaderlistview.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matingting on 2016/12/1.
 */

public class ItemEntity extends Entity{

    private static int entity=0;

    public ItemEntity(String pTitle, String pContent) {
        super(pTitle,pContent);
    }



    public static List<ItemEntity> createTestData() {

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


        data.add(itemEntity1);
        data.add(itemEntity2);
        data.add(itemEntity3);
        data.add(itemEntity4);
        data.add(itemEntity5);
        data.add(itemEntity6);
        data.add(itemEntity7);
        data.add(itemEntity8);
        data.add(itemEntity9);

        return data;

    }
}
