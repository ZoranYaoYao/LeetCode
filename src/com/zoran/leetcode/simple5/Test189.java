package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.List;

/**
 * �ϴ�����λ��
 * https://leetcode-cn.com/submissions/detail/5674650/
 */
public class Test189 {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        if(S.length() <= 2) return result;
        
        char[] chars = S.toCharArray();
        int startIndex = 0;int count = 1; char chr = chars[0]; //Core. Ĭ��ֵѡ���һ��Ԫ�ؿ�ʼ -> �Ƚ�
        for(int i=1; i<chars.length; i++) {
            if(chr == chars[i]) {
                count++;
            } else {
                if(count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(startIndex); list.add(i-1);
                    result.add(list);
                }
                startIndex = i;
                chr = chars[i];
                count=1;
            }
            
            //ĩβ��һ����
            if(i == chars.length-1 && count >=3) {
                List<Integer> list = new ArrayList<>();
                list.add(startIndex); list.add(i);
                result.add(list);
            }
        }
        
        return result;
    }
    
    /**
     * index ��1��ʼ,��ǰһ��Ԫ�ؽ��бȽ�
     */
    public List<List<Integer>> Nice_largeGroupPositions(String S) {
        char[] chars = S.toCharArray();
        List<List<Integer>> list = new ArrayList<>();
        int count =1 ;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                count++;
                if(i==chars.length-1){
                    if(count>=3){
                    List<Integer> l = new ArrayList<>();
                    l.add(i-count+1);
                    l.add(i);
                    list.add(l);
                }
                }
            }else{
                if(count>=3){
                    List<Integer> l = new ArrayList<>();
                    l.add(i-count);
                    l.add(i-1);
                    list.add(l);
                }
                count=1;
            }
        }
        return list;
    }
}
