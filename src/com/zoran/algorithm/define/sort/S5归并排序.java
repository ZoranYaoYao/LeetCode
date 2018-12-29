package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * refer : https://www.cnblogs.com/chengxiao/p/6194356.html
 * <p>
 * 时间复杂度: O(nlogn)
 * 空间复杂度: O(n)
 * <p>
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用
 * 因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间
 */
public class S5归并排序 {
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
     * @param arr   原数组
     * @param left  左边索引起始位置
     * @param right 右边索引起始位置
     * @param temp  临时数组
     */
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //Nice_Core 像二叉树一样，进行递归分开，然后在进行层层合并
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
        while (i <= mid) { //Core. 将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) { //Core. 将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
