package com.zoran.leetcode.medium5;

import java.util.HashMap;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/11697962/
 *
 * [Solution]
 * https://www.cnblogs.com/geek1116/p/9389236.html
 *
 * ǰ׺�ͣ��м�б�׼��
 */
public class Test214 {

    /**
     * �������� ��ʱ
     */
    public int findMaxLength(int[] nums) {
        //��٣��滻����ֵ
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
            if (sum == 0) res = i+1; //Core. �����ģ�����ֱ�ӿ���ȡ���ֵ
            //Nice_Core. ���map��ǰ׺��û�У�˵��ǰ��û�г��ֹ����������ڵ�ǰsum��ֵ�ģ���
            if (map.get(sum) == null) {
                map.put(sum, i);
                continue;
            }
            //Nice_Core ���ǰ����ֹ�������Զ϶���ǰ�浽�������λ�õ��м�֮�;͵���0����
            res = Math.max(res, i-map.get(sum));
        }
        return res;
    }
}
