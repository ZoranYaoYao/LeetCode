package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.List;

/**
 * �ַ����еĵ�һ��Ψһ�ַ�
 * https://leetcode-cn.com/submissions/detail/3586581/
 */
public class Test79 {

    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        
        List<Character> list = new ArrayList<>();
        char[] chr = s.toCharArray();
        for (int i = 0; i < chr.length ; i++) {
            if(list.contains(chr[i])) continue;
            
            for(int j = i+1; j < chr.length; j++) {
                if(chr[i] == chr[j]) {
                    list.add(chr[i]);
                    break;
                }
                
                if(j == chr.length -1) {
                    return i;
                }
            }
            
            if(!list.contains(chr[i])) return i;  //Core. �Ա��ҵ����һ��Ԫ��ʱ, ���д�����
        }
        
        return -1;
    }
}
