package com.zoran.leetcode;

/**
 * 移除元素
 * https://leetcode-cn.com/submissions/detail/2284006/
 */
public class Test07 {
	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,2,3,0,4,2};
		System.out.println(Nice_removeElement(nums, 2));
	}
	
	/**
	 * 思想: 不会覆盖已有不是移出的值!
	 */
    public static int removeElement(int[] nums, int val) {
    	if(nums ==null || nums.length == 0) return 0;
    	
    	int index = 0; 
    	int needInsert = 0;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] != val) {
    			if(needInsert > 0 || index < i) {
    				nums[index] = nums[i];
    				needInsert--;
    			} 
    			index++;
    		} else {
    			needInsert++;
    		}
    	}
        return index;
    }
    
    
    /**
     * 1.相同的元素,直接跳过
     * 2.不同的元素直接在索引值后面覆盖
     * 
     * 思想: 进行全面覆盖赋值, 0 != 2, 0直接覆盖原来的0值
     */
    public static int Nice_removeElement(int[] nums, int val) {
        int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != val){
				nums[index++] = nums[i];
			}
		}
		return index;
    }
}
