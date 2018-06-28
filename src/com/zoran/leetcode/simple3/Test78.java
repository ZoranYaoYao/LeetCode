package com.zoran.leetcode.simple3;

/**
 * �����
 * https://leetcode-cn.com/submissions/detail/3585979/
 */
public class Test78 {

	public static void main(String[] args) {
		System.out.println(canConstruct("a", ""));
	}
	
	/**
	 * ʱ�临�Ӷ�: O(n*m) 
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
     * ʱ�临�Ӷ�: O(n+m) 
     */
    public static boolean Nice_canConstrust(String ransomNote, String magezine) {
    	int[] record = new int[26];
    	for (char c : ransomNote.toCharArray()) {
			record[c - 'a'] ++;
		}
    	
    	for (char c : magezine.toCharArray()) {
			if(--record[c - 'a'] < 0) return false;  //Core. ��¼�ַ����ֵĴ���,��������,����ж�����ĸ���ֵ
		}
    	
    	return true;
    }
}
