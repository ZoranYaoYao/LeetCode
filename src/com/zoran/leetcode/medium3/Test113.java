package com.zoran.leetcode.medium3;

/**
 * H指数
 * https://leetcode-cn.com/submissions/detail/8614228/
 */
public class Test113 {
	
	public static void main(String[] args) {
		Test113 test113 = new Test113();
		int[] nums = {1,1};
		int res = test113.hIndex(nums);
		System.out.println(res);
	}

    public int hIndex(int[] citations) {
        //满足公式 hCount >= h
        if (citations == null || citations.length == 0) return 0;
        
        for (int i=citations.length; i>=0; i--) {
            if (isHth(citations, i)) return i;
        }
        
        return 0;
    }
    
    private boolean isHth(int[] citations, int h) {
        int hCount = 0;
        for (int i =0; i<citations.length; i++) {
            if (citations[i] >= h) hCount++;
        }
        return hCount >= h;
    }
}
