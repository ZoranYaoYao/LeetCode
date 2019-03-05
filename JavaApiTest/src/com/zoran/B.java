package com.zoran;



public class B extends A {

    static {
        System.out.println("B static");
        }
    static int a = 0;
    String b = "ss";

    {
        System.out.println("模拟变量加载B");
    }
    B() {
        super();
        System.out.println("B()");
    }

    public static void main(String[] args) {
        new B();
    }
}



class A {

    static {
        System.out.println("A static");
        }

    static int a = 0;
    String b = "ss";
    {
        b = "-1";
        System.out.println("模拟变量加载A" + b);
    }


    A() {
        System.out.println("A()");
    }

}
