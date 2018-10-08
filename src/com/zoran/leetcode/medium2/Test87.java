package com.zoran.leetcode.medium2;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数
 * https://leetcode-cn.com/submissions/detail/7967913/
 * 
 * [Solution]
 * https://blog.csdn.net/tingting256/article/details/49663773
 */
public class Test87 {

}

class Nice_Test87 {
	public String fractionToDecimal (int numerator, int denominator) {
		if (numerator == 0) return "0";
		if (denominator == 0) return String.valueOf(Integer.MAX_VALUE);
		
		String res = new String();
		if ((numerator<0)^(denominator<0)) res += "-";
		
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		
		/*区分整数部分和小数部分*/
		long ren = num / den;
		long rem = num % den;
		res += String.valueOf(ren);
		if (rem == 0) return res;
		
		res += ".";
		Map<Long, Integer> map = new HashMap<>();
		int beg = res.length();
		while (rem >0) {
			rem = rem*10; // Core. 除法规则!
			ren = rem/den;
			
			if(map.containsKey(rem)) {
				String part1 = res.substring(0, map.get(rem));
				String part2 = res.substring(map.get(rem));
				res = part1+"(" + part2 + ")";
			} else {
				res += String.valueOf(ren);
				map.put(rem, beg);
			}
			/**更新位置计数和余数**/
			beg++;
			rem = rem%den;
		}
		
		return res;
	}
}
