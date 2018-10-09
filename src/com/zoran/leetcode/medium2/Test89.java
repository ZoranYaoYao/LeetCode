package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 最大数
 * https://leetcode-cn.com/submissions/detail/8018465/
 * 
 * 改进:
 * 可以通过Arrays.sort() 对数组进行排序
 */
public class Test89 {
	
	public static void main(String[] args) {
		Test89 test89 = new Test89();
		int[] nums = {3,30,34,5,9};
		test89.largestNumber(nums);
	}

	public String largestNumber(int[] nums) {
		//数字转换成字符进行排序, 字符最短放在最前面
        //更正: 字符串数字匹配可以通过compareTo(), 2个字符串相连接进行比较
		List<String> list = new ArrayList<>();
		for(int item: nums) list.add(String.valueOf(item));
		Collections.sort(list, new Comparator<String>(){
			public int compare(String o1, String o2) {
				if (o1.equals(o2)) return 0;
				
				String o1linko2 = o1+o2;
				String o2linko1 = o2+o1;
				return o1linko2.compareTo(o2linko1) > 0 ? 1 : -1;
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i=list.size()-1 ; i>=0; i--) sb.append(list.get(i));

		String res = sb.toString();
		while (res.length()>1 && res.charAt(0) == '0') {
			res = res.substring(1);
		}
		return res;
	}
}
