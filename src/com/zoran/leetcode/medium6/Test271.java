package com.zoran.leetcode.medium6;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除注释
 * https://leetcode-cn.com/submissions/detail/12706978/
 *
 * [Solution]
 * https://blog.csdn.net/dongbeier/article/details/80575715
 */
public class Test271 {

    /**
     * 注意
     * 1. //单行注释直接跳过
     * 2. 块注释需要注意后面是否包含内容
     */
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean block = false;
        for (String s : source) {
            for (int i=0; i<s.length(); i++) {
                if (!block) {
                    if (i ==s.length()-1) {
                        sb.append(s.charAt(i));
                    } else {
                        String t = s.substring(i,i+2);
                        if (t.equals("/*")) {
                            block = true;
                            i++;
                        } else if (t.equals("//")) {
                            break;
                        } else {
                            sb.append(s.charAt(i));
                        }
                    }
                } else {
                    if (i<s.length()-1) {
                        String t = s.substring(i, i+2);
                        if (t.equals("*/")) {
                            block = false;
                            i++;
                        }
                    }
                }

            }
            if (!block && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
