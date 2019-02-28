package com.zoran.threadlocal;

/**
 * ThreadLocal
 *
 * refer：
 * https://www.cnblogs.com/dolphin0520/p/3920407.html
 *
 * 原理
 * 当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadLocals进行初始化，
 * 并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。
 */
public class ThreadLocalTest {
}
