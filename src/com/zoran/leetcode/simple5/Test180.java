package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 旋转数字
 * https://leetcode-cn.com/submissions/detail/5526051/
 * 
 * 去数字末尾数字  :  int tail = num % 10;
 */
public class Test180 {

    public int rotatedDigits(int N) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2,5,6,9));
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            int temp = i; boolean flag = true;
            boolean hasRotateNum = false;
            while (temp>0) {
                int tail = temp - temp/10*10; //取末尾
                if(tail == 0 || tail == 1 || tail == 8) {
                    temp = temp /10;
                    continue;
                }
                
                if(!list.contains(tail)) {
                    flag = false;
                    break;
                } else {
                    hasRotateNum = true;
                }
                temp = temp /10;
            }
            if(hasRotateNum && flag) result.add(i);  //Core. flag: (1)表示需要不包含不满足的数字 , (2) 必须有一个旋转的数字
            
        }
        
        return result.size();
    }
    
    /**
     * 代码格式很工整
     */
    public int Nice_rotateDigits(int N) {
    	int res =0;
    	for (int i=1; i<=N; i++) {
    		int temp =i; int mask =0;
    		while (temp >0) {
        		int a = temp%10;
        		if(a==3||a==4||a==7){mask=0;break;}
        		if(a==2||a==5||a==6||a==9) mask=1;
        		temp /= 10;
    		}
    		if (mask == 1) res++;
    	}
    	return res;
    }
}
