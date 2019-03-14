package com.zoran.multithread.wait;


/**
 * ����3��wait()���Զ�������
 * https://blog.csdn.net/nmyangym/article/details/7850882#commentsedit
 * �п��ܻᣬ��wait()�Ķ�����Threadʱ�����߳�����֮�󣬻��ͷ������Ӷ�wait()����notify()Ҳ���Ի���!!!!
 *
 * ��������� wait��Thread�Ļ������Thread�߳�ִ�����֮�󣬾ͻ��ƶ��ͷ�����Ȼ��ͻ�����wait()
 * ���飺
 * ��Ҫ��Thread�Ķ����� ����wait()
 */
public class ThreadA
{
	public static void main(String[] args)
	{
		ThreadB b = new ThreadB();
		Threadc c = new Threadc();
		c.setName("c�߳�");
		b.setName("b�߳�");
		c.start();
		System.out.println(Thread.currentThread().getName()+"is start....");

		/**
		 * mainis start....
		 * c�߳�is running..
		 * sum is362880
		 * waiting for b1 to complete....
		 * Completed.now back tomain
		 * b�߳�is running..
		 * total is45
		 *
		 * Ϊʲô�߳�c ִ����֮�� ���߳���wait()��ʱ��Ҳ�ܱ����ѣ�
		 */
		synchronized(c)
		{
			try
			{
				System.out.println("�߳�c��״̬��:"+c.isAlive()); //Nice_Core c.isAlive()=true
				System.out.println("waiting for b1 to complete....");
				/**
				 * ?
				 * 1.�߳�C run()֮����synchrzed(c), ��ǰ�߳���true
				 * 2. c.wait()�ȴ�
				 * 3. �߳�c ִ�����֮�����٣��ͷŶ�����
				 * 4. wait()�����Ѽ���ִ�к�����������
				 */
				c.wait();
				System.out.println("Completed.now back to"+
						Thread.currentThread().getName());
				b.start();
			}
			catch(InterruptedException e)
			{
			}
	}
}
}
class ThreadB extends Thread
{
	int total;
	public void run()
	{
		synchronized(this)
		{
			System.out.println(Thread.currentThread().getName()+"is running..");
			for(int i=0;i<10;i++)
			{
				total +=i;
			}
			System.out.println("total is"+total);
		}
	}
}
class Threadc extends Thread
{
	int sum=1;
	public void run()
	{
		synchronized(this)
		{
			System.out.println(Thread.currentThread().getName()+"is running..");
			for(int i=1;i<10;i++)
			{
				sum *=i;
			}
			System.out.println("sum is"+sum);
			notify();
		}
	}
}