package com.zoran.data.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList
 *
 * refer:
 * https://www.cnblogs.com/chengxiao/p/6881974.html ��rebase��
 * https://www.cnblogs.com/dolphin0520/p/3938914.html
 * https://www.cnblogs.com/leesf456/p/5547853.html
 *
 * ԭ��
 * 1.���ʱ��ͨ����������������ԭ����������ɵ�
 * 2.CopyOnWriteArrayList��Դ��ܼ򵥣�����Ҫ�õ��Ŀ��յ�˼·��ʹ���ڵ����Ĺ����У�
 * ֻ��Object����֮ǰ��ĳ�����գ����������µ�Object���������Ա�֤�ڵ����Ĺ����в����׳�ConcurrentModificationException�쳣��
 *
 * �ŵ㣺
 * 1.CopyOnWriteArrayList��һ���̰߳�ȫ��������ʱ������ArrayList
 *
 * ȱ�㣺
 * 1.�ڴ�ռ������
 * 2.����һ��������
 *
 * ���ۣ�
 * 1.��������԰�ȫ�Ļ�����д��Ҫ���м��������ܱ�֤ʵʱ����Ҳ�����԰�ȫ�ģ�eg:Vector
 * 2.��ɾ����������������
 * 3.����д����������Ӱ�첻��Ĳ�������£�ѡ��CopyOnWriteArrayList
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        methodTest();

    }

    /***
     * ʵ������
     */
    private static void methodTest() {
        /** ��*/
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("0"); //1
        list.add(1, "1"); //2
        list.addIfAbsent("2"); //Core. û��ʱ���������
        CopyOnWriteArrayList<String> anotherList = new CopyOnWriteArrayList<String>();anotherList.add("2");
        list.addAll(anotherList); //3
        list.addAll(0,anotherList); //4
        System.out.println(list);

        /** ɾ*/
        list.remove(0); //1
        list.remove("2"); //2

        //��ǰԪ���޳���һ�����ϵ�Ԫ��
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        anotherList = new CopyOnWriteArrayList<>();anotherList.add("1");anotherList.add("3");
        list.removeAll(anotherList); //3
        System.out.println(list);

        //��2�����ϵĽ���
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        anotherList = new CopyOnWriteArrayList<>();anotherList.add("1");anotherList.add("3");
        list.retainAll(anotherList);  //4
        System.out.println(list);

        /** ��*/
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        list.set(0, "LinkedHashMapTest");
        //�滻����Ԫ��
//        list.replaceAll(new CopyOnWriteArrayList<String>() {
//            @Override
//            public String apply(String s) {
//                return "B";
//            }
//        });
        System.out.println(list);

        /** ��*/
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        list.get(0);

        /** ����*/
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        for (String item: list) {
            System.out.println(item);
        }

        /** ��������API*/
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("33");
        int size = list.size();
        list.clear();
        list.isEmpty();
//        list.sort(new CopyOnWriteArrayList<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length(); //��������,�������ʱ��������
//            }
//        });
        System.out.println(list);
        //List�Ŀ������� ������ǳ���������Զ��������Ҫ�������鿽������size����ֱ�����
        CopyOnWriteArrayList<String> another = (CopyOnWriteArrayList<String>) list.clone();
        System.out.println(another.size());

        //subList ��ȡ����ArrayList�е��ڲ���SubList
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("33");
//        CopyOnWriteArrayList<String> sublist = (CopyOnWriteArrayList<String>) list.subList(0,1);

        //listת����
        list.toArray(new String[3]);
    }
}
