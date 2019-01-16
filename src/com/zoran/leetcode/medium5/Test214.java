package com.zoran.leetcode.medium5;

import java.util.HashMap;

/**
 * 连续数组
 * https://leetcode-cn.com/submissions/detail/11697962/
 *
 * [Solution]
 * https://www.cnblogs.com/geek1116/p/9389236.html
 *
 * 前缀和，中间夹逼准则
 */
public class Test214 {

    /**
     * 超长数组 超时
     */
    public int findMaxLength(int[] nums) {
        //穷举，替换最优值
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j=i; j<nums.length; j++) {
                if (nums[j] == 0) {
                    zero++;
                } else {
                    one++;
                }
                if(zero == one) {
                    res = Math.max(res, zero+one);
                }
            }
        }

        return res;
    }
}

class Nice_Test214 {
    public int findMaxLength(int[] nums) {
        int res = 0, sum = 0;
        for (int i=0; i<nums.length; i++)
            if (nums[i] == 0)
                nums[i] = -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sum == 0) res = i+1; //Core. 连续的，所以直接可以取最大值
            //Nice_Core. 如果map中前缀和没有，说明前面没有出现过加起来等于当前sum的值的！！
            if (map.get(sum) == null) {
                map.put(sum, i);
                continue;
            }
            //Nice_Core 如果前面出现过，则可以断定在前面到现在这个位置的中间之和就等于0！！
            res = Math.max(res, i-map.get(sum));
        }
        return res;
    }
}
