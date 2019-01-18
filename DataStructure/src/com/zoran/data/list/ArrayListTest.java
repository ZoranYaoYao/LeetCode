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
     * ʵ������
     */
    private static void methodTest(ArrayList<String> list) {
        /** ��*/
        list.add("0"); //1
        list.add(1, "1"); //2
        List<String> anotherList = new ArrayList<String>();anotherList.add("2");
        list.addAll(anotherList); //3
        list.addAll(0,anotherList); //4
        System.out.println(list);

        /** ɾ*/
        list.remove(0); //1
        list.remove("2"); //2

        //��ǰԪ���޳���һ�����ϵ�Ԫ��
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        anotherList = new ArrayList<>();anotherList.add("1");anotherList.add("3");
        list.removeAll(anotherList); //3
        System.out.println(list);

        //��2�����ϵĽ���
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        anotherList = new ArrayList<>();anotherList.add("1");anotherList.add("3");
        list.retainAll(anotherList);  //4
        System.out.println(list);

        /** ��*/
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        list.set(0, "LinkedHashMapTest");
        //�滻����Ԫ��
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return "B";
            }
        });
        System.out.println(list);

        /** ��*/
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        list.get(0);

        /** ����*/
        list = new ArrayList<>();list.add("1");list.add("2");list.add("3");
        for (String item: list) {
            System.out.println(item);
        }

        /** ��������API*/
        list = new ArrayList<>();list.add("1");list.add("2");list.add("33");
        int size = list.size();
        list.clear();
        list.isEmpty();
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); //��������,�������ʱ��������
            }
        });
        System.out.println(list);
        //List�Ŀ������� ������ǳ���������Զ��������Ҫ�������鿽������size����ֱ�����
        ArrayList<String> another = (ArrayList<String>) list.clone();
        System.out.println(another.size());

        //subList ��ȡ����ArrayList�е��ڲ���SubList
        list = new ArrayList<>();list.add("1");list.add("2");list.add("33");
        AbstractList<String> sublist = (ArrayList<String>) list.subList(0,1);

        //listת����
        list.toArray(new String[3]);
    }

    /***
     * ���þ�̬����
     */
    private static void staticMethodTest() {

    }


}
