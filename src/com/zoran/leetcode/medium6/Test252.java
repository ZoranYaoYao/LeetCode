package com.zoran.leetcode.medium6;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * �ָ�����Ϊ����������
 * https://leetcode-cn.com/submissions/detail/12282434/
 *
 * [Solution]
 * https://blog.csdn.net/qq_26410101/article/details/82078202
 * https://www.cnblogs.com/wang-bing/p/10324562.html
 *
 * HashMap ���Լ�¼������Ҫֵ�Ķ�Ӧ�ĸ�������
 * ̰���㷨�� �������½��ڵ㣬Ȼ���ڸ�ǰ��������ֵ
 */
public class Test252 {

    /**
     * [1,2,3,3,4,5]
     * ǿ̰���㷨����
     */
    public boolean isPossible(int[] nums) {
        //��Ӧ����洢�Ƿ��ù�
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
        //������ÿ��Ԫ������ִ����Ķ�Ӧ��ϵ
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        for (int n : nums) {
            if (freq.getOrDefault(n, 0) == 0) continue;
            // ���������ǰ��hashMap����Ҫ��ֵ������в��뵽hashMap��
            if (need.getOrDefault(n, 0) > 0) {
                need.put(n, need.get(n) - 1);
                need.put(n + 1, need.getOrDefault(n + 1, 0) + 1);
            }
            // ���ǰ�治��Ҫ���������Ϊһ���µĽڵ�
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


















