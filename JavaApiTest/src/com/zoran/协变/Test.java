package com.zoran.Э��;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Э��
 *
 * refer��
 * https://www.cnblogs.com/hxy520/p/5725619.html
 *
 * List<? extends T> src : ��������������Ǳ�����һ�����ͣ����Ҹ�������T�����࣬ ʹ����get ����
 * List<? super T> des : ��������������ǻ���͵ģ���Tһ�µ��������ͣ����������
 *
 * �ײ�ԭ��
 * Ϊ���÷������͵�������ʵ����Ҳ���Բ����Ӹ����ϵ������Э�䣬
 * ���� List<? extends Fruit> list = new ArrayList<Apple>();
 * ���Ǳ����ڼ�Э��֮���ǲο����ඨ��ķ������ͣ������й��ܸı䣬����ָ��
 * PECS GECS(get extends add super)
 *
 * ���壺
 * �ڶ�̬�У������ĸ��࣬ʵ�ʴ��������ࡣ
 * ��ĳЩ����£���ʹĳ������������Ļ����ͣ�����Ҳ���԰�����ֵ������Ԫ�ء�
 * �������Խ���Э�䣨covariance��
 *
 * ???��⣺
 * https://zhidao.baidu.com/question/1835914511550576740.html
 * https://blog.csdn.net/fangfengzhen115/article/details/78973258 rebase����
 * https://www.cnblogs.com/suxuan/p/4970467.html
 *
 * �� List<? super Fruit> ����⣺
 * ��ʾ�ü�������ĵ���fruit�ĳ��࣬������fruit���ϣ�������Object����
 * ��������ӵ�ʱ����������friut���������Ӽ�  =��
 * �ȼ���
 *         List<Fruit> listNormal = new ArrayList<>();
 *         listNormal.add(banana);
 *         listNormal.add(apple);
 *         System.out.println("listNormal" + listNormal);
 */
public class Test {

    public static Test test;

    public static void main(String[] args) {

        Banana banana = new Banana("ba");
        Apple apple = new Apple("apple");

        /**
         * ����Э�䣬����ʱ�ǻ��࣬����ʱЭ��ɶ�̬ʵ���ࡣ
         * ������ͨ�����������õ�ʱ������׻س���
         */
        Object[] fruits = new Banana[10];
        fruits[1] = banana;
//        fruits[2] = apple; //error
        System.out.println(Arrays.toString(fruits));


        /**
         * �����ǲ�֧��Э��ģ�Э��������������Ϳ�����ʿת���ɸ��࣡
         * �ô�����Ԫ�����Ͳ������
         */
//        List<Fruit> list = new ArrayList<Banana>();
        //������� new �Ķ�̬���ʣ���List<? extends Fruit> װˮ����list �� ArrayList<Banana>�ĸ��࣡�� �������͹�ϵ��
        List<? extends Fruit> list = new ArrayList<Banana>();


        /**
         * ??��ã� �õ�instance of
         */
        List<Fruit> listNormal = new ArrayList<>();
        listNormal.add(banana);
        listNormal.add(apple);
//        listNormal.add("aa");// "aa" ����һ��Fruit
        System.out.println("listNormal" + listNormal);


        /**����ͨ����� ���ϸ�ֵû������*/
        List<Banana> bananas = new ArrayList<>();
        bananas.add(new Banana("a"));bananas.add(new Banana("b"));
        //Nice_core ����������� ? extends Fruit �� Banana ��? extends Fruit��һ�֣� �������Ǹ��࣬ʵ���������ϵ�������Ƕ�̬�Ĺ�ϵ
        List<? extends Fruit> list2 = bananas;
        System.out.println(list2);

        /**
         * PECS (productor extends consumer super)�� GECS (get extends consumer super)
         * ���ڷ��Ͷ��󣬲��ϵĶ�������Ͷ������get()��ȡ�������൱�ڷ��;���productor, ������extendsͨ���
         */

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("apple 1"));apples.add(new Apple("apple 2"));
        List<? extends Fruit> list3 = apples;
        for (Fruit fruit : list3) {
            System.out.println("GE -> " + fruit.getName());
        }

        List<? super Fruit> list4 = new ArrayList<>();
        list4.add(new Banana("a"));
        list4.add(new Apple("b"));
        list4.add(new Fruit("c"));
//        list4.add(new Object()); //Error
        System.out.println("CS-- > " + list4);
        //��ʾǿת
        if (list4.get(1) instanceof Apple) {
            ((Apple)list4.get(1)).useApple();
        }

        copy(list4, list3);

        list4.addAll(list3); //���û������
    }

    public static <T> void copy(List<? super T> des, List<? extends T> src) {
        for (T item : src) {
            des.add(item);
        }
        System.out.println("--->" + des);
    }
}

class Fruit {
    String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void userFruit() {
        System.out.println("Fruit ���з���");
    }
}

class Banana extends Fruit{

    public Banana(String name) {
        super(name);
    }

    public void useBanana() {
        System.out.println("Banana ���з���");
    }
}

class Apple extends Fruit {

    public Apple(String name) {
        super(name);
    }

    public void useApple() {
        System.out.println("Apple ���з���");
    }
}