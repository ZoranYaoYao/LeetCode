package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 公平的糖果交换
 * https://leetcode-cn.com/submissions/detail/5847944/
 */
public class Test205 {
	
	public static void main(String[] args) {
		Test205 test205 = new Test205();
		int[] A = {1,1};
		int[] B = {2,2};
		int[] nums = test205.fairCandySwap(A, B);
		for(int item: nums) {
			System.out.println(item);
		}
	}

    public int[] fairCandySwap(int[] A, int[] B) {
        //差值除以2 , 找有该差值的数
        Arrays.sort(A); Arrays.sort(B);
        List<Integer> list = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        int sumA =0; int sumB =0;
        for(int i=0; i<A.length; i++) {
            list.add(A[i]);
            sumA += A[i];
        }
        for(int i=0; i<B.length; i++) {
            listB.add(B[i]);
            sumB += B[i];
        }
        
        int diff = (sumA -sumB)/2;
        for(int i=0; i<list.size(); i++) {
            if(listB.contains(list.get(i)-diff)) {
                int[] nums = {list.get(i), list.get(i)-diff};
                return nums;
            } 
        }
        
        return null;
    }
}
