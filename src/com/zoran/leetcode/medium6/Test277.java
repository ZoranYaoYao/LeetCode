package com.zoran.leetcode.medium6;

import java.util.Stack;

/**
 * ÿ���¶�
 * https://leetcode-cn.com/submissions/detail/15094340/
 *
 * ջʽ���� �ݼ�ջ
 */
public class Test277 {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        //�����ⷨ
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
            //Nice_Core ��ǰ����������������ջ���鿴�����Ƿ�������
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int temp = stack.pop();
                incre[temp] = i-temp;
            }

            if (stack.isEmpty() || T[stack.peek()] >= T[i]) {
                stack.push(i); //����λ�ý�����ջ
            }
        }

        return incre;
    }
}
