package com.demo.baseTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

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
        Student oldStu = new Student(6, "66", new Score(666, 6666));

        Student newStu = oldStu.clone();
        newStu.setId(8);
        newStu.setName("88");
        newStu.getScore().setId(888);
        newStu.getScore().setLevel(8888);

        System.out.println("oldStu:" + oldStu);
        System.out.println("newStu:" + newStu);
    }

    /**
     * list查询性能
     */
    @Test
    public void queryEffect() {
        int length = 5000000;
        initList(length);
        long currency1 = System.currentTimeMillis();
        foreachList(currency1, length);
    }

    //普通循环
    private void commonList(long currency1, int length) {
        //array
        for (int i = 0; i < length; i++) {
            if (arrayList.get(i) == length - 1) break;
        }
        long currency2 = System.currentTimeMillis();
        System.out.println(currency2 - currency1);
        //linked
        for (int i = 0; i < length; i++) {
            if (linkedList.get(i) == length - 1) break;
        }
        long currency3 = System.currentTimeMillis();
        System.out.println(currency3 - currency2);
    }

    //增强循环
    private void enhanceList(long currency1, int length) {
        //array
        for (int i : arrayList) {
            if (i == length - 1) break;
        }
        long currency2 = System.currentTimeMillis();
        System.out.println(currency2 - currency1);
        //linked
        for (int i : linkedList) {
            if (i == length - 1) break;
        }
        long currency3 = System.currentTimeMillis();
        System.out.println(currency3 - currency2);
    }

    //iterator
    private void iteratorList(long currency1, int length) {
        //array
        Iterator iteratorArray = arrayList.iterator();
        while (iteratorArray.hasNext()) if ((int) iteratorArray.next() == length - 1) break;
        long currency2 = System.currentTimeMillis();
        System.out.println(currency2 - currency1);
        //linked
        Iterator iteratorLinked = linkedList.iterator();
        while (iteratorLinked.hasNext()) if ((int) iteratorLinked.next() == length - 1) break;
        long currency3 = System.currentTimeMillis();
        System.out.println(currency3 - currency2);
    }

    //foreach
    private void foreachList(long currency1, int length) {
        //array
        arrayList.forEach(p -> {
            if (p.equals(length - 1)) System.out.println();
        });
        long currency2 = System.currentTimeMillis();
        System.out.println(currency2 - currency1);
        //linked
        linkedList.forEach(p -> {
            if (p.equals(length - 1)) System.out.println();
        });
        long currency3 = System.currentTimeMillis();
        System.out.println(currency3 - currency2);
    }

    /**
     * 插入性能对比
     */
    @Test
    public void addEffect() {
        int length = 500000;
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();
        long currency1 = System.currentTimeMillis();
        //array
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        long currency2 = System.currentTimeMillis();
        System.out.println(currency2 - currency1);
        //linked
        for (int i = 0; i < length; i++) {
            linkedList.add(i);
        }
        long currency3 = System.currentTimeMillis();
        System.out.println(currency3 - currency2);
    }

    /**
     * subList 作用：返回list集合的部分视图
     * ArrayList LinkedList 原集合被改变长度后，subList会产生 ConcurrentModificationException 异常
     */
    @Test
    public void subList() {
//        ArrayList list = new ArrayList();
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> subList = list.subList(0, 3);
        list.set(1, 11);
//        list.remove(2);
//        list.add(1, 11);
        System.out.println(list.toString());
        System.out.println(subList.toString());
        System.out.println(subList.get(1));
    }

    /**
     * 序列化
     *
     * @throws Exception
     */
    @Test
    public void serialize() throws Exception {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "11", new Score(111, 1111)));
        studentList.add(new Student(2, "22"));
        studentList.add(new Student(3, "33"));
        studentList.add(new Student(4, "44"));
        studentList.add(new Student(5, "55"));
        studentList.add(new Student(6, "66"));

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\foo");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentList);
        objectOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("D:\\foo");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Student> box = (List<Student>) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(box.get(0).getScore().getLevel());
    }

    /**
     * copy List
     */
    @Test
    public void copyList() {
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            arrayList.add(i);
        }
        ArrayList<Integer> arrayList1 = (ArrayList<Integer>) arrayList.clone();
        System.out.println(arrayList.toString());
        System.out.println(arrayList1.toString());
    }

    @Test
    public void asList() {
        long[] arr = new long[]{1l, 4l, 3l, 3l};
        List list = Arrays.asList(arr);
        System.out.println(list.get(0));
    }

    /**
     * 不可变集合 Collections.unmodifiableList(list)
     */
    @Test
    public void unmodifiable() {
        List list = new ArrayList(Arrays.asList(4, 2, 2, 3));
        List modifyList = Collections.unmodifiableList(list);
//        modifyList.set(0, 1);
//        modifyList.add(4, 66);
        list.set(0, 2);
        System.out.println(modifyList.get(0));
    }


}
