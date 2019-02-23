package com.zoran.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors
 *
 */
public class ExecutorsTest {

    public static void main(String[] args) {

        /**
         * 获取固定线程个数的线程池
         */
        ExecutorService executors = Executors.newFixedThreadPool(16);
    }

}
