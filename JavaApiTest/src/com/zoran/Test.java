package com.zoran;

import java.util.ArrayList;
import java.util.List;

public class Test {


    private static int _10MB = 1 * 1024 * 1024;
    private final Test2 t = new Test2();
    //       private static final Test t;
    private byte[] memory;

    public Test(int size) {
        memory = new byte[size];
//            t = new Test(size);
    }

    public static void main(String[] args) {
        System.out.println("aa");
        Test t3 = new Test(1 * _10MB);
        t3 = null;
//        Test t4 = new Test(1 * _10MB);
//        t4 = null;
//        Test t5 = new Test(1 * _10MB);
//        t5 = null;
//        Test t6 = new Test(1 * _10MB);
//        t6 = null;

        System.gc();
    }

    class Test2 {
        private int _10MB = 1 * 1024 * 1024;
        private byte[] memory = new byte[_10MB];
    }

}


