package com.zoran.leetcode.medium5;

import java.util.Arrays;

/**
 * 任务调度器
 * https://leetcode-cn.com/submissions/detail/11986151/
 *
 * [Solution]
 * https://blog.csdn.net/Koala_Tree/article/details/78498586
 *
 * 见缝插针
 */
public class Test236 {

    public static void main(String[] args) {
        Test236 test236 = new Test236();
        char[] tasks = {'A','A','A','B','B','B'};
        int res = test236.leastInterval(tasks, 0);
        System.out.println(res);
    }

    /**
     * 算法有问题， 类型多的也不能保证一次排列之后，下次还可以是n
     */
    public int leastInterval(char[] tasks, int n) {
        //有任务就执行
        if(n == 0) return tasks.length;

        int[] nums = new int[26];
        for (char c : tasks) {
            nums[c-'A']++;
        }
        Arrays.sort(nums);

        int res = 0;
        int type = 0;
        int lastType = 0;
        while ((type = getType(nums)) >= 0) {
            if (type == 0) {
                res -= (n-lastType-1);
                break;
            }

            if (type > n) {
                int temp = n;
                for (int i=0; i<nums.length; i++) {
                    if (nums[i] > 0 && temp>0) {
                        nums[i]--;
                        temp--;
                    }
                }
                res += temp;
            } else {
                int temp = type;
                for (int i=0; i<nums.length; i++) {
                    if (nums[i] > 0 && temp >0) {
                        nums[i]--;
                        temp--;
                    }
                }
                // res += temp;
                // res = res + (n-temp+1);
                res += n + 1;
                lastType = temp;
            }
        }

        return res;
    }

    private int getType(int[] nums) {
        int res= 0;
        for (int item : nums) {
            if (item > 0) res++;
        }
        return res;
    }
}


class Nice_Test236 {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char t: tasks)
            c[t-'A']++;
        Arrays.sort(c);
        int i=25;
        while (i >= 0 && c[i] == c[25]) i--; //Core. 寻找与最后一个数相同个数;

        //Nice_Core
        return Math.max(tasks.length, (c[25]-1)*(n+1) + (25-i));
    }
}
