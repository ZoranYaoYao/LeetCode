package com.zoran.leetcode.medium;

/**
 * 最长回文子串
 * https://leetcode-cn.com/submissions/detail/5896180/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_38595487/article/details/79544215
 */
public class Test03 {
	public static void main(String[] args) {
		Test03 test03 = new Test03();
		System.out.println(test03.longestPalindrome("babad"));
	}

	/**
	 * 超出时间限制
	 */
    public String longestPalindrome(String s) {
        //穷举每个子串是否是回文子串
        char[] arr = s.toCharArray(); String result ="";
        for(int i=0; i<arr.length; i++) {
            String temp = subLongestPalindrome(arr, i);
            if(temp.length() > result.length()) result = temp;
        }
        return result;
    }
    
    public String subLongestPalindrome(char[] arr, int index) {
        String maxSub ="";
        for (int i=arr.length-1; i>=0; i--) {
        	if(index > i) return maxSub;
            String temp = subLongestPalindrome0(arr, index, i);
            if(maxSub.length() < temp.length()) maxSub = temp;
        }
        return maxSub;
    }
    
    public String subLongestPalindrome0(char[] arr, int startIndex, int endIndex) {
    	int left = startIndex; int right = endIndex;
        while(left < right) {
            if(arr[left] != arr[right]) return "";
            left++;
            right--;
        }
        String str = new String(arr).substring(startIndex,endIndex+1);
        return str;
    }
    
    public String Nice_longestPalindrome(String s) {
        if(s== null || s.length() == 0) return "";
        boolean[][] flag = new boolean[s.length()][s.length()];
        int begin = 0;
        int end = 0;
        int maxlen = 0;
 
        for (int i = s.length(); i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i)==s.charAt(j) && (j-i <= 2 || flag[i+1][j-1])){
                    flag[i][j] = true;
                    if (maxlen < j-i+1){
                        maxlen = j-i+1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
 
        return s.substring(begin,end+1);
    }
}
