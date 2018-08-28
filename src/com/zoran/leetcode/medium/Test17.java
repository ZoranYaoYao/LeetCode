package com.zoran.leetcode.medium;

/**
 * ������ת��������
 * https://leetcode-cn.com/submissions/detail/6161146/
 * 
 * [Solution]
 * https://www.cnblogs.com/ariel-dreamland/p/9138064.html
 * 
 * ����һ������������������۶��ĸ����ֽ�����ת֮��,  
 * һ������ Ҫô�Ҳ�����, Ҫô�������!!!
 */
public class Test17 {
	
	public static void main(String[] args) {
		Test17 test17 = new Test17();
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(test17.search(nums, 0));
	}

    public int search(int[] nums, int target) {
        //�۰����
        int start = nums[0];
        if(start == target)  return 0;
        int left = 0; int right = nums.length-1;
        while(left <= right) {
            int middle = (left+right)/2;
            int middleNum = nums[middle];
            if(middleNum == target) {
                return (left+right)/2;
            } else if (middleNum<target && target>start) {
                left = middle +1;
            } else if(middleNum>target && target>start) {
                right = middle-1;
            } else if (middleNum<target && target<start) {
                left = middle +1;
            } else if(middleNum>target && target<start) { //�㷨����
                left = middle +1;
            }
        }
        
        return -1;
    }
    
    /**
     * 6����7����0���� 1����2����4����5   target = 6
     * ˼·: ����һ������������������۶��ĸ����ֽ�����ת֮��,  
     * һ������ Ҫô�Ҳ�����, Ҫô�������!!!
     */
    public int Nice_serach(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return -1;
    	int left = 0; int right = nums.length-1;
    	while (left <= right) {
    		int mid = (left +right)/2;
    		if(nums[mid] == target) return mid;
    		else if (nums[mid] < nums[right]) { //Core. �ұ�����
    			if(nums[mid]<target && nums[right]>=target) left=mid+1;
    			else right =mid-1; //�۰�������
    		} else {    //Core. �������
    			if (nums[left] <= target && nums[mid]>target) right =mid -1;
    			else left = mid +1;
    		}
    	}
    	
    	return -1;
    }
}
