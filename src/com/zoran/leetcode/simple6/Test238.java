package com.zoran.leetcode.simple6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数组形式的整数加法
 * https://leetcode-cn.com/submissions/detail/14094671/
 */
public class Test238 {

    public static void main(String[] args) {
        int[] A = {1,2,0,0};

        Test238 test238 = new Test238();
        List<Integer> res = test238.addToArrayForm(A, 34);
        System.out.println(res);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        //将K转转换为list
        List<Integer> list = new ArrayList<>();
        while (K != 0) {
            int temp = K%10;
            list.add(temp);
            K /= 10;
        }

        int flag = 0;
        int len = Math.max(A.length, list.size());
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<len; i++) {
            int temp = i < list.size() ? list.get(i) : 0;
            int temp2 =i < A.length ? A[A.length-1 - i] : 0;
            int count = temp + temp2 + flag;
            res.add(0, count % 10);
            flag = count / 10;
        }

        if (flag == 1) {
            res.add(0,1);
        }

        return res;
    }
}

class LeetCode_Test238 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList<>();

        int i=N;
        while (i>0 || cur > 0) {
            if (i>0) {
                //Nice_Core. 每次对最后一个数进行 /10进行移除掉！
                //并且是添加数组里面的元素的！！
                //问题K为Integer.MAX_VALUE 会数据溢出！
                cur = cur + A[i-1];
            }
            ans.add(cur%10);
            cur /= 10;
            i--;
        }

        Collections.reverse(ans);
        return ans;
    }
}

