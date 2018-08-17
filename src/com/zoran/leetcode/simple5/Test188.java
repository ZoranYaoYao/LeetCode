package com.zoran.leetcode.simple5;

/**
 * É½ÑòÀ­¶¡ÎÄ
 * https://leetcode-cn.com/submissions/detail/5673321/
 */
public class Test188 {
	
	public static void main(String[] args) {
		Test188 test188 = new Test188();
		test188.toGoatLatin("The quick brown fox jumped over the lazy dog");
	}

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<words.length; i++) {
            char first = words[i].charAt(0); 
            StringBuilder sb = new StringBuilder(words[i]);
            boolean flag = first=='a' || first=='e' || first=='i' || first=='o' || first=='u'
            		|| first=='A' || first=='E' || first=='I' || first=='O' || first=='U'; 
            if(!flag) {
            	char chr = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(chr);
            } 
            sb.append("ma");
            for(int j=0; j<=i; j++) sb.append("a");
            
            result.append(sb.toString());
            if(i != words.length -1) result.append(" ");
        }
        
        return result.toString();
    }
}
