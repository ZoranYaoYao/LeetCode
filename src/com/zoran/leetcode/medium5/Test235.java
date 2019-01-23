package com.zoran.leetcode.medium5;

import java.util.Arrays;

/**
 * ��Ч�����εĸ���
 * https://leetcode-cn.com/submissions/detail/11981799/
 *
 * [Solution]
 * https://blog.csdn.net/u014339020/article/details/79979054
 *
 * ���򣬹̶�1���ߣ���������2���߽�������
 */
public class Test235 {

    public int triangleNumber(int[] nums) {
        //��ѧ 2��֮�ʹ��ڵ�3�ߣ�2��֮��С�ڵ�3��
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
        for (int i=len-1; i>=2; i--) { //Core. �̶���3���ߣ����Ӻ�����в���
            int left = 0;
            int right = i-1; //Core �������ߵ��ұ߽�
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left); //Nice_core �̶��ұ߽磬��߽�+1��������
                    right--;
                } else {
                    left++;
                }
            }

        }
        return count;
    }
}