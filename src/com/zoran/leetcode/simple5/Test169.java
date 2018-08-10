package com.zoran.leetcode.simple5;

/**
 * 寻找数组的中心索引
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

	//后续数字有可能是负数,有可能是正数
	//双指针 无法判断后续的值的走向
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
     * 穷举一个数组中任意[中界限]所有的左右和
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
