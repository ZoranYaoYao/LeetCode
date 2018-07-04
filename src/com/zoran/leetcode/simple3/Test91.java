package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * �ҵ��ַ�����������ĸ��λ��
 * https://leetcode-cn.com/submissions/detail/3732640/
 * 
 * [Solution]
 * https://blog.csdn.net/chenwuji91/article/details/52981530
 * �����ƶ�, ���Ѷ�
 */
public class Test91 {
	public static void main(String[] args) {
		List<Integer> list = findAnagrams("abab", "ab");
		for (Integer integer : list) {
			System.out.println(integer + "-----");
		}
	}
	
	static int matchLength;
	/**
	 * ��ʱ
	 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" "a"
	 */
	public static List<Integer> findAnagrams(String s, String p) {
		char[] sChr = s.toCharArray();
		char[] pChr = p.toCharArray();
		List<Character> pList = new ArrayList<>();
		for(Character c: pChr) {
			pList.add(c);
		}
		Set<Integer> set = new HashSet<>();

		matchLength = pChr.length; int startIndex = 0;
		for(int m = 0; m < sChr.length; m++) {
			for(int i = m; i < sChr.length; i++) {
				if(pList.contains(sChr[i]) && (sChr.length-i) >= pList.size()) {
					pList.remove((Character) sChr[i]);
					if(matchLength == pChr.length) startIndex = i;
					matchLength--;
					if(matchLength == 0) {
						set.add(startIndex);
						reset(pList, pChr);
					}
				} else {
					reset(pList, pChr);
				}
			}
		}

		List<Integer> list = new ArrayList<>();
		for (Integer integer : set) {
			list.add(integer);
		}
		
		return list;
	}
	
	public static void reset(List<Character> pList,char[] pChr) {
		matchLength = pChr.length;
		pList.clear();
		for(Character c: pChr) {
			pList.add((Character)c);
		}
	}


    public List<Integer> Nice_findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null||s.length() == 0||p == null||p.length()==0)
            return result;
        int[] hash = new int[256];
        char[] pp = p.toCharArray();
        for(char i:pp){
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length();
        while(right < s.length())
        {
            if(hash[s.charAt(right++)]-- > 0)  //�������ƣ���Ӧ��hashֵ��С��������λ�õ�Hashֵ�����ģ���ʾp�ַ���Ҳ�������������count������
                count--;
            if(count == 0)
                result.add(left);//countָʾ����Ϊ0��ʾ��p��Ӧ��hashֵ��ȫһ��
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0) 
                //��������ڴ�Сһ����ʱ�򼴴��ڴ�С����Ҫ�Ƚϵ��ַ�����Сһ�µ�ʱ�򣬽�������ߵ�ָ�����ұ��ƶ����ƶ���ͬʱ��ߵ��ַ�������Ϊ�ڵ�һ��if�ĵط�hashֵ��С����������Ҫִ�ж�Ӧ�ָ�����������hashֵ���ӣ�count����ֵ���ӡ�
                count++;
        }
        return result;
        
    }

}
