package com.zoran.leetcode.simple2;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * https://leetcode-cn.com/submissions/detail/3201735/
 */
public class Test48 {
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add")); // ab, aa
	}

	/**
	 *  2个Map 一一对应. 你映射我, 那我也必须映射到你
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
