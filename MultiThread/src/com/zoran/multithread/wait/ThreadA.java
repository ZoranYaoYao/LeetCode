package com.zoran.multithread.wait;


/**
 * 问题3：wait()会自动唤醒吗？
 * https://blog.csdn.net/nmyangym/article/details/7850882#commentsedit
 * 有可能会，当wait()的对象是Thread时，当线程销毁之后，会释放锁，从而wait()不用notify()也可以唤醒!!!!
 *
 * 如果对象锁 wait是Thread的话，如果Thread线程执行完成之后，就会制动释放锁，然后就唤醒了wait()
 * 建议：
 * 不要用Thread的对象锁 进行wait()
 */
public class ThreadA
{
	public static void main(String[] args)
	{
		ThreadB b = new ThreadB();
		Threadc c = new Threadc();
		c.setName("c线程");
		b.setName("b线程");
		c.start();
		System.out.println(Thread.currentThread().getName()+"is start....");

		/**
		 * mainis start....
		 * c线程is running..
		 * sum is362880
		 * waiting for b1 to complete....
		 * Completed.now back tomain
		 * b线程is running..
		 * total is45
		 *
		 * 为什么线程c 执行完之后， 主线程在wait()的时候也能被唤醒？
		 */
		synchronized(c)
		{
			try
			{
				System.out.println("线程c的状态是:"+c.isAlive()); //Nice_Core c.isAlive()=true
				System.out.println("waiting for b1 to complete....");
				/**
				 * ?
				 * 1.线程C run()之后，走synchrzed(c), 当前线程是true
				 * 2. c.wait()等待
				 * 3. 线程c 执行完成之后，销毁，释放对象锁
				 * 4. wait()处唤醒继续执行后续操作！！
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