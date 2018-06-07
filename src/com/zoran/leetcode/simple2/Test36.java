package com.zoran.leetcode.simple2;

/**
 * ����֮�� II - ������������
 * https://leetcode-cn.com/submissions/detail/2977347/
 */
public class Test36 {

	/**
	 * ��ٷ� ��ȡ����2������� ����targetֵ 
	 * ʱ�临�Ӷ� O(n(n-1))
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
     * 1.��������
     * 2.��ֵ + Сֵ  ��targetֵ �Ƚ�, �����α��ƶ�
     * ʱ�临�Ӷ� O(n)
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
