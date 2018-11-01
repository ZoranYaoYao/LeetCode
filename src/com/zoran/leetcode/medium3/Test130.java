package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 摆动排序 II
 * https://leetcode-cn.com/submissions/detail/8902376/
 * 
 * [Solution]
 * https://blog.csdn.net/jmspan/article/details/51247423
 * 
 * 注意: 保证之间元素Index > n/2
 */
public class Test130 {
	
	public static void main(String[] args) {
		Test130 test130 = new Test130();
		int[] nums = {4,5,5,5,5,6,6,6};
		test130.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 * 测试不过
	 * [4,5,5,5,5,6,6,6] 
	 *!! 问题点: 针对4,5, 后面一个元素就是index=1的5,所以不能达到2个数之间索引间距为n/2
	 */
    public void wiggleSort(int[] nums) {
        //排序数组, 对半分,然后后面数据选择插入
        if (nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int mid = (nums.length-1) / 2;
        int firstIndex =0;
        int secIndex = mid+1;
        for (int i=0; i<nums.length; i++) {
            if (i%2 == 0) 
                list.add(nums[firstIndex++]);
            else {
                list.add(nums[secIndex++]);
            }
        }
        
        boolean flag = false;
        for (int i=0; i<list.size(); i++) {
            nums[i] = list.get(i);
            if (i+1 < list.size() && i>0 && (nums[i] == nums[i-1] || nums[i] == list.get(i+1))) flag = true;
        }
        
        if (flag) {
             for (int i=0; i<list.size(); i++) {
                 int middle = (list.size()-1) / 2;
                 if (i < mid) {
                     nums[i] = list.get(middle+i);
                 } else {
                     nums[i] = list.get(i-middle);
                 }
             }
        }
    }
}

class Nice_Test130 {
	public void wiggleSort(int[] nums) {
		int[] sorted = nums.clone();
		Arrays.sort(nums);
		int mid = (nums.length-1) /2; //Core. 中间索引值位置
		for (int i=0, j=mid, k=nums.length-1; i<nums.length; i+=2, j--, k--) {
			nums[i] = sorted[j];
			if (i+1<nums.length) nums[i+1] = sorted[k];
		}
		
	}
}