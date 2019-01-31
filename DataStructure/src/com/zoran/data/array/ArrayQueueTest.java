package com.zoran.data.array;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayQueue �������
 *
 * ����com.sun.jmx.remote.internal
 *
 * �ײ�ʵ�֣�ѭ������
 * tailָ�� ָ����һ����ӵ�λ�ã���
 *
 * 1. ֻ���ֶ�����
 * 2. ��֧������ض�����Ԫ�أ�ֻ֧�ִӶ�β����
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        methodTest();
    }


    private static void methodTest() {
        /** ��*/
        ArrayQueue<Integer> queue = new ArrayQueue<>(16); //Core. ��ʼ�����붨�������
        queue.add(0);
//        queue.add(1,1); // ��֧�ָò���
        List<Integer> list = new ArrayList<>(); list.add(2); list.add(3);
        queue.addAll(list);
        System.out.println(queue);
//        queue.addAll(3, list); // ��֧�ָò���

        queue.resize(32); //Core. ֻ���ֶ�����

        /** ɾ*/
        ArrayQueue<Integer> queue2 = new ArrayQueue<>(16); //Core. ��ʼ�����붨�������
        queue2.add(0);queue2.add(1);queue2.add(2);
        queue2.remove(0); //Core. ֻ֧��ɾ�����е�ͷ��

        /** ��*/
        //�޴˹���

        /** ��*/
        ArrayQueue<Integer> queue3 = new ArrayQueue<>(16); //Core. ��ʼ�����붨�������
        queue3.add(0);queue3.add(1);queue3.add(2);
        queue3.get(0);queue3.get(1);queue3.get(2);

        /** ����*/
        ArrayQueue<Integer> queue4 = new ArrayQueue<>(16); //Core. ��ʼ�����붨�������
        queue4.add(0);queue4.add(1);queue4.add(2);
        for(int i=0; i<queue4.size(); i++) {
            System.out.println(queue.get(i));
        }

        /** ��������API*/
        ArrayQueue<Integer> queue5 = new ArrayQueue<>(16); //Core. ��ʼ�����붨�������
        queue5.add(0);queue5.add(1);queue5.add(2);
        queue5.clear();
        queue5.size();
        queue5.isEmpty();
        queue5.contains(2);

    }
}
