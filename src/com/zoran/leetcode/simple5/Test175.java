package com.zoran.leetcode.simple5;

/**
 * 二进制表示中质数个计算置位
 * https://leetcode-cn.com/submissions/detail/5469333/
 */
public class Test175 {
	
	public static void main(String[] args) {
		Test175 test175 = new Test175();
		System.out.println(test175.countPrimeSetBits(567, 607));
	}

	public int countPrimeSetBits(int L, int R) {
		int result = 0;
		for(int i=L; i<=R; i++) {
			if(i ==1) continue;

			String s = Integer.toBinaryString(i); //Core
			char[] chrs = s.toCharArray();
			int count =0;
			for(int j =0; j<chrs.length; j++) {
				if(chrs[j] == '1') count++;
			}
			
			for(int k=2; k<=count;k++) {
				if(k == count) result++;
				
				if(count%k ==0)  break;
			}
		}

		return result;
	}
}
