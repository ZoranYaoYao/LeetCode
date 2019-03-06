package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * refer: https://blog.csdn.net/sinat_20177327/article/details/76560079
 * <p>
 * ʱ�临�Ӷ�: O(nlogn)
 * �ռ临�Ӷ�: O(n)
 * <p>
 * �����������÷���˼�룬������������ֳ������������֣�Ȼ�����ֱ�ݹ���ÿ��������㷨��
 *
 * ���鲢����˼����ͬ��������������ÿ�ζ�λ�����м��baseλ�ã���
 */
public class S6�������� {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 10};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        if (i > j) return;
        int base = arr[low];
        while (i != j) {
            while (arr[j] >= base && i < j)
                j--;
            while (arr[i] <= base && i < j)
                i++;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //����׼temp�����Լ���λ�ã�����i��λ�ã�
        int temp = arr[low];
        arr[low] = arr[i];
        arr[i] = temp;

        //Nice_Core ����ߵ�������еݹ�ִ��
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

}
