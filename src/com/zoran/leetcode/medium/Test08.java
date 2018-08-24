package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����֮��
 * https://leetcode-cn.com/submissions/detail/6002482/
 * 
 * [Solution]
 * https://www.jianshu.com/p/65a5c9ffff7b
 */
public class Test08 {
	public static void main(String[] args) {
		Test08 test08 = new Test08();
		int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.out.println(test08.threeSum(nums));
	}

	/**
	 * ����ʱ������ 
	 */
    public List<List<Integer>> threeSum(int[] nums) {
        //����, ���ұ���ֵ
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        
        boolean flag = true;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            for(int j=nums.length-1; j>=i+2; j--) {
                for(int k=j-1; k>=i+1; k--) {
                    int sum = nums[i] + nums[j] + nums[k];
                    System.out.println("nums[i]=" + nums[i] + ",nums[j]=" +nums[j]+ ",nums[k]=" + nums[k]);
                    if(nums[i]==0 && nums[j]==0 && nums[k]==0 && flag) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                        list.add(temp);
                        flag = false;
                    }
                    
                    if(sum == 0) {
                    	boolean hased = false;
                        for(List<Integer> item: list) {
                            if(item.contains(nums[i]) && item.contains(nums[j]) && item.contains(nums[k])) { //�����: 3��0 �뵱�����0
                            	hased = true;
                            	break;
                            }
                        }
                        
                        if(hased) continue;
                        
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                        list.add(temp);
                    }
                }
            }
        }
        
        return list;
    }


    /**
     * ����˫ָ�봦�� 
     */
    public List<List<Integer>> Nce_threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(nums.length < 3) return res;
    	
    	Arrays.sort(nums);
    	for (int i=0; i<nums.length; i++) {
    		if (i>0 && nums[i] == nums[i-1]) continue; //Core. �����ظ���ͷ����
    		int left = i+1; int right = nums.length-1;
    		while (left < right) {
    			int sum = nums[i] + nums[left] + nums[right];
    			if(sum == 0) {
    				res.add(Arrays.asList(nums[i],nums[left],nums[right]));
        			while (left<right && nums[left] == nums[left+1]) left++; //Core. ȥ���ظ���
        			while (left<right && nums[right] == nums[right-1]) right--; //Core. ȥ���ظ���
        			left++;
        			right--; //Nice.��ȵ�ʱ��,2��ָ�붼���м�����
    			} else if (sum <0) {
    				left++;
    			} else {
    				right--;
    			}
    		}
    	}
    	
    	return res;
    }

}
