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
         * ��ȡ�̶��̸߳������̳߳�
         */
        ExecutorService executors = Executors.newFixedThreadPool(16);
    }

}
