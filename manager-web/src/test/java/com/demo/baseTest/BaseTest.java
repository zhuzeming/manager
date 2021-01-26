package com.demo.baseTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ZeMing Zhu
 * @date Create in 2021/1/26 10:11
 * @description 请添加描述
 */
public class BaseTest {

    ArrayList<Integer> arrayList = new ArrayList();
    LinkedList<Integer> linkedList = new LinkedList();

    /**
     * 初始化数组录入值
     *
     * @param length
     */
    private void initList(int length) {
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    /**
     * 深、浅拷贝
     * 浅拷贝只拷贝了地址，深拷贝拷贝了对象。
     *
     * @throws CloneNotSupportedException
     */
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        Student oldStu = new Student(3, new Score(33, 333));

        Student newStu = oldStu.clone();
        newStu.setId(6);
        newStu.getScore().setId(66);
        newStu.getScore().setLevel(666);

        System.out.println("oldStu:" + oldStu);
        System.out.println("newStu:" + newStu);
    }

    /**
     * list查询性能
     */
    @Test
    public void queryEffect() {
        int length = 50000;
        initList(length);
        long currency1 = System.currentTimeMillis();

        //普通循环
        //arrayList
        for (int i = 0; i < length; i++) {
            if (arrayList.get(i) == length - 1) break;
        }
        long currency2 = System.currentTimeMillis();
        System.out.println(currency2 - currency1);
        //linkedList
        for (int i = 0; i < length; i++) {
            if (linkedList.get(i) == length - 1) break;
        }
        long currency3 = System.currentTimeMillis();
        System.out.println(currency3 - currency2);

        //增强循环
        //array
        for (int i : arrayList) {
            if (i== length - 1) break;
        }
        long currency4 = System.currentTimeMillis();
        System.out.println(currency4 - currency3);
        //linked
        for (int i : linkedList) {
            if (i== length - 1) break;
        }
        long currency5 = System.currentTimeMillis();
        System.out.println(currency5 - currency4);

        //

    }

}
