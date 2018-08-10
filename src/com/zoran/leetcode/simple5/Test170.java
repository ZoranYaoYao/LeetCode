package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.List;

/**
 * ×Ô³ýÊý
 * https://leetcode-cn.com/submissions/detail/5357653/
 * 
 * OT
 */
public class Test170 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i =left; i <= right; i++) {
            if(isSelfDivisor(i)) list.add(i);
        }
        
        return list;
    }
    
    public boolean isSelfDivisor(int num) {
        int caculate = num;
        while (caculate > 0) {
            int tmp = caculate/10;
            int tail = caculate - tmp*10;
            if(tail == 0 || num % tail != 0) return false;
            
            caculate = tmp;
        }
        
        return true;
    }
}
