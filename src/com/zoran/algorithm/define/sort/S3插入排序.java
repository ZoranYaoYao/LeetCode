package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://baike.baidu.com/item/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F/7214992?fr=aladdin
 */
public class S3插入排序 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 12, 11};
//        Zqs_insertSort(nums);
        insertSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 算法适用于少量数据的排序, 已经有相对顺序的数组
     */
    private static void Zqs_insertSort(int[] nums) {
        //从0开始，依次变成一个有序的数组
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    moveToBack(nums, j, i - 1);
                    nums[j] = temp;
                    System.out.println("i=" + i + ", j=" + j + ", nums = " + Arrays.toString(nums));
                    break;
                }
            }
        }
    }
    /**
     * @param nums  原始数组
     * @param start 开始往后移动一格的起始位置
     * @param end   移动一格的末尾位置
     */
    private static void moveToBack(int[] nums, int start, int end) {
        for (int i = end; i >= start; i--) {
            nums[i + 1] = nums[i];
        }
    }

    /**
     * 标准的插入排序 从小到大
     * refer : https://www.cnblogs.com/onepixel/articles/7674659.html#undefined
     *
     * 时间复杂度：O(n2)
     */
    private static int[] insertSort2(int[] arr) {
        //1.外层是待排序的游标
        //2. 每次插入都是从后往前插
        //冒泡排序的变种模式
        int len = arr.length;
        int preIndex, current;

        for (int i = 1; i < arr.length; i++) {
            preIndex = i-1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
        return arr;
    }


}
