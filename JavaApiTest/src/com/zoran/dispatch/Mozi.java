package com.zoran.dispatch;

/**
 * refer：
 * http://www.cnblogs.com/java-my-life/archive/2012/06/14/2545381.html
 *
 * 1. 静态分派，动态分派
 *   静态分派（静态类型）：针对重载方法，静态方法
 *   动态分派（真实类型）：重写支持动态分派
 *
 * 2.一个方法所属的对象叫做方法的接收者，方法的接收者与方法的参数统称做方法的宗量
 *
 * 3.Java就是动态的单分派语言，同时又是静态的多分派语言
 *
 * 4.访问者模式是一种将数据操作与数据结构分离的设计模式
 */
public class Mozi {

    public void ride(Horse h){
        System.out.println("骑马");
    }

    public void ride(WhiteHorse wh){
        System.out.println("骑白马");
    }

    public void ride(BlackHorse bh){
        System.out.println("骑黑马");
    }

    public static void main(String[] args) {
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        Mozi mozi = new Mozi();
        mozi.ride(wh);
        mozi.ride(bh);
    }
}
