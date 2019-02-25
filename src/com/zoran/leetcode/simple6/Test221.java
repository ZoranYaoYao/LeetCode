package com.zoran.leetcode.simple6;

import java.util.HashSet;
import java.util.Set;

/**
 * 独特的电子邮件地址
 * https://leetcode-cn.com/submissions/detail/13303936/
 */
public class Test221 {
    public int numUniqueEmails(String[] emails) {
        //利用HashSet保持所有的邮件
        Set<String> set = new HashSet<>();
        for(String item : emails) {
            StringBuilder sb = new StringBuilder();
            int flag = 0;
            boolean invaild = false;
            for(int i=0; i<item.length(); i++) {
                char cur = item.charAt(i);
                if (cur == '@') {
                    flag = i;
                    break;
                } else {
                    if (cur == '.' || invaild) {
                        continue;
                    } else if(cur == '+'){
                        invaild = true;
                    } else {
                        sb.append(cur);
                    }
                }
            }
            sb.append(item.substring(flag,item.length()));
            set.add(sb.toString());
        }
        return set.size();
    }
}

class LeetCode_Test221 {
    public int numUniqueEmail(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String e : emails) {
            String[] es = e.split("@");
            //Nice_Core 对字符串进行分隔和替换操作
            //+ : 不要之后的，等价于分隔之后只获取前面的字符串!
            //. : 点号不要，等价于将点号替换成空白字符！
            StringBuilder sb = new StringBuilder(es[0].split("\\+")[0].replaceAll(".",""));
            sb.append("@");
            sb.append(es[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}


































