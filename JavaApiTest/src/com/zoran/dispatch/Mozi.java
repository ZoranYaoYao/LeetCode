package com.zoran.dispatch;

/**
 * refer��
 * http://www.cnblogs.com/java-my-life/archive/2012/06/14/2545381.html
 *
 * 1. ��̬���ɣ���̬����
 *   ��̬���ɣ���̬���ͣ���������ط�������̬����
 *   ��̬���ɣ���ʵ���ͣ�����д֧�ֶ�̬����
 *
 * 2.һ�����������Ķ�����������Ľ����ߣ������Ľ������뷽���Ĳ���ͳ��������������
 *
 * 3.Java���Ƕ�̬�ĵ��������ԣ�ͬʱ���Ǿ�̬�Ķ��������
 *
 * 4.������ģʽ��һ�ֽ����ݲ��������ݽṹ��������ģʽ
 */
public class Mozi {

    public void ride(Horse h){
        System.out.println("����");
    }

    public void ride(WhiteHorse wh){
        System.out.println("�����");
    }

    public void ride(BlackHorse bh){
        System.out.println("�����");
    }

    public static void main(String[] args) {
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        Mozi mozi = new Mozi();
        mozi.ride(wh);
        mozi.ride(bh);
    }
}
