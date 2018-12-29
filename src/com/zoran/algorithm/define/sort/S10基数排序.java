package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/onepixel/articles/7674659.html#undefined
 * https://baike.baidu.com/item/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F/7875498?fr=aladdin
 * https://blog.csdn.net/double_happiness/article/details/72452243
 * https://blog.csdn.net/u011948899/article/details/78027838
 *
 * ʱ�临�Ӷȣ�O(d*2n) �������ֵ�λ��
 * �ռ临�Ӷȣ�O(n+k)
 *
 * eg
 * ��һ�α����� �ܰ�1λ����λ��ȷ������
 * �ڶ��α����� �ܰ�2λ����λ��ȷ������
 * �����α����� �ܰ�3λ����λ��ȷ������
 */
public class S10�������� {

    public static void main(String[] args) {
        int[] nums = {32,12, 5, 9, 42, 15, 4, 6, 100};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void radixSort(int[] arr) {
        //1.Ѱ����������λ��
        int max = 0;
        for(int i=0; i<arr.length;i++) {
            max = Math.max(max, arr[i]);
        }
        int count = 0;
        while (max != 0) {
            count++;
            max = max / 10;
        }

        //2.����λ��
        //Nice_core ����ĵ�һά��ʾ���ܵ�����0-9
        int[][] temp = new int[10][arr.length];
        int[] order = new int[10]; //����order[i]������¼��λ��i�����ĸ���
        int startCount = 1;
        int n = 1; //��λ����ʼ
        while (startCount <= count) {
            //��λ�����з����ռ���temp������
            for (int i=0; i<arr.length; i++) {
                int lsd = (arr[i] / n) % 10;
                temp[lsd][order[lsd]] = arr[i];
                order[lsd]++;
            }
            //�Ըôε������������뵽ԭʼ������
            int k=0;
            for(int i=0; i<10; i++) {
                for (int j=0; j<order[i]; j++) {
                    arr[k] = temp[i][j];
                    k++;
                }
                order[i] = 0; //���ø�λ����
            }

            System.out.println("��" + startCount + "��, " + Arrays.toString(arr));
            //����һλ���б���
            n *= 10;
            startCount++;
        }
    }
}
