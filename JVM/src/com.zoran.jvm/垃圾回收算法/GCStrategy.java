package com.zoran.jvm.垃圾回收算法;

/**
 * JVM垃圾回收算法
 * refer:
 * https://www.cnblogs.com/wabi87547568/p/5282892.html
 *
 * 一.分类
 * 1.标记和清除(mark-and-sweep)垃圾收集器
 *      缺点：内存地址不连贯，会产生碎片
 * 2.复制（Copying）算法
 *      缺点：虽然解决内存不连贯，但是内存分配大小会小一半，造成频繁GC
 * 3.标记压缩(Mark-Compact)算法
 *      根据：标记移动的算法，把或者的对象移动到连续的地址，然后在回收不要的内存！
 * 4.分代(Generation)算法
 *      般情况下将堆区划分为老年代（Tenured Generation）和新生代（Young Generation），
 *      老年代的特点是每次垃圾收集时只有少量对象需要被回收，而新生代的特点是每次垃圾回收时都有大量的对象需要被回收，
 *      那么就可以根据不同代的特点采取最适合的收集算法。
 *
 * 二. MinorGC(Young GC)  和 MajorGC(FullGC）何时触发？
 * https://blog.csdn.net/weixin_39788856/article/details/80388002
 *
 * Minor GC触发条件：当Eden区满时，触发Minor GC。
 *
 * Full GC触发条件：
 * （1）调用System.gc时，系统建议执行Full GC，但是不必然执行
 * （2）老年代空间不足
 * （3）方法去空间不足
 * （4）通过Minor GC后进入老年代的平均大小大于老年代的可用内存
 * （5）由Eden区、From Space区向To Space区复制时，对象大小大于To Space可用内存，则把该对象转存到老年代，且老年代的可用内存小于该对象大小。
 */
public class GCStrategy {

}
