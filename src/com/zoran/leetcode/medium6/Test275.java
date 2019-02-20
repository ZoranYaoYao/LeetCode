package com.zoran.leetcode.medium6;

import java.util.ArrayDeque;

/**
 * ������ײ
 * https://leetcode-cn.com/submissions/detail/13010095/
 *
 * ArrayDeque ջ�ṹ
 */
public class Test275 {

    public static void main(String[] args) {

        Test275 test275 = new Test275();
        int[] nums = {1,-2,-2,-2};
        int[] res = test275.asteroidCollision(nums);
        System.out.println(res);
    }

    public int[] asteroidCollision(int[] asteroids) {
        //��ջ�ṹ���оͽ����� ArrayDeque
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int item : asteroids) {
            Integer top = stack.peek();
            if (top == null) {
                stack.push(item);
            } else if (top*item>0 || (top <0 && item>0)) {
                stack.push(item);
            } else {
                boolean flag = false;
                while (top>0 && item <0 && top<=Math.abs(item)) {
                    stack.pop();
                    if (top == Math.abs(item)) {
                        flag = true;
                        break;
                    }
                    top = stack.peek();
                    if (top == null) break;
                }

                //�Ƚ����֮��ջ�ڷ��Ż������Եġ�
                if(top != null && top>0 && item <0) {
                    continue;
                } else if (!flag) { //�Ա���֮��ֻҪ�����������ֵ������ӣ���
                    stack.push(item);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i=res.length-1; i>=0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
