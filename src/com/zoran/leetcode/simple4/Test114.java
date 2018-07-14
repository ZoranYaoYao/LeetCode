package com.zoran.leetcode.simple4;

/**
 * ����д��ĸ
 * https://leetcode-cn.com/submissions/detail/4154001/
 */
public class Test114 {
	public static void main(String[] args) {
		System.out.println(detectCapitalUse("mL"));
	}
	
	/**
	 * ������ٷ�
	 * �׶�: ÿ��case ��Ҫ���ǵ�, �����߼��쳣 
	 */
    public static boolean detectCapitalUse(String word) {
        char[] chrs = word.toCharArray();
        
        Type type = Type.FirstUpperCase;
        for(int i = 0; i < chrs.length -1; i++) {
            if(i == 0 && !Character.isUpperCase(chrs[i])) {
            	type = Type.AllLowpperCase;
            	continue;
            } else if (i == 0 && Character.isUpperCase(chrs[i])) {
            	type = Type.FirstUpperCase;
            	continue;
            } else if(i == 1 && type == Type.FirstUpperCase) {
            	if (Character.isUpperCase(chrs[i])) {
            		type = Type.AllUpperCase;
            	}
            }
            
            if(Character.isUpperCase(chrs[i]) && Character.isUpperCase(chrs[i+1]) && type != Type.AllUpperCase) return false;
            if(Character.isUpperCase(chrs[i]) && !Character.isUpperCase(chrs[i+1])) return false;
            if(!Character.isUpperCase(chrs[i]) && Character.isUpperCase(chrs[i+1]) && type == Type.FirstUpperCase) return false;
            if(!Character.isUpperCase(chrs[i]) && Character.isUpperCase(chrs[i+1]) && type == Type.AllLowpperCase) return false;
        }
        
        if(chrs.length == 2) {
        	if(Character.isUpperCase(chrs[1]) && type == Type.AllLowpperCase) return false;
        }
        
        return true;
    }
    
    enum Type {
    	FirstUpperCase, AllUpperCase, AllLowpperCase
    }
    
    /**
     * �������ַ��������� 
     */
    public boolean Nice_detectCapitalUse(String word) {
    	String fir = word.substring(0, 1);
    	String str = word.substring(1);
    	if(word.equals(word.toLowerCase()) || word.equals(word.toUpperCase()) ) {
    		return true;
    	} else if (fir.equals(fir.toUpperCase()) && str.equals(str.toLowerCase()) ) {
    		return true;
    	} else {
    		return false;
    	}
    }

    /**
     * ��case����true�İ��� (case�ٵİ���!)
     * nice: �ü��� + ���λ�� ���鿴����Ƿ������ض���case
     */
    public boolean NNice_detectCapitalUse(String word) {
    	int m = 0, n =0, index = 0;
    	for (int i = 0; i < word.length(); i++) {
    		if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				m++;
				index = i;
			} else {
				n++;
			}
    	}
    	
    	if (m == 0 || m == word.length()) {
    		return true;
		} else if (m == 1 && index == 0) {
			return true;
		} else if (n == word.length()) {
			return true;
		} else {
			return false;
		}
    }
}
