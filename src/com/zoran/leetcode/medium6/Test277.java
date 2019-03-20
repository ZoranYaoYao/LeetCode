package com.zoran.leetcode.medium6;

import java.util.Stack;

/**
 * 每日温度
 * https://leetcode-cn.com/submissions/detail/15094340/
 *
 * 栈式管理： 递减栈
 */
public class Test277 {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        //暴力解法
        for (int i=0; i<T.length; i++) {
            int diff = 0;
            for (int j=i+1; j<T.length; j++) {
                diff++;
                if (T[j] > T[i]) {
                    res[i] = diff;
                    break;
                }
            }
        }

        return res;
    }
}

class LeetCode_Test277 {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] incre = new int[T.length];
        for (int i=0; i<T.length; i++) {
            //Nice_Core 以前不满足条件的先入栈，查看后面是否有满足
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int temp = stack.pop();
                incre[temp] = i-temp;
            }

            if (stack.isEmpty() || T[stack.peek()] >= T[i]) {
                stack.push(i); //将该位置进行入栈
            }
        }

        return incre;
    }
}
