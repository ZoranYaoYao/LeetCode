package com.zoran.leetcode.medium4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �ļ��������·��
 * https://leetcode-cn.com/submissions/detail/10068282/
 *
 * [Solution]
 * https://blog.csdn.net/wdlsjdl2/article/details/53097068
 *
 * �и �ֲ�˼��
 */
public class Test155 {
    /**
     * �����Ƿ���·������
     */
    public int lengthLongestPath(String input) {
        //ͳ��/n/t/t�ĸ���
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
                s = s.substring(1); //Core. ��ȡ����Σ����Ұ�\t�����޳�
            }
            if (s.contains(".")) {
                res = Math.max(res, map.get(level) + s.length()); //Nice_Core: ������mapӳ���ι�ϵ
            } else {
                level++;
                map.put(level, map.get(level-1) + s.length() +1); //Nice_Core: ����levelӳ���ϵ
            }
            level = 0; //ÿ�μ���֮������
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
            int lev = s.lastIndexOf("\t")+1; //Core. ֱ�ӻ�ȡ������
            int curLen = stack[lev+1] = stack[lev] + s.length() -lev +1;//Core. ��ͬ���ļ��У�����²���ϳ���
            if (s.contains("."))
                maxLen = Math.max(maxLen, curLen-1);
        }
        return maxLen;
    }
}





















