package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 子域名访问计数
 * https://leetcode-cn.com/submissions/detail/5576018/
 */
public class Test184 {
	
	public static void main(String[] args) {
		String[] strings = {"9001 discuss.leetcode.com"};
		Test184 test184 = new Test184();
		System.out.println(test184.subdomainVisits(strings));
	}

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String str: cpdomains) {
            String[] temp = str.split(" ");
            String nums = temp[0];
            String source = temp[1];
            
            int index = source.length() -1;
            while(index >= 0) { //Core. 从后向前, 进行字符串的截取
                if(source.charAt(index) == '.' || index == 0) { 
                    String item = source.substring(index+1, source.length());
                	if(index == 0) item = source; //全文本时
                    if(map.get(item) == null) {
                        map.put(item, Integer.valueOf(nums));
                    } else {
                        map.put(item, map.get(item) + Integer.valueOf(nums));
                    }
                }
                index--;
            }
        }
        
        List<String> result = new ArrayList<>();
        for(Entry<String, Integer> item: map.entrySet()) {
            String str = item.getValue() + " " + item.getKey();
            result.add(str);
        }
        
        return result;
    }
}
