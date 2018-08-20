package com.zoran.leetcode.simple5;

/**
 * 山脉数组的峰顶索引
 * https://leetcode-cn.com/submissions/detail/5793405/
 */
public class Test195 {
	public static void main(String[] args) {
		Test195 test195 = new Test195();
		int[] nums = {0,1,2,1,3};
		System.out.println(test195.peakIndexInMountainArray(nums));
	}

	//LeetCode的解决方案有问题
    public int LeetCode_peakIndexInMountainArray(int[] A) {
        int max = -1;
        for(int i =0 ;i<A.length;i++){
            if(A[i] > max) {
                max =A[i];
            }
             else{
                 return i-1;
             }
        }
        return -1;
    }
    
    public int peakIndexInMountainArray(int[] A) {
        int max = -1; int maxIndex = -1;
        for(int i=0; i<A.length; i++) {
            if(i == A.length-1 && maxIndex == -1) return A.length-1;
            
            if(A[i] < A[i+1]) {
                continue;
            } else if (A[i] == A[i+1]) {
                return -1;
            } else {
                max = A[i];
                maxIndex = i;
                break;
            }
        }
        
        for(int i=maxIndex; i<A.length; i++) {
            if(i == A.length-1)  {
                if(maxIndex != -1) return maxIndex;
                return -1;
            }
            if(A[i] > A[i+1]) {
                continue;
            } else {
                return -1;
            } 
        }
        
        return maxIndex;
    }
}
