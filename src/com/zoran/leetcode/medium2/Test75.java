package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 * https://leetcode-cn.com/submissions/detail/7618014/
 * 
 * [Solution]
 * http://www.cnblogs.com/tengdai/p/9260942.html
 * 
 * 动态 : dp[i] = dp[j] && wordDict.contains(check) // j索引从0到i-1
 */
public class Test75 {
	public static void main(String[] args) {
		Test75 test75 = new Test75();
		String[] strings = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		List<String> list = new ArrayList<>(Arrays.asList(strings));
		boolean res = test75.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", list);
		System.out.println(res);
	}

	/**
	 * 超出时间限制 
	 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
		["aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"]
	 */
    public boolean wordBreak(String s, List<String> wordDict) {
    	char[] chars = s.toCharArray();
    	boolean flag = false;
    	for(int i=0; i<chars.length; i++) {
    		char item = chars[i];
    		for(int j=0; j<wordDict.size(); j++) {
    			String str = wordDict.get(j);
    			if(str.lastIndexOf(item) != -1) break;
    			
    			if(j == wordDict.size()-1)  flag = true;
    		}
    	}
    	if(flag) return false; //有不包含的字符
        //纪录字符串匹配位置, 递归进行匹配
        boolean res = recursive(s, wordDict, 0);
        return res;
    }
    
    public boolean recursive(String s, List<String> wordDict, int startIndex) {
        boolean result = false;
        if (startIndex >= s.length()) return true;
        
        for(int i=0; i<wordDict.size(); i++) {
            String item = wordDict.get(i);
            int endIndex = startIndex+item.length();
            if(endIndex > s.length()) continue;
            String orign = s.substring(startIndex, endIndex);
//            System.out.println(item + "startIndex=" +startIndex);
            if(item.equals(orign)) result = recursive(s, wordDict, startIndex+item.length());
            
            if(result) return true;
        }
        
        return result;
    }
}

class Nice_Test75 {
	
	public static void main(String[] args) {
		Nice_Test75 test75 = new Nice_Test75();
		String[] strings = {"ab"};
		List<String> list = new ArrayList<>(Arrays.asList(strings));
		boolean res = test75.wordBreak("ab", list);
		System.out.println(res);
	}
	
	/**
	 * 动态 : dp[i] = dp[j] && wordDict.contains(check) // j索引从0到i
	 */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j<i; j++) { //Core. j的索引值
                String check = s.substring(j, i);
                dp[i] = dp[j] && wordDict.contains(check); //Nice_Core: 有多种情况下的到达i索引
                if(dp[i]) break;
            }
        }
        return dp[s.length()];   
    }
}




















