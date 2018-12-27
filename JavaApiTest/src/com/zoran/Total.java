package com.zoran;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Total {

    public static void main(String[] args) {
//        ExecutorService executors = Executors.newFixedThreadPool(3);
//        executors.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("aaa");
//            }
//        });


//        System.out.println(Integer.toBinaryString(-1));

        Single.print();
        System.out.println(Single.getInstance());
        System.out.println(Single.getInstance());
        System.out.println(Single.getInstance());

    }


}
