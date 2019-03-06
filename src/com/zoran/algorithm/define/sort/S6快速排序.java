package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * refer: https://blog.csdn.net/sinat_20177327/article/details/76560079
 * <p>
 * 时间复杂度: O(nlogn)
 * 空间复杂度: O(n)
 * <p>
 * 快速排序利用分治思想，将待排序数组分成左右两个部分，然后对其分别递归调用快速排序算法。
 *
 * 跟归并排序思想相同，不过快速排序每次定位的是中间的base位置！！
 */
public class S6快速排序 {
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

        //将基准temp放于自己的位置，（第i个位置）
        int temp = arr[low];
        arr[low] = arr[i];
        arr[i] = temp;

        //Nice_Core 对左边的数组进行递归执行
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

}
