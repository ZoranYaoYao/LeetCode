package com.zoran.leetcode.medium6;

import java.util.ArrayDeque;

/**
 * 行星碰撞
 * https://leetcode-cn.com/submissions/detail/13010095/
 *
 * ArrayDeque 栈结构
 */
public class Test275 {

    public static void main(String[] args) {

        Test275 test275 = new Test275();
        int[] nums = {1,-2,-2,-2};
        int[] res = test275.asteroidCollision(nums);
        System.out.println(res);
    }

    public int[] asteroidCollision(int[] asteroids) {
        //用栈结构进行就近处理 ArrayDeque
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

                //比较完成之后，栈内符号还是异性的。
                if(top != null && top>0 && item <0) {
                    continue;
                } else if (!flag) { //对比完之后，只要不是异性相等值，都添加！！
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
