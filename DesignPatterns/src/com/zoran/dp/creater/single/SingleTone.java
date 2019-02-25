package com.zoran.dp.creater.single;

/**
 * SingleTone
 *
 * refer:
 * http://www.cnblogs.com/java-my-life/archive/2012/03/31/2425631.html
 */
public class SingleTone {

    public static void main(String[] args) {
        System.out.println(Single1.getInstance());
        System.out.println(Single1.getInstance());

        System.out.println(Single2.getInstance());
        System.out.println(Single2.getInstance());

        System.out.println(Single3.getInstance());
        System.out.println(Single3.getInstance());

        System.out.println(Single4.SINGLE);
        System.out.println(Single4.SINGLE);

    }

}

/**
 * 方式一：
 * 饿汉式
 */
class Single1 {
    private static final Single1 single = new Single1();

    private Single1(){
    }

    public static Single1 getInstance() {
        return single;
    }
}

/**
 * 方式二：
 * 懒汉式-静态内部类
 * 加载类级内部类的时候，才进行初始化！！
 */
class Single2 {

    private Single2(){
    }

    public static Single2 getInstance() {
        return Creator.single;
    }

    static class Creator {
        private static Single2 single = new Single2();
    }

}

/**
 * 方式三：
 * 懒汉式-双重检锁
 * 通过synchronized (Single3.class) {} 来保证线性安全
 */
class Single3 {
    //Core 双重检索 是需要添加关键字volatile！！
    private static volatile Single3 single;

    private Single3() {
    }

    public static Single3 getInstance() {

        if (single == null) {
            synchronized (Single3.class) {
                if (single == null) {
                    single = new Single3();
                }
            }
        }
        return single;
    }
}

/**
 * 方式四：
 * 懒汉式-枚举
 * 枚举的每个实例就是一个单例结构！
 */
enum Single4 {
    SINGLE,
}
