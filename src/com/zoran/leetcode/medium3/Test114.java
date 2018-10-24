package com.zoran.leetcode.medium3;

/**
 * H指数 II
 * https://leetcode-cn.com/submissions/detail/8614414/
 * 
 * 不是很懂公式?
 */
public class Test114 {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int court = 1;
        for(int i = citations.length - 1;i >= 0;i--){
            if(citations[i] >= court){   
                court++;
            }
        }
        return court - 1;
    }
}
