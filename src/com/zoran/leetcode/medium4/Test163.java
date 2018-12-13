package com.zoran.leetcode.medium4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Ëæ»úÊýË÷Òý
 * https://leetcode-cn.com/submissions/detail/10413636/
 */
public class Test163 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3};
        Solution solution = new Solution(nums);
        int res = solution.pick(3);
        System.out.println(res);
    }

    static class Solution {

        int[] nums;
        List<Integer> list;
        public Solution(int[] nums) {
            this.nums = nums;
            list = new ArrayList<>();
        }

        public int pick(int target) {
            list.clear();
            int length = nums.length;
            for(int i=0; i<length; i++) {
                if(nums[i] == target) list.add(i);
            }

            int random = new Random().nextInt(list.size());
            System.out.println(random);
            return list.get(random);
        }
    }
}
