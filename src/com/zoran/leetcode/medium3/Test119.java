package com.zoran.leetcode.medium3;

import java.util.Arrays;

/**
 * ²ÂÊı×ÖÓÎÏ·
 * https://leetcode-cn.com/submissions/detail/8657902/
 * 
 * [Solution]
 * https://blog.csdn.net/JackZhang_123/article/details/78122409?locationNum=10&fps=1
 */
public class Test119 {

	public String getHint(String secret, String guess) {
		if(secret==null || guess==null || secret.length()<=0 || guess.length()<=0)
			return "0A0B";
		int bull=0 , cow=0;
		int []flag=new int[10];
		Arrays.fill(flag, 0);

		for(int i=0;i<secret.length();i++) {
			int a=secret.charAt(i)-'0';
			int b=guess.charAt(i)-'0';
			if(a==b)
				bull++;
			else {
				if(flag[a]<0)
					cow++;
				if(flag[b]>0)
					cow++;
				flag[a]++;
				flag[b]--;
			}
		}
		return bull + "A" + cow + "B";
	}
}
