package com.zoran.leetcode.medium4;

import java.util.LinkedList;

/**
 * 132ģʽ
 * https://leetcode-cn.com/submissions/detail/10719142/
 *
 * [Solution]
 * https://blog.csdn.net/nunuwode/article/details/81990426
 *
 * 132ģʽ������������Ҿ����ܴ�ĵڶ���ֵ
 */
public class Test186 {
    /**
     * 80 / 95 ��ͨ����������
     * ����ʱ������
     */
//    public boolean find132pattern(int[] nums) {
//        //��ٷ�
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
     * 84 / 95 ��ͨ����������
     * ״̬������ʱ������
     * O(n2) Ҳ��ʱ
     */
    public boolean find132pattern(int[] nums) {
        //ÿ��λ����ջ�ף���ջ��¼3��ֵ�Ĺ�ϵ
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
     * ԭ��: �ҵ��ڶ����������ܴ����
     * vector<int> �൱�� int[]
     */
    public boolean find132pattern(int[] nums) {
        int second = Integer.MIN_VALUE; //Core ��¼132�У�2��ֵ
        LinkedList<Integer> stack = new LinkedList<>();
        int len = nums.length;
        //Nice_Core ����������ʼ�������ȼ�¼"2"��ֵ��"3"��ֵ��ջ
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





















