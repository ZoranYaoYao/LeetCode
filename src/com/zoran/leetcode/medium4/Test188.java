package com.zoran.leetcode.medium4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最少移动次数使数组元素相等 II
 * https://leetcode-cn.com/submissions/detail/10802043/
 */
public class Test188 {

    public static void main(String[] args) {
        Test188 test188 = new Test188();
        int[] nums = {203125577,-349566234,230332704,48321315,66379082
                ,386516853,50986744,-250908656,-425653504,-212123143};
        int res = test188.minMoves2(nums);
        System.out.println(res);
    }

    public int minMoves2(int[] nums) {
        //那个元素多，就往哪边靠
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i =0; i<nums.length; i++) {
            int temp = 0;
            if (set.contains(i)) continue;

            for(int j=0;j<nums.length; j++) {
                if(i == j) continue;
                //int 相加溢出
                temp += Math.abs(nums[j] - nums[i]);
                if (temp < 0) {
                    temp = Integer.MAX_VALUE;
                    break;
                }
            }
            set.add(i);
            res = Math.min(res, temp);
        }

        return res;
    }
}

class LeetCode_Test188 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        //Core 偶数情况时， 已中间2个数的平均数为基准
        int mid = (len%2 == 1) ? nums[len/2] : (nums[len/2] + nums[len/2-1])/2;
        int count = 0;
        for (int i=0; i<len; i++) {
            count += Math.abs(nums[i] - mid); //Core 已中间位置的那个值基准
        }
    }
}
