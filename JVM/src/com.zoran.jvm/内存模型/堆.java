package com.zoran.jvm.内存模型;

/**
 * refer:
 * https://blog.csdn.net/weixin_40739833/article/details/80717638
 *
 * GC过程回收机制
 * HotSpot默认Eden与Survivor的大小比例是8 : 1，也就是说Eden:Survivor From : Survivor To = 8:1:1。
 * 所以每次新生代可用内存空间为整个新生代容量的90%,而剩下的10%用来存放回收后存活的对象。
 */
public class 堆 {
}
