package com.zoran;

public class Single {

    private static int a = 10;
    private  int b = 10;

    private Single() {
    }



    public static Single getInstance() {
        Single single =  Inner.single;
        return single;
    }


    public static class Inner{
        static Single single = new Single();


        static {
            System.out.println("inner");
            System.out.println(a);
        }
    }

    public static void print() {
        System.out.println("aaa");
    }
}
