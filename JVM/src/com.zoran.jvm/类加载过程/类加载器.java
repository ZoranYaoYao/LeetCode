package com.zoran.jvm.����ع���;

/**
 * refer:
 * https://www.cnblogs.com/aspirant/p/7200523.html
 *
 * 1.
 * �����������
 * �������������Bootstrap ClassLoader������JACA_HOME\lib�����߱�-Xbootclasspath�����޶�����
 * ��չ���������Extension ClassLoader������\lib\ext�����߱�java.ext.dirsϵͳ����ָ������
 * Ӧ�ó������������Application ClassLoader������ClassPath�е����
 * �Զ������������ͨ���̳�ClassLoaderʵ�֣�һ���Ǽ������ǵ��Զ�����
 *
 * 2.
 * ��ʱ������ʼ��
 * Ϊһ�����ʹ���һ���µĶ���ʵ��ʱ������new�����䡢���л���
 * ����һ�����͵ľ�̬����ʱ�������ֽ�����ִ��invokestaticָ�
 * ����һ�����ͻ�ӿڵľ�̬�ֶΣ����߶���Щ��̬�ֶ�ִ�и�ֵ����ʱ�������ֽ����У�ִ��getstatic����putstaticָ���������final���εľ�̬�ֶγ��⣬������ʼ��Ϊһ������ʱ�������ʽ
 * ����JavaAPI�еķ��䷽��ʱ���������java.lang.Class�еķ���������java.lang.reflect����������ķ�����
 * ��ʼ��һ�����������ʱ��Java������淶��ȷҪ���ʼ��һ����ʱ�����ĳ��������ǰ��ɳ�ʼ���������ӿ����⣩
 * JVM��������main������������ʱ��
 */
public class ������� {
}
