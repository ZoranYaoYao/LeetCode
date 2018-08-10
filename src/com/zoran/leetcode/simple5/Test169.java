package com.zoran.leetcode.simple5;

/**
 * Ѱ���������������
 * https://leetcode-cn.com/submissions/detail/5357188/
 * 
 * [Solution]
 * https://www.cnblogs.com/pauljoyce/p/9418880.html
 */
public class Test169 {
	
	public static void main(String[] args) {
		Test169 test169 = new Test169();
		int[] nums = {-1,-1,-1,-1,1,0};
		System.out.println(test169.pivotIndex(nums));
	}

	//���������п����Ǹ���,�п���������
	//˫ָ�� �޷��жϺ�����ֵ������
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0; int right = nums.length -1;
        int leftCount = nums[left]; int rightCount = nums[right];
        while (left+1 < right) {
            if(left+1 == right-1 && leftCount == rightCount) {
                return left+1;
            } 
            
            if(leftCount <= rightCount && nums[left+1] >=0) {
                left++;
                leftCount += nums[left];
            } else if (leftCount <= rightCount && nums[right-1] <= 0){
                right--;
                rightCount += nums[right];
            } else if (leftCount >= rightCount && nums[right-1] >=0) {
                right--;
                rightCount += nums[right];
            } else if(leftCount >= rightCount && nums[left+1] <=0) {
                left++;
                leftCount += nums[left];
            } else {
                left++;
                leftCount += nums[left];
            }
        }
        
        return -1;
    }

    /**
     * ���һ������������[�н���]���е����Һ�
     */
    public int Nice_pivotIndex(int[] nums) {
    	int sum =0; int sumLeft =0; int sumRight =0;
    	for (int n: nums) {
    		sum += n;
    	}
    	
    	for (int i=0; i<nums.length; i++) {
    		if (i==0) {
    			sumLeft =0;
    		} else {
    			sumLeft = sumLeft + nums[i-1];
    		}
    		sumRight = sum - sumLeft - nums[i];
    		if (sumLeft == sumRight) {
    			return i;
    		}
    	}
    	
    	return -1;
    }
}
