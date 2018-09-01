package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import javax.print.attribute.standard.NumberUpSupported;

/**
 * ȫ���� II
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
	 * �㷨��ȷ, ���ǳ�ʱ!
	 * ʹ��hashmap ͳ��ֵҲ��ʱ
	 * Root Cause:
	 * ÿ�ζ��������ͬ��Ԫ������, �����length == nums.length��ȥ��, �ǳ��ĺ�ʱ
	 */
    public List<List<Integer>> permuteUnique(int[] nums) {
        //���� + ȥ��: listȥ��
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
     * @param tempMap �洢����
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
			for(int i=0; i<num.length; i++) { //Core. ��0������ʼ����
				//CCore. 
				//ȥ�ص�һ��case: ��ǰ�����Ѿ��ù���, ��ȥ����ǰ�������ظ� ����: 1,2,3 -> ����1��ֵ num[1]=2, �ù�֮��, ��0��ʼ�����Ͳ�������1��ֵ��!!!
				//ȥ�صڶ���case: ��������ֵi ��ǰһ������ֵi-1��ͬʱ, ���ڻ��ݵ�ǰλ�õ�����ֵʱ, �ͻ�ض��ظ�, 
				//����, 1,2,2,3  ����ֵΪ1λ�õ��������: 1,2(����ֵ1),2(����ֵ2),3  :  1,2(����ֵ1),3,2(����ֵ2)
				//             ����ֵΪ1λ�õ��������: 1,2(����ֵ2),2(����ֵ1),3   :  1,2(����ֵ2),3,2(����ֵ1)   
				//���Գ����ظ���.
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



















































