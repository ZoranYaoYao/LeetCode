package com.zoran.threadlocal;

/**
 * ThreadLocal
 *
 * refer��
 * https://www.cnblogs.com/dolphin0520/p/3920407.html
 * https://www.jianshu.com/p/c2a482b48d17 rebase!
 *
 * ԭ��
 * ��ͨ��ThreadLocal��������get()��������set()�������ͻ��Thread���е�threadLocals���г�ʼ����
 * �����Ե�ǰThreadLocal����Ϊ��ֵ����ThreadLocalҪ����ĸ�������Ϊvalue���浽threadLocals��
 *
 * ������
 * ThreadLocal��ָ�̱߳��ر����������ڸ����̶߳�����һ�������߳��Լ��ı���
 * ThreadLocal�ڲ�ʵ������Thread������һ��ThreadLocalMap�ı����� ThreadLocalMap��������һ��Entry��������
 * Entry����һ���̳�weakReference��Threadlocal���������������Value�ֶΡ�
 * ���ͨ����ThreadLocal���������set()��get()�������Ȼ�ȡ��ǰ�̣߳�Ȼ��ͨ����ǰ�߳�ȥ�ҵ��̵߳ı��ر���ThreadLocalMap����
 * ���ͨ�����mapȥ����keyΪ��ǰ���ThreadLocal����Ӧ��valueֵ��
 */
public class ThreadLocalTest {



}
