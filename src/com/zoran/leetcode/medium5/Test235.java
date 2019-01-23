package com.zoran.leetcode.medium5;

import java.util.Arrays;

/**
 * 有效三角形的个数
 * https://leetcode-cn.com/submissions/detail/11981799/
 *
 * [Solution]
 * https://blog.csdn.net/u014339020/article/details/79979054
 *
 * 排序，固定1条边，并对另外2条边进行缩放
 */
public class Test235 {

    public int triangleNumber(int[] nums) {
        //数学 2边之和大于第3边，2边之差小于第3边
        // Arrays.sort(nums);
        int res = 0;
        for (int i=0; i<nums.length-2; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                for (int z=j+1;z<nums.length; z++) {
                    if (nums[i] + nums[j] > nums[z] &&
                            Math.abs(nums[i] - nums[j]) < nums[z]) res++;
                }
            }
        }
        return res;
    }

}

class Nice_Test235 {
    public int triangleNumber(int[] nums) {
        int count =0;
        int len = nums.length;

        Arrays.sort(nums);
        for (int i=len-1; i>=2; i--) { //Core. 固定第3条边，并从后面进行查找
            int left = 0;
            int right = i-1; //Core 第三条边的右边界
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left); //Nice_core 固定右边界，左边界+1都能满足
                    right--;
                } else {
                    left++;
                }
            }

        }
        return count;
    }
}