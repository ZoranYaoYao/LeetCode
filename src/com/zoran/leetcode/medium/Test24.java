package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import javax.print.attribute.standard.NumberUpSupported;

/**
 * 全排列 II
 * https://leetcode-cn.com/submissions/detail/6365169/
 * 
 * [Solution]
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/50938632
 */
public class Test24 {
	
	public static void main(String[] args) {
		Test24 test24 = new Test24();
		int[] nums = {-1,2,-1,2,1,-1,2,1};
		System.out.println(test24.permuteUnique(nums));
	}

	/**
	 * 算法正确, 但是超时!
	 * 使用hashmap 统计值也超时
	 * Root Cause:
	 * 每次都会遍历相同的元素排列, 在最后length == nums.length才去重, 非常的耗时
	 */
    public List<List<Integer>> permuteUnique(int[] nums) {
        //回溯 + 去重: list去重
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        Arrays.sort(nums);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.get(nums[i]) == null) map.put(nums[i],1);
            else map.put(nums[i], map.get(nums[i])+1);
        }
        backTace(nums, result, new ArrayList<Integer>(), new HashMap<Integer, Integer>(), map);
        return result;
        
    }
    
    /**
     * 
     * @param tempMap 存储个数
     */
    public void backTace(int[] nums, List<List<Integer>> result, List<Integer> temp, Map<Integer, Integer> tempMap, Map<Integer, Integer> map) {
        if(temp.size() == nums.length) {
        	if(result.contains(temp)) return;
            result.add(new ArrayList<Integer>(temp));
        } else {
            for(int i=0; i<nums.length; i++) {	
                int count = tempMap.getOrDefault(nums[i], 0);
                if(count >= map.get(nums[i])) continue; 
                
                temp.add(nums[i]);
                tempMap.put(nums[i], tempMap.getOrDefault(nums[i],0)+1);
                backTace(nums, result, temp, tempMap, map);  
                temp.remove(temp.size()-1);
                tempMap.put(nums[i], tempMap.getOrDefault(nums[i],0)-1);
            }
        }
    }
}

class Nice_Test24 {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int[] visited = new int[num.length];
		Arrays.sort(num);
		backTrace(result, list, visited, num);
		return result;
	}

	private void backTrace(List<List<Integer>> result, ArrayList<Integer> list, int[] visited, int[] num) {
		if(list.size() == num.length) {
			result.add(new ArrayList<>(list));
		} else {
			for(int i=0; i<num.length; i++) { //Core. 从0索引开始排列
				//CCore. 
				//去重第一种case: 当前索引已经用过了, 则去除当前索引的重复 比如: 1,2,3 -> 索引1的值 num[1]=2, 用过之后, 从0开始索引就不用索引1的值了!!!
				//去重第二种case: 当该索引值i 与前一个索引值i-1相同时, 则在回溯当前位置的排列值时, 就会必定重复, 
				//比如, 1,2,2,3  索引值为1位置的排列情况: 1,2(索引值1),2(索引值2),3  :  1,2(索引值1),3,2(索引值2)
				//             索引值为1位置的排列情况: 1,2(索引值2),2(索引值1),3   :  1,2(索引值2),3,2(索引值1)   
				//所以出现重复了.
				if (visited[i]==1 || (i!=0 && num[i]==num[i-1] && visited[i-1]==0)) continue;
				visited[i] =1;
				list.add(num[i]);
				backTrace(result, list, visited, num);
				list.remove(list.size()-1);
				visited[i] =0;
			}
		}
	}
}



















































