package com.example.xiaowu.listview.pinnedheaderlistview.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matingting on 2016/12/1.
 */

public class ItemEntity1 extends Entity{

    private static int entity=1;

    public ItemEntity1(String pTitle, String pContent) {
        super(pTitle,pContent);
    }

    public static List<ItemEntity1> createTestData() {

        List<ItemEntity1> data = new ArrayList<ItemEntity1>();

        ItemEntity1 itemEntity1 = new ItemEntity1("·�˼�", "������");
        ItemEntity1 itemEntity2 = new ItemEntity1("·�˼�", "�Ա�ɽ");
        ItemEntity1 itemEntity3 = new ItemEntity1("·�˼�", "���¸�");
        ItemEntity1 itemEntity4 = new ItemEntity1("·�˼�", "������");
        ItemEntity1 itemEntity5 = new ItemEntity1("�¼���", "**̰��");
        ItemEntity1 itemEntity6 = new ItemEntity1("�¼���", "**����");
        ItemEntity1 itemEntity7 = new ItemEntity1("�鼮��", "10��ѧ��***");
        ItemEntity1 itemEntity8 = new ItemEntity1("�鼮��", "**��ȫ");
        ItemEntity1 itemEntity9 = new ItemEntity1("�鼮��", "7�쾫ͨ**");


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
