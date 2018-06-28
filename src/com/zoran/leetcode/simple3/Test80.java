package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.List;

/**
 * �Ҳ�ͬ
 * https://leetcode-cn.com/submissions/detail/3601167/
 */
public class Test80 {

	/**
	 *  ʱ�临�Ӷ�: O(2n)
	 *  ����˫��ѭ��
	 */
    public char findTheDifference(String s, String t) {
        List<Character> list = new ArrayList<>();
        for(char c : t.toCharArray()) {
            list.add(c);
        }
        
        for(char c: s.toCharArray()) {
            list.remove((Character)c); //Core. ����ǿת,�����Ƴ��������������ֵ
        }
        
        return list.get(0);
    }
}
