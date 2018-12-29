package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://baike.baidu.com/item/Shell%E6%8E%92%E5%BA%8F/9796551
 * https://www.cnblogs.com/onepixel/articles/7674659.html#undefined
 * https://blog.csdn.net/huo065000/article/details/81172195
 *
 * 1. shell�㷨����ļ������Ϊ n/2�����1
 *
 * 2. ʱ�临�Ӷ�O��n��ldn��2��
 *    �ռ临�Ӷ� O(1)
 *
 * 3. �����gap��������Զ����1, �������һ�ξͱ���˲���������㷨����
 */
public class S4ϣ������ {

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
                //Core �ڲ�����������Ե����λ�ÿ�ʼ����
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
