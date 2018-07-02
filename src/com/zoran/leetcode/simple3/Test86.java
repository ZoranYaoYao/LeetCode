package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * https://leetcode-cn.com/submissions/detail/3667918/
 */
public class Test86 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if(n <= 0) return list;
        
        for(int i=1; i<= n; i++) {
            if(i%3 != 0 && i%5  != 0) {
                list.add("" + i);
            } else if (i%3 == 0 && i%5 != 0) {
                list.add("Fizz");
            } else if (i%3 != 0 && i%5 == 0) {
                list.add("Buzz");
            } else if (i%3 == 0 && i%5 == 0) {
                list.add("FizzBuzz");
            } 
        }
        
        return list;
    }
}
