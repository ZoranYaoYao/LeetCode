package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �ڶ����� II
 * https://leetcode-cn.com/submissions/detail/8902376/
 * 
 * [Solution]
 * https://blog.csdn.net/jmspan/article/details/51247423
 * 
 * ע��: ��֤֮��Ԫ��Index > n/2
 */
public class Test130 {
	
	public static void main(String[] args) {
		Test130 test130 = new Test130();
		int[] nums = {4,5,5,5,5,6,6,6};
		test130.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 * ���Բ���
	 * [4,5,5,5,5,6,6,6] 
	 *!! �����: ���4,5, ����һ��Ԫ�ؾ���index=1��5,���Բ��ܴﵽ2����֮���������Ϊn/2
	 */
    public void wiggleSort(int[] nums) {
        //��������, �԰��,Ȼ���������ѡ�����
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
		int mid = (nums.length-1) /2; //Core. �м�����ֵλ��
		for (int i=0, j=mid, k=nums.length-1; i<nums.length; i+=2, j--, k--) {
			nums[i] = sorted[j];
			if (i+1<nums.length) nums[i+1] = sorted[k];
		}
		
	}
}