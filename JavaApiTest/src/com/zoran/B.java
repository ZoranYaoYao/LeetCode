package com.zoran;



public class B extends A {

    static {
        System.out.println("B static");
        }
    static int a = 0;
    String b = "ss";

    B() {
        super(1);
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

//    A() {
//        System.out.println("A()");
//    }

    A(int i) {

    }
}
