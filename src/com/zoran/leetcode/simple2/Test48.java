package com.zoran.leetcode.simple2;

import java.util.HashMap;
import java.util.Map;

/**
 * ͬ���ַ���
 * https://leetcode-cn.com/submissions/detail/3201735/
 */
public class Test48 {
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add")); // ab, aa
	}

	/**
	 *  2��Map һһ��Ӧ. ��ӳ����, ����Ҳ����ӳ�䵽��
	 */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> mapDest = new HashMap<>();
        char[] origin = s.toCharArray();
        char[] dest = t.toCharArray();
        if(origin.length != dest.length) return false;
        
        for(int i=0; i < origin.length; i++) {
            if(map.get(origin[i]) == null) {
                if(mapDest.get(dest[i]) == null){
                    map.put(origin[i],dest[i]);
                    mapDest.put(dest[i],origin[i]);
                } else if(mapDest.get(dest[i]) != origin[i]){
                	return false;
                }
            } else if(map.get(origin[i]) != dest[i]){
                return false;
            } 
        }
        
        return true;
    }
}
