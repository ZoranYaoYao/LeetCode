package com.zoran.leetcode;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/submissions/detail/2666808/
 * 
 * [Solution]
 * https://segmentfault.com/a/1190000005711551
 */
public class Test18 {
	public static void main(String[] args) {
		int[] nums1 = new int[] {0}; int m = 0;
		int[] nums2 = new int[] {1}; int n = 1;
		merge(nums1, m, nums2, n);
	}
	
	/**
	 *  1.对于0有效,无效的处理 处理不对
	 *  2.leetcode case [0],0,[1],1 编译不过!!
	 */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int invalid0 = -1;
    	int first0 = -1; 
    	if(m == 0){
            nums1 = nums2;   //leetcode  return有问题!
            return;
        }  
    	
    	for(int i = 0; i< nums1.length;i++) {
    		if(nums1[i] == 0) {
    			first0 = i;
    			break;
    		}
    	}
    	
        for(int i = 0; i < nums2.length;i++) {
            for(int j = i;j< nums1.length;j++) {
                if(nums2[i] <= nums1[j]) {
                    System.arraycopy(nums1,j,nums1,j+1,nums1.length-1-j);
                    nums1[j] = nums2[i];
                    break;
                }
                
                if(j>=1 && nums1[j] < nums1[j-1]) {
                	invalid0 = j;
                }
            }
            
            if(invalid0 != -1 && nums2[i] > nums1[nums1.length -1]) {  //未插入
            	if(first0 > invalid0) { //判断0是否有效
            		
            	}
            	nums1[invalid0] = nums2[i];
            }
        }
        
        for(int item: nums1) {
        	System.out.println(item + ", ");
        }
    }

    public static void Nice_merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, writeIdx = m + n - 1;
        while (i >= 0 && j >= 0)
            nums1[writeIdx--] = nums1[i] > nums2[j]? nums1[i--] : nums2[j--];
        while (j >= 0)
            nums1[writeIdx--] = nums2[j--];
    }
}
