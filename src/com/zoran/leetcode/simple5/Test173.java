package com.zoran.leetcode.simple5;

import java.util.HashMap;
import java.util.Map;


/**
 * ʹ����С������¥��
 * https://leetcode-cn.com/submissions/detail/5397071/
 * 
 * Very_Nice_Solution:
 * https://blog.csdn.net/qq_33389308/article/details/81086471
 */
public class Test173 {
	
	public static void main(String[] args) {
		Test173 test173 = new Test173();
		int[] nums = {1,0,0,1};
		System.out.println(test173.minCostClimbingStairs(nums));
	}

	/**
	 * �㷨û��,��ʱ��! 
	 */
    public int minCostClimbingStairs(int[] cost) {
        //2����������� 
    	//	(1) ���һ��Ԫ�ذ�������
    	//	(2) ���ڶ���Ԭ����������
//        int count = cost[cost.length-1] + minCostCLimbingStairs0(cost,cost.length-1-2);
//        int count2 = cost[cost.length-1] + minCostCLimbingStairs0(cost, cost.length-1-1);
//        count = count > count2 ? count2 : count;
//        
//        int secondCount = cost[cost.length-2] + minCostCLimbingStairs0(cost,cost.length-2-2);
//        int secondCount2 = cost[cost.length-2] + minCostCLimbingStairs0(cost,cost.length-2-1);
//        secondCount = secondCount > secondCount2 ? secondCount2 : secondCount;
        
//        return count > secondCount ? secondCount : count;
    	
    	//���ǳ�ʱ!
    	//Solution : ������洢��һ�εĴ�����!!
    	int count =  minCostCLimbingStairs0(cost, cost.length-1);
    	int count2 = minCostCLimbingStairs0(cost, cost.length-2);
    	return count > count2 ? count2 : count;
        
    }
    public Map<Integer, Integer> map = new HashMap<>();
    
    public int minCostCLimbingStairs0(int[] cost, int endIndex) {
        if(endIndex == 0) return cost[0];
        if(endIndex == 1) return cost[1];
        
        if(map.get(endIndex) != null) return map.get(endIndex);
        
        int count = cost[endIndex] + minCostCLimbingStairs0(cost,endIndex-2);
        int count2 = cost[endIndex] + minCostCLimbingStairs0(cost, endIndex-1);
        int result = count > count2 ? count2 : count;
        map.put(endIndex, result);
        return result;
    }
    
    /**
     * i �����i��
     * ���˼·��ÿһ��λ���޷�����������Դ����λ��i������Ҫô�Ǵ�i-1�����ģ�Ҫô�Ǵ�i-2�����ģ����Ե�i����С���Ѿ���min(i-1,i-2)+i  ��˴�ͷ��ʼ��¼ÿһ������С���ѣ�
     * �����ܵõ������յ����С���ѣ�������ʹ������a[ ]�洢ÿһ��λ�õ���С���ѣ�������ĿҪ���֪��a[ ]����������1000���ɡ�
     * 
     * ��ʽ: ��i����������
     * a[i] = Math.min(a[i-1], a[i-2]) + cost[i];
     */
    public int Very_Nice_minCostClimbingStairs(int[] cost) {
    	int[] a = new int[1001];
    	a[0] = cost[0]; a[1] = cost[1];
    	for (int i=2; i<cost.length; i++) {
    		a[i] = Math.min(a[i-1], a[i-2]) + cost[i]; //Very_nice;
    	}
    	return Math.min(a[cost.length-1], a[cost.length-2]);
    }
    
}
