package com.zoran.leetcode.simple6;

/**
 * 有效的山脉数组
 * https://leetcode-cn.com/submissions/detail/13381266/
 *
 * while 代码更清晰
 */
public class Test227 {

    /**
     * 太多if else 逻辑混杂
     */
    public boolean validMountainArray(int[] A) {
        //数组只存在一个拐点
        if (A.length < 3) return false;

        int index = 0;
        boolean flag = false; //递减
        for (int i=1; i<A.length; i++) {
            if (A[i] > A[i-1] && !flag) {
                index++;
            } else if(A[i] == A[i-1]){
                return false;
            } else {
                if (!flag) {
                    flag = true;
                    continue;
                } else {
                    if (A[i] > A[i-1]) {
                        return false;
                    }
                }
            }
        }

        return index < A.length-1 && index > 0;
    }
}

class LeetCode_Test227 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int i = 1;
        while (i < A.length) {
            if (A[i-1] < A[i]) {
                ++i;
            } else if (A[i-1] == A[i])
                return false;
            else
                break;
        }
        if (i == A.length || i == 1) return false;

        while (i < A.length) {
            if (A[i-1] > A[i]) {
                ++i;
            } else if (A[i-1] == A[i])
                return false;
            else
                break;
        }

        return i == A.length;
    }
}






