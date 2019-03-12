package com.zoran.jvm.内存模型;

/**
 * refer:
 * https://blog.csdn.net/weixin_40739833/article/details/80717638
 *
 * GC过程回收机制
 * HotSpot默认Eden与Survivor的大小比例是8 : 1，也就是说Eden:Survivor From : Survivor To = 8:1:1。
 * 所以每次新生代可用内存空间为整个新生代容量的90%,而剩下的10%用来存放回收后存活的对象。
 *
 * 2.
 * https://blog.csdn.net/DevilDark/article/details/78238750
 * 堆内存的细分:
 * 新生代
 * 老年代
 *
 * 方法区里面的分类:
 * 永久代(常量池): 字符串常量池JDK1.6之前放在永久代，1.7之后移到了堆里，1.8之后移到了元空间
 * 元空间
 */
public class 堆 {
}
