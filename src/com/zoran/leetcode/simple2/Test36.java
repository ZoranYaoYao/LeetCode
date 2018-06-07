package com.zoran.leetcode.simple2;

/**
 * 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/submissions/detail/2977347/
 */
public class Test36 {

	/**
	 * 穷举法 获取任意2个数相加 等于target值 
	 * 时间复杂度 O(n(n-1))
	 */
    public int[] twoSum(int[] numbers, int target) {
        
        if(numbers == null || numbers.length == 0) return null;
        int[] result = new int[2];
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    result[0] = i+1;result[1] = j+1;
                    return result;
                } else if(numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        
        return result;
    }

    /**
     * core: 
     * 1.有序数组
     * 2.大值 + 小值  与target值 比较, 进行游标移动
     * 时间复杂度 O(n)
     */
    public int[] Nice_twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                return new int[]{i+1,j+1};
            }
        }
        throw new IllegalArgumentException("not find two num");
    }
}
