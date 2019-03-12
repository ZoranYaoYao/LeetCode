package com.zoran.jvm.类加载过程;

/**
 * refer:
 * https://www.cnblogs.com/aspirant/p/7200523.html
 *
 * 1.
 * 类加载器种类
 * 启动类加载器，Bootstrap ClassLoader，加载JACA_HOME\lib，或者被-Xbootclasspath参数限定的类
 * 扩展类加载器，Extension ClassLoader，加载\lib\ext，或者被java.ext.dirs系统变量指定的类
 * 应用程序类加载器，Application ClassLoader，加载ClassPath中的类库
 * 自定义类加载器，通过继承ClassLoader实现，一般是加载我们的自定义类
 *
 * 2.
 * 何时触发初始化
 * 为一个类型创建一个新的对象实例时（比如new、反射、序列化）
 * 调用一个类型的静态方法时（即在字节码中执行invokestatic指令）
 * 调用一个类型或接口的静态字段，或者对这些静态字段执行赋值操作时（即在字节码中，执行getstatic或者putstatic指令），不过用final修饰的静态字段除外，它被初始化为一个编译时常量表达式
 * 调用JavaAPI中的反射方法时（比如调用java.lang.Class中的方法，或者java.lang.reflect包中其他类的方法）
 * 初始化一个类的派生类时（Java虚拟机规范明确要求初始化一个类时，它的超类必须提前完成初始化操作，接口例外）
 * JVM启动包含main方法的启动类时。
 */
public class 类加载器 {
}
