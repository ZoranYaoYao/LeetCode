package com.zoran.leetcode.medium6;

import java.util.*;

/**
 * 打开转盘锁
 * https://leetcode-cn.com/submissions/detail/15314110/
 *
 * [Solution]
 * https://blog.csdn.net/qq_27480345/article/details/86499958
 */
public class Test280 {
}

class Nice_Test280 {
    public int openLock(String[] deadends, String target) {
        int step = 0;
        List<String> list = Arrays.asList(deadends);
        Queue<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        queue.add("0000");
        used.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i =0; i<size; i++) {
                String cur = queue.peek();
                if (cur.equals(target)) {
                    return step;
                }
                String[] neib = neighbour(cur);
                for (String str : neib) {
                    if (!used.contains(str) && !list.contains(cur)) {
                        queue.add(str);
                        used.add(str);
                    }
                }
                queue.poll();
            }
            //Nice_Core 每一层加一！！
            step++;
        }

        return -1;

    }

    private String[] neighbour(String a) {
        //生成邻居，一个字符串有4位数字，每位数字可以增加1，或减少1，所以总共有4*2=8个邻居
        String ans[]=new String[8];
        for (int i = 0; i < 4; i++) {
            char[] aa=a.toCharArray();
            int a1=aa[i]-'0';
            if (a1!=0) {
                aa[i]=Character.forDigit(a1-1, 10);
            }else {
                aa[i]='9';
            }
            ans[i*2]=String.valueOf(aa);
            if(a1!=9) {
                aa[i]=Character.forDigit(a1+1, 10);
            }else {
                aa[i]='0';
            }
            ans[i*2+1]=String.valueOf(aa);
        }
        return ans;
    }
}

