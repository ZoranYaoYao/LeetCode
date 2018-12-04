package com.zoran.leetcode.medium4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件的最长绝对路径
 * https://leetcode-cn.com/submissions/detail/10068282/
 *
 * [Solution]
 * https://blog.csdn.net/wdlsjdl2/article/details/53097068
 *
 * 切割， 分层思想
 */
public class Test155 {
    /**
     * 问题是返回路径长度
     */
    public int lengthLongestPath(String input) {
        //统计/n/t/t的个数
        if (!input.contains(".")) return 0;
        char[] chrs = input.toCharArray();
        int res = 0;
        int temp = 0;
        for(int i=0; i<chrs.length; i++) {
            if (chrs[i] == '\\' && i+1<chrs.length && chrs[i+1] == 't') {
                temp++;
            } else {
                int point = input.indexOf(".", i);
                int slash = input.indexOf("\\", i);
                if (point > slash) res = Math.max(res, temp);

                temp = 0;
            }
        }

        return res;
    }

}

class LeetCode_Test155 {
    public int lengthLongestPath(String input) {
        int res = 0,level = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        String[] inputs = input.split("\n");
        for (int i=0; i<inputs.length; i++) {
            String s = inputs[i];
            while (s.startsWith("\t")) {
                level++;
                s = s.substring(1); //Core. 获取到层次，并且把\t进行剔除
            }
            if (s.contains(".")) {
                res = Math.max(res, map.get(level) + s.length()); //Nice_Core: 利用了map映射层次关系
            } else {
                level++;
                map.put(level, map.get(level-1) + s.length() +1); //Nice_Core: 跟新level映射关系
            }
            level = 0; //每次计算之后重置
        }

        return  res;
    }
}

class Nice_LeetCode_Test155 {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length +1];
        int maxLen = 0;
        for (String s : paths) {
            int lev = s.lastIndexOf("\t")+1; //Core. 直接获取层数！
            int curLen = stack[lev+1] = stack[lev] + s.length() -lev +1;//Core. 不同的文件夹，会跟新层次上长度
            if (s.contains("."))
                maxLen = Math.max(maxLen, curLen-1);
        }
        return maxLen;
    }
}





















