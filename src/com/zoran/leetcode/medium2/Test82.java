package com.zoran.leetcode.medium2;

/**
 * ��ת�ַ�����ĵ���
 * https://leetcode-cn.com/submissions/detail/7744327/
 */
public class Test82 {
	
	public static void main(String[] args) {
		Test82 test82 = new Test82();
		String res = test82.reverseWords("   a   b  c d   e  ");
		System.out.println(res);
	}

    public String reverseWords(String s) {
        //�ж� + ƴ��
        if (s == null && s.length() == 0) return null;
        
        s = s.trim();
        String[] words = s.split(" ");
        //���˿ո�
        
        StringBuilder res = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
        	if(!words[i].equals("")) {
        		res.append(words[i]);
            	if(i!=0) res.append(" ");  //Core. �߼�����, �����res.append(words[i]);��һ���, ���ܷ���if{}֮����ӿո�!!
        	}
        }
        
        return res.toString();
    }
}
