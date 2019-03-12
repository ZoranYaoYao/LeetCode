package com.zoran.jvm.内存模型;

/**
 * 方法区
 * 方法区里存储的是class文件的信息 和 动态常量池，class文件的信息包括类信息和静态常量池。
 * 可以将类的信息是对class文件内容的一个框架，里面具体的内容通过常量池来存储！
 *
 * refer:
 * https://blog.csdn.net/wangbiao007/article/details/78545189
 *
 * 1.静态常量池和动态常量池的关系以及区别?
 * 在编译成class文件时，class字节码文件中属于静态常量池，存储着基本数据类型和String常量值和 变量方法的符号引用
 * 在类加载之后，java虚拟机会将静态常量池里的内容转移到动态常量池里，在静态常量池的符号引用有一部分是会被转变为直接引用的。
 *
 * 2. String inter()方法的理解
 * https://www.cnblogs.com/Kidezyq/p/8040338.html
 *
 * 3.
 * https://blog.csdn.net/DevilDark/article/details/78238750
 * 堆内存的细分:
 * 新生代
 * 老年代
 *
 * 方法区里面的分类:
 * 永久代(常量池): 字符串常量池JDK1.6之前放在永久代，1.7之后移到了堆里，1.8之后移到了元空间
 * 元空间
 */
public class 方法区 {
}
