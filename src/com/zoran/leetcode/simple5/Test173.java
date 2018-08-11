package com.zoran.leetcode.simple5;

import java.util.HashMap;
import java.util.Map;


/**
 * 使用最小花费爬楼梯
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
	 * 算法没错,超时了! 
	 */
    public int minCostClimbingStairs(int[] cost) {
        //2种跳出的情况 
    	//	(1) 最后一个元素包含跳出
    	//	(2) 最后第二个袁术包含跳出
//        int count = cost[cost.length-1] + minCostCLimbingStairs0(cost,cost.length-1-2);
//        int count2 = cost[cost.length-1] + minCostCLimbingStairs0(cost, cost.length-1-1);
//        count = count > count2 ? count2 : count;
//        
//        int secondCount = cost[cost.length-2] + minCostCLimbingStairs0(cost,cost.length-2-2);
//        int secondCount2 = cost[cost.length-2] + minCostCLimbingStairs0(cost,cost.length-2-1);
//        secondCount = secondCount > secondCount2 ? secondCount2 : secondCount;
        
//        return count > secondCount ? secondCount : count;
    	
    	//还是超时!
    	//Solution : 用数组存储上一次的代码结果!!
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
     * i 代表第i层
     * 解答思路：每一个位置无非是有两个来源，拿位置i举例，要么是从i-1过来的，要么是从i-2过来的，所以到i的最小花费就是min(i-1,i-2)+i  如此从头开始记录每一步的最小花费，
     * 最后就能得到到达终点的最小花费，代码中使用数组a[ ]存储每一个位置的最小花费，根据题目要求可知将a[ ]的容量大于1000即可。
     * 
     * 公式: 第i层的最低消耗
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
