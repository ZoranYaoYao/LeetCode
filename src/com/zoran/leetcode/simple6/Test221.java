package com.zoran.leetcode.simple6;

import java.util.HashSet;
import java.util.Set;

/**
 * ���صĵ����ʼ���ַ
 * https://leetcode-cn.com/submissions/detail/13303936/
 */
public class Test221 {
    public int numUniqueEmails(String[] emails) {
        //����HashSet�������е��ʼ�
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
            //Nice_Core ���ַ������зָ����滻����
            //+ : ��Ҫ֮��ģ��ȼ��ڷָ�֮��ֻ��ȡǰ����ַ���!
            //. : ��Ų�Ҫ���ȼ��ڽ�����滻�ɿհ��ַ���
            StringBuilder sb = new StringBuilder(es[0].split("\\+")[0].replaceAll(".",""));
            sb.append("@");
            sb.append(es[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}


































