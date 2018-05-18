package com.zoran.leetcode;

/**
 * 最后一个单词的长度
 * https://leetcode-cn.com/submissions/detail/2376847/
 */
public class Test12 {

	public static void main(String[] args) {
		String str = "Hello World";
		//str =" ";
		System.out.println(lengthOfLastWord(str));
	}
	
    public static int lengthOfLastWord(String s) {
    	String[] array = s.split(" ");
    	
    	if (array == null || array.length== 0 ) {
			return 0;
		}
    	return array[array.length - 1].length();
    }
}
