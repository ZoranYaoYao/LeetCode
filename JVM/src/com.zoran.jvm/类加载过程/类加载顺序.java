package com.zoran.jvm.类加载过程;

/**
 * refer:
 * https://blog.csdn.net/ln152315/article/details/79223441
 *
 * 1.加载: JVM加载class文件
 * 2.链接:
 *  验证: 验证class文件格式
 *  分析: 将方法里面的符号引用替换成内存地址，
 *  准备: 给变量赋值默认值
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
