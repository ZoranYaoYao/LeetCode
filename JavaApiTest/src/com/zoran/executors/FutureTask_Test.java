package com.zoran.executors;

import java.util.concurrent.*;

/**
 * FutureTask
 *
 * �ײ�ԭ��
 * 1.FutureTask �̳�Runnable�ӿ�,��д��run()������ͨ��LockSupport���п���2���̵߳Ľ��ֵ״̬
 * http://www.cnblogs.com/avalon-merlin/p/9198444.html
 *
 * 2. execute() submit() ����
 *  execute() ִ��������Ҫ�з���ֵʱ��ʹ��execute()
 *  submite() ִ����Ҫ����ֵʱ��ͨ������Callable�ӿڣ�ʵ������ķ���ֵ����
 */
public class FutureTask_Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        excute();
        submit();


    }


    private static void excute() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //��ʽһ
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable ��ִ����");
            }
        };
        executor.execute(runnable);

        //��ʽ�� ִ��FutureTask����
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("��ǰ�߳�:" + Thread.currentThread() + ", �߳�����:" + Thread.currentThread().getName());
                return "ִ�гɹ���";
            }
        });
        executor.execute(futureTask);
        String res = futureTask.get();
        System.out.println(res);
        System.out.println("futureTaskִ�����֮�󣬲Ż�ִ�и÷���!");
    }

    private static void submit() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //��ʽһ�� ִ��Runnable, ����һ��nullֵ
        /**
         * ??Ϊʲôexecutor.submit(futureTask) ִ�г�������null����
         * ��ΪFutureTask����ΪRunnable�ӿڴ��ݸ�submit�ģ����ͨ����װRunnableAdapter���ڸ����call()��д�̶����ص���null����*/
//        FutureTask<String> futureTask = (FutureTask<String>) executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Runnable ��ִ����");
//            }
//        });
//        System.out.println(futureTask.get());

        //��ʽ����ִ��Runnable, ������������Ľ��ֵ��
//        FutureTask<String> futureTask = (FutureTask<String>) executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Runnable ��ִ����");
//            }
//        }, "���Ƿ��ؽ��");
//        System.out.println(futureTask.get());

        //��ʽ����ִ��Callable�ӿڣ�������call()�еķ���ֵ
        FutureTask<String> futureTask = (FutureTask<String>) executor.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.println("Runnable ��ִ����");
                return "���Ƿ��ؽ��";
            }
        });
        System.out.println(futureTask.get());
    }
}
