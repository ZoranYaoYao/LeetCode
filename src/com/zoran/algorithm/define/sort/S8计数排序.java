package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://baike.baidu.com/item/%E8%AE%A1%E6%95%B0%E6%8E%92%E5%BA%8F/8518144?fr=aladdin
 * https://www.cnblogs.com/onepixel/articles/7674659.html#undefined
 *
 * ʱ�临�Ӷȣ�O(n+k)
 * �ռ临�Ӷȣ�O(n+k)
 *
 * <p>
 * �ŵ㣺���ĸ��Ӷ�Ϊ��(n+k)������k�������ķ�Χ���������καȽ������㷨
 * ȱ�㣺ֻ�������ܼ����Ķ���byte,int,long,char��
 *      ��Ȼ����һ�������ռ任ȡʱ������������ҵ�O(k)>O(n*log(n))��ʱ����Ч�ʷ���������ڱȽϵ�����
 */
public class S8�������� {

    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 10};
        int max = Integer.MIN_VALUE;
        for (int item : nums){
            max = Math.max(max, item);
        }
        countingSort(nums, max);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * ͨ������������ֵ�� ��ַ������ķ�ʽ���б�������
     * @param arr ԭʼ����
     * @param maxValue ������������Ԫ��
     */
    private static void countingSort(int[] arr,int  maxValue) {
        int[] bucket = new int[maxValue+1]; //Core �������������������ֵ��ֵ�����

        for (int i=0; i<arr.length; i++) {
            bucket[arr[i]]++;
        }

        int sortedIndex = 0;
        for (int j=0; j<bucket.length; j++) {
            while (bucket[j]>0){
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
    }
}
