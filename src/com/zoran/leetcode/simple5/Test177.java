package com.zoran.leetcode.simple5;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 宝石与石头
 * https://leetcode-cn.com/submissions/detail/5520704/
 */
public class Test177 {

	public int numJewelsInStones(String J, String S) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<J.length(); i++) {
			if(map.get(J.charAt(i)) == null ) {
				map.put(J.charAt(i),0);
			} 
		}

		for(int i=0; i<S.length(); i++) {
			if(map.get(S.charAt(i)) != null) {
				map.put(S.charAt(i), map.get(S.charAt(i))+1);
			}
		}

		int count =0;
		for(Entry<Character, Integer> item: map.entrySet()) {
			count += item.getValue();
		}

		return count;
	}

	public int Nice_numJewelsInStones(String J, String S) {
		char[] ss = S.toCharArray();
		int num =0;

		for(int i=0; i<ss.length; i++) {
			if(J.indexOf(ss[i]) >= 0) num++;
		}

		return num;
	}
}
