package com.example.xiaowu.listview.pinnedheaderlistview.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matingting on 2016/12/1.
 */

public class ItemEntity2 extends Entity{

    private static int entity=2;

    public ItemEntity2(String pTitle, String pContent) {
        super(pTitle,pContent);
    }


    public static List<ItemEntity2> createTestData() {

        List<ItemEntity2> data = new ArrayList<ItemEntity2>();

        ItemEntity2 itemEntity1 = new ItemEntity2("·�˼�", "������");
        ItemEntity2 itemEntity2 = new ItemEntity2("·�˼�", "�Ա�ɽ");
        ItemEntity2 itemEntity3 = new ItemEntity2("·�˼�", "���¸�");
        ItemEntity2 itemEntity4 = new ItemEntity2("·�˼�", "������");
        ItemEntity2 itemEntity5 = new ItemEntity2("�¼���", "**̰��");
        ItemEntity2 itemEntity6 = new ItemEntity2("�¼���", "**����");
        ItemEntity2 itemEntity7 = new ItemEntity2("�鼮��", "10��ѧ��***");
        ItemEntity2 itemEntity8 = new ItemEntity2("�鼮��", "**��ȫ");
        ItemEntity2 itemEntity9 = new ItemEntity2("�鼮��", "7�쾫ͨ**");


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
