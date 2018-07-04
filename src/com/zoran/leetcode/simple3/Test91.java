package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 找到字符串中所有字母异位词
 * https://leetcode-cn.com/submissions/detail/3732640/
 * 
 * [Solution]
 * https://blog.csdn.net/chenwuji91/article/details/52981530
 * 窗口移动, 有难度
 */
public class Test91 {
	public static void main(String[] args) {
		List<Integer> list = findAnagrams("abab", "ab");
		for (Integer integer : list) {
			System.out.println(integer + "-----");
		}
	}
	
	static int matchLength;
	/**
	 * 超时
	 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" "a"
	 */
	public static List<Integer> findAnagrams(String s, String p) {
		char[] sChr = s.toCharArray();
		char[] pChr = p.toCharArray();
		List<Character> pList = new ArrayList<>();
		for(Character c: pChr) {
			pList.add(c);
		}
		Set<Integer> set = new HashSet<>();

		matchLength = pChr.length; int startIndex = 0;
		for(int m = 0; m < sChr.length; m++) {
			for(int i = m; i < sChr.length; i++) {
				if(pList.contains(sChr[i]) && (sChr.length-i) >= pList.size()) {
					pList.remove((Character) sChr[i]);
					if(matchLength == pChr.length) startIndex = i;
					matchLength--;
					if(matchLength == 0) {
						set.add(startIndex);
						reset(pList, pChr);
					}
				} else {
					reset(pList, pChr);
				}
			}
		}

		List<Integer> list = new ArrayList<>();
		for (Integer integer : set) {
			list.add(integer);
		}
		
		return list;
	}
	
	public static void reset(List<Character> pList,char[] pChr) {
		matchLength = pChr.length;
		pList.clear();
		for(Character c: pChr) {
			pList.add((Character)c);
		}
	}


    public List<Integer> Nice_findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null||s.length() == 0||p == null||p.length()==0)
            return result;
        int[] hash = new int[256];
        char[] pp = p.toCharArray();
        for(char i:pp){
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length();
        while(right < s.length())
        {
            if(hash[s.charAt(right++)]-- > 0)  //窗口右移；相应的hash值减小；如果这个位置的Hash值是正的，表示p字符串也包含这个，所以count做减法
                count--;
            if(count == 0)
                result.add(left);//count指示器，为0表示和p对应的hash值完全一致
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0) 
                //如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
                count++;
        }
        return result;
        
    }

}
