package com.zoran.dp.creater.prototype;

import java.util.Arrays;

/**
 * 原型模式 ProtoType
 *
 * refer:
 * http://www.cnblogs.com/java-my-life/archive/2012/04/11/2439387.html
 *
 * 重点：
 * Java语言提供的Cloneable接口只起一个作用，就是在运行时期通知Java虚拟机可以安全地在这个类上使用clone()方法
 *
 * 1.通过序列化实现深拷贝
 * 前提是对象实现了Serilizeable接口
 *
 * 2.有一些对象，比如线程(Thread)对象或Socket对象，是不能简单复制或共享的。不管是使用浅度克隆还是深度克隆
 * ，只要涉及这样的间接对象，就必须把间接对象设成transient而不予复制；或者由程序自行创建出相当的同种对象，权且当做复制件使用。
 */
public class ProtoType implements Cloneable{
    int age; //基本类型
    String name; //引用
    String[] source; //引用

    public ProtoType(int age, String name, String[] source) {
        this.age = age;
        this.name = name;
        this.source = source;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        String[] source  = null;
        ProtoType protoType = new ProtoType(29,"zqs", source = new String[]{"1","2"});
        ProtoType protoType1 = (ProtoType) protoType.clone();
        protoType.age = 24;
        protoType.name = "zsy";
        protoType.source[1] = "3";


        // ?clone()克隆之后，默认浅拷贝
        // 基本类型是重新创建
        // 引用类型是公用指向对象地址
        System.out.println(protoType1.name); //zqs
        System.out.println(protoType1.age); //0
        System.out.println(Arrays.toString(protoType1.source));  //null

    }
}
