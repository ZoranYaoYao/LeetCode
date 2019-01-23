package com.zoran.leetcode.medium5;

import java.util.*;

/**
 * 在系统中查找重复文件
 * https://leetcode-cn.com/submissions/detail/11980168/
 *
 * [Solution]
 * https://blog.csdn.net/grape875499765/article/details/73018312
 *
 * 字符串分割 + 哈希表
 */
public class Test234 {
}

class Nice_Test234 {

    public static void main(String[] args) {
        String[] strs = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        Nice_Test234 nice_test23 = new Nice_Test234();
        nice_test23.findDuplicate(strs);
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] file = path.split(" ");
            String root = file[0];
            for (int i=1; i<file.length; i++) {
                String[] content = file[i].split("\\("); //Core. 字符匹配
                System.out.println(Arrays.toString(content));
                ArrayList<String> nowContent = map.getOrDefault(content[1], new ArrayList<>());
                nowContent.add(root + "/" + content[0]);
                map.put(content[1], nowContent);
            }
        }
        List<List<String>> lls = new ArrayList<>();
        for (ArrayList<String> value : map.values()) {
            if (value.size()>1)
                lls.add(value);
        }
        return lls;
    }
}