package com.zoran.data.list;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        staticMethodTest();
        methodTest(list);

    }

    /***
     * 实例方法
     */
    private static void methodTest(ArrayList<String> list) {
        /** 增*/
        list.add("0"); //1
        list.add(1, "1"); //2
        List<String> anotherList = new ArrayList<String>();anotherList.add("2");
        list.addAll(anotherList); //3
        list.addAll(0,anotherList); //4
        System.out.println(list);

        /** 删*/
        list.remove(0); //1
        list.remove("2"); //2

        //求当前元素剔除另一个集合的元素
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        anotherList = new ArrayList<>();anotherList.add("1");anotherList.add("3");
        list.removeAll(anotherList); //3
        System.out.println(list);

        //求2个集合的交集
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        anotherList = new ArrayList<>();anotherList.add("1");anotherList.add("3");
        list.retainAll(anotherList);  //4
        System.out.println(list);

        /** 改*/
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        list.set(0, "LinkedHashMapTest");
        //替换所有元素
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return "B";
            }
        });
        System.out.println(list);

        /** 查*/
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        list.get(0);

        /** 遍历*/
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        for (String item: list) {
            System.out.println(item);
        }

        /** 其他常用API*/
        list = new ArrayList<>();list.add("1");list.add("2");list.add("33");
        int size = list.size();
        list.clear();
        list.isEmpty();
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); //长度升序,长度相等时，往后排
            }
        });
        System.out.println(list);
        //List的拷贝过程 是属于浅拷贝，所以对数组对象要进行数组拷贝，而size则是直接深拷贝
        ArrayList<String> another = (ArrayList<String>) list.clone();
        System.out.println(another.size());

        //subList 获取的是ArrayList中的内部类SubList
        list = new ArrayList<>();list.add("1");list.add("2");list.add("33");
        AbstractList<String> sublist = (ArrayList<String>) list.subList(0,1);

        //list转数组
        list.toArray(new String[3]);
    }

    /***
     * 常用静态方法
     */
    private static void staticMethodTest() {

    }


}
