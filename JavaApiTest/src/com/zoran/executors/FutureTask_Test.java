package com.zoran.executors;

import java.util.concurrent.*;

/**
 * FutureTask
 *
 * 底层原理
 * 1.FutureTask 继承Runnable接口,重写了run()方法，通过LockSupport进行控制2个线程的结果值状态
 * http://www.cnblogs.com/avalon-merlin/p/9198444.html
 *
 * 2. execute() submit() 区别？
 *  execute() 执行任务不需要有返回值时。使用execute()
 *  submite() 执行需要返回值时，通过传递Callable接口，实现任务的返回值！！
 */
public class FutureTask_Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        excute();
        submit();


    }


    private static void excute() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //方式一
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable 被执行了");
            }
        };
        executor.execute(runnable);

        //方式二 执行FutureTask任务
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("当前线程:" + Thread.currentThread() + ", 线程名字:" + Thread.currentThread().getName());
                return "执行成功！";
            }
        });
        executor.execute(futureTask);
        String res = futureTask.get();
        System.out.println(res);
        System.out.println("futureTask执行完成之后，才会执行该方法!");
    }

    private static void submit() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //方式一， 执行Runnable, 返回一个null值
        /**
         * ??为什么executor.submit(futureTask) 执行出来的是null对象？
         * 因为FutureTask是作为Runnable接口传递给submit的，最后通过封装RunnableAdapter，在该类的call()重写固定返回的是null！！*/
//        FutureTask<String> futureTask = (FutureTask<String>) executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Runnable 被执行了");
//            }
//        });
//        System.out.println(futureTask.get());

        //方式二，执行Runnable, 并返回你给定的结果值！
//        FutureTask<String> futureTask = (FutureTask<String>) executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Runnable 被执行了");
//            }
//        }, "我是返回结果");
//        System.out.println(futureTask.get());

        //方式三，执行Callable接口，并返回call()中的返回值
        FutureTask<String> futureTask = (FutureTask<String>) executor.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.println("Runnable 被执行了");
                return "我是返回结果";
            }
        });
        System.out.println(futureTask.get());
    }
}
