package com.zoran.leetcode.medium4;

import java.util.LinkedList;

/**
 * 132模式
 * https://leetcode-cn.com/submissions/detail/10719142/
 *
 * [Solution]
 * https://blog.csdn.net/nunuwode/article/details/81990426
 *
 * 132模式，倒序遍历，找尽可能大的第二个值
 */
public class Test186 {
    /**
     * 80 / 95 个通过测试用例
     * 超出时间限制
     */
//    public boolean find132pattern(int[] nums) {
//        //穷举法
//        if (nums == null || nums.length < 3) return false;
//
//        for(int i=0 ; i<nums.length; i++) {
//            for (int j=i+1; j<nums.length; j++) {
//                for (int k=j+1; k<nums.length; k++) {
//                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
//                }
//            }
//        }
//
//        return false;
//    }
    public static void main(String[] args) {
        int[] nums = {-2,1,2,-2,1,2};
        Test186 test186 = new Test186();
        boolean res = test186.find132pattern(nums);
        System.out.println(res);
    }

    /**
     * 84 / 95 个通过测试用例
     * 状态：超出时间限制
     * O(n2) 也超时
     */
    public boolean find132pattern(int[] nums) {
        //每个位置做栈底，用栈记录3个值的关系
        if (nums == null || nums.length < 3) return false;

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i=0 ; i<nums.length; i++) {
            stack.push(nums[i]);
            for(int j=i; j<nums.length; j++) {
                if (stack.size() == 1 && nums[j]>stack.peek()) {
                    stack.push(nums[j]);
                } else if (stack.size() == 2) {
                    if (stack.getLast() >= nums[j]) continue;

                    if (stack.peek() > nums[j]) {
                        return true;
                    } else {
                        stack.pop();
                        stack.push(nums[j]);
                    }
                }
            }
            stack.clear();
        }

        return false;
    }
}

class Nice_Test186 {
    /**
     * 原理: 找到第二个数尽可能大的数
     * vector<int> 相当于 int[]
     */
    public boolean find132pattern(int[] nums) {
        int second = Integer.MIN_VALUE; //Core 记录132中，2的值
        LinkedList<Integer> stack = new LinkedList<>();
        int len = nums.length;
        //Nice_Core 从数组的最后开始遍历，先记录"2"的值，"3"的值入栈
        for (int i=len-1; i>=0; i--) {
            if (nums[i] < second) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }
}





















