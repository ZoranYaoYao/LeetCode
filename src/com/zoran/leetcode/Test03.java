package com.zoran.leetcode;
/**
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 * 过程:
 * 1.默认第0个为标准对象
 * 2.跟数组的每个字符串的每个char进行对比
 * @author Zoran
 */
public class Test03 {

	public static void main(String[] args) {
		String[] arr = new String[] {"flower","flow","flight"};
		//System.out.println(longestCommonPrefix(arr));
		System.out.println(Nice_longestCommonPrefix(arr));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		String result =strs[0];
		for(int i = 0; i < strs.length; i++) {
			//result值获得长度更短的那个字符串
			if(result.length() > strs[i].length()) {
				result = strs[i];
			}
		}

		char[] chars = result.toCharArray();
		StringBuilder sBuilder = new StringBuilder();
		for(int j = 0; j < chars.length; j++) {
			boolean stop = false;
			for(int k = 0; k < strs.length; k++) {
				if (chars[j] != strs[k].charAt(j)) {
					stop = true;
					break;
				}
				
				if (k == strs.length -1) {
					sBuilder.append(chars[j]);
				}
			}
			
			if (stop) {
				break;
			}
		}
		return sBuilder.toString();
	}
	
	//最大公共前缀- 表明的意思就是说,每个字符串的子字符串大家都包含!
    public static String Nice_longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String s = strs[0];
        int i = 1;
        while (i < strs.length) {
            while(strs[i].indexOf(s) != 0) {
                s = s.substring(0, s.length() -1);
            }
            i ++;
        }
        return s;
    }

}
