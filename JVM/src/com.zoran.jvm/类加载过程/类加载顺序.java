package com.zoran.jvm.类加载过程;

/**
 * refer:
 * https://blog.csdn.net/ln152315/article/details/79223441
 *
 * 1.加载: JVM加载class文件
 * 2.链接:
 *  验证: 验证阶段主要包括四个检验过程：文件格式验证、元数据验证、字节码验证和符号引用验证;
 *  准备: 为类中的所有静态变量分配内存空间，并为其设置一个初始值（由于还没有产生对象，实例变量将不再此操作范围内）；
 *  解析: 将常量池中所有的符号引用转为直接引用（得到类或者字段、方法在内存中的指针或者偏移量，以便直接调用该方法）。这个阶段可以在初始化之后再执行。
 * 3.初始化: 对类变量，代码块，构造函数进行赋值！
 */
public class 类加载顺序 {

    static {
        System.out.println("静态代码块");
    }


    public 类加载顺序(){
        System.out.println("类加载顺序" + i);
        i = 5;
        System.out.println("类加载顺序" + i);
    }

    int i =1;
    {
        System.out.println("代码块" + i);
        i = 3;
        System.out.println("代码块" + i);
    }

    public static void main(String[] args) {
        类加载顺序 test = new 类加载顺序();
        类加载顺序 test2 = new 类加载顺序();

    }

}
