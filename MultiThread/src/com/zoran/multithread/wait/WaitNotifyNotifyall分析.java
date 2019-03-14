package com.zoran.multithread.wait;

/**
 * 问题2：
 * wait() wait在synchronize关键字里,如何进行释放自己对象锁的呢？
 * https://blog.csdn.net/lengxiao1993/article/details/52296220
 * 因为没有对象锁机制的话，在代码的任何地方都有可能被挂起，由于被挂起之后，就会导致wait() notify()2个方法的逻辑混乱，
 * 有可能在wait()之前,就调用了notify()方法导致。之后切换线程过来之后，发生线程挂起状态！！
 *
 * 链接例子讲的不错，如果没有锁机制的话，可能会出现notify()方法 在wait()方法之前调用！！
 *

 */
public class WaitNotifyNotifyall分析 {

    public static void main(String[] args) {
        A a = new A();
        a.method();
    }

    static class A {

        String obj = "";

        /**
         * case 1: 访问a实例对象的method()同步方法，不添加synchronized (obj) {}
         * <p>
         * 报IllegalMonitorStateException
         * 所以wait() , notify(), notifyAll() 3个方法的调用，必须先获取到调用wait（），notify(),notifyall()对象的锁！！
         */
        public void method() {

            synchronized (obj) {
                System.out.println("bb");
//                    obj.wait();
                    obj.notify();
//                obj.notifyAll();
                System.out.println("aa");
            }

        }
    }
}
