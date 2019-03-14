package com.zoran.multithread.wait;

/**
 * ����2��
 * wait() wait��synchronize�ؼ�����,��ν����ͷ��Լ����������أ�
 * https://blog.csdn.net/lengxiao1993/article/details/52296220
 * ��Ϊû�ж��������ƵĻ����ڴ�����κεط����п��ܱ��������ڱ�����֮�󣬾ͻᵼ��wait() notify()2���������߼����ң�
 * �п�����wait()֮ǰ,�͵�����notify()�������¡�֮���л��̹߳���֮�󣬷����̹߳���״̬����
 *
 * �������ӽ��Ĳ������û�������ƵĻ������ܻ����notify()���� ��wait()����֮ǰ���ã���
 *

 */
public class WaitNotifyNotifyall���� {

    public static void main(String[] args) {
        A a = new A();
        a.method();
    }

    static class A {

        String obj = "";

        /**
         * case 1: ����aʵ�������method()ͬ�������������synchronized (obj) {}
         * <p>
         * ��IllegalMonitorStateException
         * ����wait() , notify(), notifyAll() 3�������ĵ��ã������Ȼ�ȡ������wait������notify(),notifyall()�����������
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
