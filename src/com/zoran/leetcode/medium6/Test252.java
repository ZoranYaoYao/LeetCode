package com.zoran.leetcode.medium6;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * 分割数组为连续子序列
 * https://leetcode-cn.com/submissions/detail/12282434/
 *
 * [Solution]
 * https://blog.csdn.net/qq_26410101/article/details/82078202
 * https://www.cnblogs.com/wang-bing/p/10324562.html
 *
 * HashMap 可以记录后续需要值的对应的个数！！
 * 贪心算法： 先满足新建节点，然后在给前面的链表加值
 */
public class Test252 {

    /**
     * [1,2,3,3,4,5]
     * 强贪心算法不对
     */
    public boolean isPossible(int[] nums) {
        //对应数组存储是否用过
        if (nums.length < 3) return false;

        boolean[] marked = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (marked[i]) continue;
            int last = nums[i];
            int count = 1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > last + 1) break;

                if (nums[j] + 1 == last) {
                    marked[j] = true;
                    count++;
                    last = nums[j];
                }
            }
            if (count < 3) return false;
        }

        return true;
    }
}

class Nice_Test252 {

    public boolean isPossible(int[] nums) {
        //数组中每个元素与出现次数的对应关系
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        for (int n : nums) {
            if (freq.getOrDefault(n, 0) == 0) continue;
            // 如果该数是前面hashMap中需要的值，则进行插入到hashMap中
            if (need.getOrDefault(n, 0) > 0) {
                need.put(n, need.get(n) - 1);
                need.put(n + 1, need.getOrDefault(n + 1, 0) + 1);
            }
            // 如果前面不需要，则从新作为一个新的节点
            else if (freq.getOrDefault(n + 1, 0) > 0
                    && freq.getOrDefault(n + 2, 0) > 0) {
                freq.put(n + 1, freq.get(n + 1) - 1);
                freq.put(n + 2, freq.get(n + 2) - 1);
                need.put(n + 3, need.getOrDefault(n + 3, 0) + 1);
            } else return false;
            freq.put(n, freq.get(n) - 1);
        }
        return true;
    }
}


















