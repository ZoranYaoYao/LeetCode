package com.zoran.leetcode.medium5;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ΪK��������
 * https://leetcode-cn.com/submissions/detail/11894573/
 *
 * [Nice_Solution]
 * https://www.cnblogs.com/grandyang/p/6810361.html
 */
public class Test227 {
    public int subarraySum(int[] nums, int k) {
        //��ٱ��� ��¼����
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for (int j=i; j<nums.length; j++) {
                if ((sum += nums[j]) == k) res++;
            }
        }
        return res;
    }
}

class Nice_Test227{
    public int subarraySum(int[] nums, int k) {
        int sum =0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            //NNice_Core ͨ��ǰ�����ܺ��ж��ٸ�sum-k��λ�ã��뵱ǰsumλ��
            //�б�֮���м�ĺ;�Ϊ k = sum - (sum-k);
            if (preSum.containsKey(sum -k))
                result += preSum.get(sum-k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
