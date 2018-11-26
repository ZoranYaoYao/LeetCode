package com.zoran.leetcode.medium4;

import java.util.Arrays;
import java.util.Random;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/9763733/
 *
 * [Solution]
 * https://blog.csdn.net/qq_33256688/article/details/80304048
 */
public class Test152 {

    class Solution {
        //�����㷨���Ӻ���ǰ���� �����λ�ý��н���

        int[] origin;
        int[] noSort;
        public Solution(int[] nums) {
            origin = nums;
            noSort = Arrays.copyOf(nums, nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            Random random = new Random();
            for (int i=noSort.length; i>0; i--) {
                int loc = random.nextInt(i);
                int temp = noSort[loc];
                noSort[loc] = noSort[i-1];
                noSort[i-1] = temp;
            }

            return noSort;
        }
    }
}
