package com.zoran.dp.creater.single;

/**
 * SingleTone
 *
 * refer:
 * http://www.cnblogs.com/java-my-life/archive/2012/03/31/2425631.html
 *
 * 1.关于单例模式中饱汉式与饿汉式的final关键字?
 * https://blog.csdn.net/qq_39986274/article/details/79215311
 * final 是否释放单例资源， 如果后期已经不需要到这个单利对象了，需要释放资源时，不声明为final就可以进行资源释放
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
    private static Single1 single = new Single1();

    static {
        System.out.println("Single1 static");
    }

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

    private Single2(){}

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
                    //NNNice_core: 在JDK1.5之前，由于new 创建对象分为3个步骤  步骤:创建引用 步骤:分配内存 步骤:赋值！
                    // 归咎于 Java 平台内存模型。内存模型允许所谓的“无序写入”，这也是这些习语失败的一个主要原因。 如果先赋值，则就为null了，导致逻辑出错！！
                    https://blog.csdn.net/chenchaofuck1/article/details/51702129
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
