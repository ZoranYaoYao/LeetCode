package com.zoran.leetcode.simple3;

import java.util.Arrays;

/**
 * 分发饼干
 * https://leetcode-cn.com/submissions/detail/3886744/
 */
public class Test97 {

	/**
	 * 时间复杂度 O(g*s) 
	 */
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);Arrays.sort(s);
		int count = 0;
		for(int i=0; i< s.length; i++) {
			for(int j =0; j < g.length; j++) {
				if(s[i] >= g[j]) {
					count++;
					g[j] = Integer.MAX_VALUE;
					break;
				}
			}
		}

		return count;
	}
	
	/**
	 *  时间复杂度O(n)
	 */
	public int Nice_findContentChildren(int[] g, int[] s) {
		Arrays.sort(g); Arrays.sort(s);
		int gi = 0; int si = 0;
		while (gi < g.length && si < s.length) {
			if(g[gi] <= s[si]) {  //Core. 最小饼干 满足最小需求的人
				gi++;
			}
			si++;
		}
		
		return gi;
	}
}
