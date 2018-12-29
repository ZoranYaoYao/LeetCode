package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/onepixel/articles/7674659.html#undefined
 * https://baike.baidu.com/item/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F/7875498?fr=aladdin
 * https://blog.csdn.net/double_happiness/article/details/72452243
 * https://blog.csdn.net/u011948899/article/details/78027838
 *
 * 时间复杂度：O(d*2n) 代表数字的位数
 * 空间复杂度：O(n+k)
 *
 * eg
 * 第一次遍历： 能把1位数的位置确定下来
 * 第二次遍历： 能把2位数的位置确定下来
 * 第三次遍历： 能把3位数的位置确定下来
 */
public class S10基数排序 {

    public static void main(String[] args) {
        int[] nums = {32,12, 5, 9, 42, 15, 4, 6, 100};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void radixSort(int[] arr) {
        //1.寻找最大的数的位数
        int max = 0;
        for(int i=0; i<arr.length;i++) {
            max = Math.max(max, arr[i]);
        }
        int count = 0;
        while (max != 0) {
            count++;
            max = max / 10;
        }

        //2.遍历位数
        //Nice_core 数组的第一维表示可能的余数0-9
        int[][] temp = new int[10][arr.length];
        int[] order = new int[10]; //数组order[i]用来记录该位是i的数的个数
        int startCount = 1;
        int n = 1; //个位数开始
        while (startCount <= count) {
            //对位数进行分类收集到temp数组中
            for (int i=0; i<arr.length; i++) {
                int lsd = (arr[i] / n) % 10;
                temp[lsd][order[lsd]] = arr[i];
                order[lsd]++;
            }
            //对该次的数，进行填入到原始数组中
            int k=0;
            for(int i=0; i<10; i++) {
                for (int j=0; j<order[i]; j++) {
                    arr[k] = temp[i][j];
                    k++;
                }
                order[i] = 0; //重置该位个数
            }

            System.out.println("第" + startCount + "次, " + Arrays.toString(arr));
            //对下一位进行遍历
            n *= 10;
            startCount++;
        }
    }
}
