package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * refer : https://www.cnblogs.com/chengxiao/p/6194356.html
 * <p>
 * ʱ�临�Ӷ�: O(nlogn)
 * �ռ临�Ӷ�: O(n)
 * <p>
 * ���㷨�ǲ��÷��η���Divide and Conquer����һ���ǳ����͵�Ӧ��
 * ��Ϊʼ�ն���O(nlogn����ʱ�临�Ӷȡ���������Ҫ������ڴ�ռ�
 */
public class S5�鲢���� {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 10};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
    }

    /**
     * @param arr   ԭ����
     * @param left  ���������ʼλ��
     * @param right �ұ�������ʼλ��
     * @param temp  ��ʱ����
     */
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //Nice_Core �������һ�������еݹ�ֿ���Ȼ���ڽ��в��ϲ�
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) { //Core. �����ʣ��Ԫ������temp��
            temp[t++] = arr[i++];
        }
        while (j <= right) { //Core. ��������ʣ��Ԫ������temp��
            temp[t++] = arr[j++];
        }
        t = 0;
        //��temp�е�Ԫ��ȫ��������ԭ������
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
