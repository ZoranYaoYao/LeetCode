package com.zoran.leetcode.medium2;

/**
 * 翻转字符串里的单词
 * https://leetcode-cn.com/submissions/detail/7744327/
 */
public class Test82 {
	
	public static void main(String[] args) {
		Test82 test82 = new Test82();
		String res = test82.reverseWords("   a   b  c d   e  ");
		System.out.println(res);
	}

    public String reverseWords(String s) {
        //切断 + 拼接
        if (s == null && s.length() == 0) return null;
        
        s = s.trim();
        String[] words = s.split(" ");
        //过滤空格
        
        StringBuilder res = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
        	if(!words[i].equals("")) {
        		res.append(words[i]);
            	if(i!=0) res.append(" ");  //Core. 逻辑问题, 这个跟res.append(words[i]);是一起的, 不能放在if{}之外添加空格!!
        	}
        }
        
        return res.toString();
    }
}
