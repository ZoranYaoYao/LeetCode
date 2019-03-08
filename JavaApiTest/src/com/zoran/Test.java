package com.zoran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //数组可以协变
        Banana banana = new Banana("ba");
        Apple apple = new Apple("apple");

        Fruit[] fruits = new Banana[10];
        fruits[1] = banana;
        fruits[2] = apple;
        System.out.println(Arrays.toString(fruits));



        //集合父类泛型可以包含
        List<Fruit> list = new ArrayList<>();
        list.add(banana);
        list.add(apple);
        System.out.println(list);

//        List<Banana> list1 = new ArrayList<>();
//        list1.add(banana);
//        list1.add(apple);
    }
}

class Fruit {
    String name;

    public Fruit(String name) {
        this.name = name;
    }
}

class Banana extends Fruit{

    public Banana(String name) {
        super(name);
    }
}

class Apple extends Fruit {

    public Apple(String name) {
        super(name);
    }
}