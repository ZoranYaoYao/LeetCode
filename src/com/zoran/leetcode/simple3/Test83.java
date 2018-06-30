package com.zoran.leetcode.simple3;

import java.util.HashMap;
import java.util.Map;

/**
 * 数字转换为十六进制数
 * https://leetcode-cn.com/submissions/detail/3631007/
 * 
 * [Solution]
 * https://blog.csdn.net/zx2015216856/article/details/80630431 
 */
public class Test83 {
    static Map<Integer,Character> map = new HashMap<>();
    static{
        map.put(10,'a');map.put(11,'b');map.put(12,'c');
        map.put(13,'d');map.put(14,'e');map.put(15,'f');
    }
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "0";
         
        while(num > 0) {
            int tmp = num % 16;
            String str = tmp >= 10 ? ""+map.get(tmp) : ""+tmp;
            sb.append(str);
            num = num / 16;
        }
        
        //negative
        if(num < 0) {
            return Integer.toHexString(num)  ;         
        }
        
        return sb.reverse().toString();
    }

    private static char[] map2 = { '0', '1', '2', '3', '4', '5', '6', 
    		'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    public String Nice_toHex(int num) {
    	if (num == 0) return "0";
    	String result = new String();
    	
    	while(num != 0) {
    		result = map2[num&15] +result; //Nice_Core.
    		num = (num >>> 4); //有符号,移动4位, 移出获得的低4位数字
    	}
    	
    	return result;
    }
}
