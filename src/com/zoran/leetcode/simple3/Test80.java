package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.List;

/**
 * 找不同
 * https://leetcode-cn.com/submissions/detail/3601167/
 */
public class Test80 {

	/**
	 *  时间复杂度: O(2n)
	 *  不用双重循环
	 */
    public char findTheDifference(String s, String t) {
        List<Character> list = new ArrayList<>();
        for(char c : t.toCharArray()) {
            list.add(c);
        }
        
        for(char c: s.toCharArray()) {
            list.remove((Character)c); //Core. 必须强转,才能移出对象而不是索引值
        }
        
        return list.get(0);
    }
}
