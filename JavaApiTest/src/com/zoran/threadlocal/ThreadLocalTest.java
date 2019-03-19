package com.zoran.threadlocal;

/**
 * ThreadLocal
 *
 * refer：
 * https://www.cnblogs.com/dolphin0520/p/3920407.html
 * https://www.jianshu.com/p/c2a482b48d17 rebase!
 *
 * 原理
 * 当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadLocals进行初始化，
 * 并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。
 *
 * 讲述：
 * ThreadLocal是指线程本地变量，适用于各个线程都保存一个属于线程自己的变量
 * ThreadLocal内部实现是在Thread类中有一个ThreadLocalMap的变量， ThreadLocalMap类里面有一个Entry对象数组
 * Entry类是一个继承weakReference的Threadlocal，并且里面包含了Value字段。
 * 最后通过对ThreadLocal这个变量的set()，get()方法首先获取当前线程，然后通过当前线程去找到线程的本地变量ThreadLocalMap对象
 * 最后通过这个map去查找key为当前这个ThreadLocal，对应的value值。
 */
public class ThreadLocalTest {



}
