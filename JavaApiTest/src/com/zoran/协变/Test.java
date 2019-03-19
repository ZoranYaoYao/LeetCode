package com.zoran.协变;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 协变
 *
 * refer：
 * https://www.cnblogs.com/hxy520/p/5725619.html
 *
 * List<? extends T> src : 集合里面的类型是必须是一宗类型，并且该类型是T的子类， 使用于get 遍历
 * List<? super T> des : 集合里面的类型是混合型的，是T一下的子类类型；适用于添加
 *
 * 底层原理：
 * 为了让泛型类型的申明和实例，也可以产生子父类关系，产生协变，
 * 比如 List<? extends Fruit> list = new ArrayList<Apple>();
 * 但是编译期间协变之后，是参考父类定义的泛型类型，所以有功能改变，具体指：
 * PECS GECS(get extends add super)
 *
 * 定义：
 * 在多态中，申明的父类，实际创建的子类。
 * 在某些情况下，即使某个对象不是数组的基类型，我们也可以把它赋值给数组元素。
 * 这种属性叫做协变（covariance。
 *
 * ???理解：
 * https://zhidao.baidu.com/question/1835914511550576740.html
 * https://blog.csdn.net/fangfengzhen115/article/details/78973258 rebase！！
 * https://www.cnblogs.com/suxuan/p/4970467.html
 *
 * 对 List<? super Fruit> 的理解：
 * 表示该集合里面的的是fruit的超类，可能是fruit集合，可能是Object集合
 * 所以在添加的时候可以是添加friut或者他的子集  =》
 * 等价于
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
         * 数组协变，申明时是基类，运行时协变成动态实例类。
         * 编译能通过，但是在用的时候很容易回出错！
         */
        Object[] fruits = new Banana[10];
        fruits[1] = banana;
//        fruits[2] = apple; //error
        System.out.println(Arrays.toString(fruits));


        /**
         * 泛型是不支持协变的，协变就是申明的类型可以隐士转换成父类！
         * 好处就是元素类型不会出错！
         */
//        List<Fruit> list = new ArrayList<Banana>();
        //解决方案 new 的多态性质！！List<? extends Fruit> 装水果的list 是 ArrayList<Banana>的父类！， 产生泛型关系！
        List<? extends Fruit> list = new ArrayList<Banana>();


        /**
         * ??最常用， 用的instance of
         */
        List<Fruit> listNormal = new ArrayList<>();
        listNormal.add(banana);
        listNormal.add(apple);
//        listNormal.add("aa");// "aa" 不是一个Fruit
        System.out.println("listNormal" + listNormal);


        /**泛型通配符， 集合赋值没有问题*/
        List<Banana> bananas = new ArrayList<>();
        bananas.add(new Banana("a"));bananas.add(new Banana("b"));
        //Nice_core 针对类型申明 ? extends Fruit ， Banana 是? extends Fruit的一种， 是申明是父类，实际是子类关系，所以是多态的关系
        List<? extends Fruit> list2 = bananas;
        System.out.println(list2);

        /**
         * PECS (productor extends consumer super)， GECS (get extends consumer super)
         * 对于泛型对象，不断的对这个泛型对象进行get()获取操作，相当于泛型就是productor, 所以用extends通配符
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
        //显示强转
        if (list4.get(1) instanceof Apple) {
            ((Apple)list4.get(1)).useApple();
        }

        copy(list4, list3);

        list4.addAll(list3); //添加没有问题
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
        System.out.println("Fruit 特有方法");
    }
}

class Banana extends Fruit{

    public Banana(String name) {
        super(name);
    }

    public void useBanana() {
        System.out.println("Banana 特有方法");
    }
}

class Apple extends Fruit {

    public Apple(String name) {
        super(name);
    }

    public void useApple() {
        System.out.println("Apple 特有方法");
    }
}