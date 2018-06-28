package com.zoran.leetcode.simple3;

/**
 * 赎金信
 * https://leetcode-cn.com/submissions/detail/3585979/
 */
public class Test78 {

	public static void main(String[] args) {
		System.out.println(canConstruct("a", ""));
	}
	
	/**
	 * 时间复杂度: O(n*m) 
	 */
    public static boolean canConstruct(String ransomNote, String magazine) {
    	if(magazine.length() < ransomNote.length()) return false;
    	
        char[] ranChr = ransomNote.toCharArray();
        char[] magChr = magazine.toCharArray();
        for(int i = 0; i< ranChr.length; i++) {
            for(int j = 0; j < magChr.length; j++) {
                if(ranChr[i] == magChr[j]) {
                    magChr[j] = ' ';
                    break;
                }
                
                if(j == magChr.length -1) {
                    return false;
                }
            }
        }
        
        return true;
    }

    /**
     * 时间复杂度: O(n+m) 
     */
    public static boolean Nice_canConstrust(String ransomNote, String magezine) {
    	int[] record = new int[26];
    	for (char c : ransomNote.toCharArray()) {
			record[c - 'a'] ++;
		}
    	
    	for (char c : magezine.toCharArray()) {
			if(--record[c - 'a'] < 0) return false;  //Core. 记录字符出现的次数,放入数组,最后判断数组的个数值
		}
    	
    	return true;
    }
}
