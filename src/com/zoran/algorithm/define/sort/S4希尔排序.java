package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://baike.baidu.com/item/Shell%E6%8E%92%E5%BA%8F/9796551
 * https://www.cnblogs.com/onepixel/articles/7674659.html#undefined
 * https://blog.csdn.net/huo065000/article/details/81172195
 *
 * 1. shell算法最初的间隔增量为 n/2，最后到1
 *
 * 2. 时间复杂度O（n（ldn）2）
 *    空间复杂度 O(1)
 *
 * 3. 间隔（gap）最终永远会变成1, 所以最后一次就变成了插入排序的算法！！
 */
public class S4希尔排序 {

    public static void main(String[] args) {
        int[] nums = {2,5,9,4,1,4,6,10};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void shellSort(int[] nums) {
        int gap = nums.length/2;
        while (gap > 0) {
            for (int i=gap; i<nums.length; i++) {
                int temp = nums[i];
                int j =i;
                //Core 内部插入排序，相对的最后位置开始插入
                while (j > gap-1 && temp < nums[j-gap]) {
                    nums[j] = nums[j-gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
            gap /= 2;
        }
    }

}
