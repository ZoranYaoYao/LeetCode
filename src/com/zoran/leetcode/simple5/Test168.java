package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 词典中最长的单词
 * https://leetcode-cn.com/submissions/detail/5313854/
 * 
 * LeetCode程序的题意模糊,表达有问题
 */
public class Test168 {

	public static void main(String[] args) {
		Test168 test168 = new Test168();
		String[] strs = {"b","br","bre","brea","break","breakf","breakfa","breakfas",
				"breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
		System.out.println(test168.Nice_longestWord(strs));
	}

	/**
		输入：
		["yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"]
		输出：
		"ewqz"
		预期：
		"yodn"

		LeetCode程序问题
	 */
	public String longestWord(String[] words) {
		Arrays.sort(words); //根据字母顺序排序, 不适用
		List<String> list = new ArrayList<>(Arrays.asList(words));
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) return 1;
				else if(o1.length() < o2.length()) return -1;
				else {
					return o1.compareTo(o2);
				}
			}
		});

		String result = new String();
		for(int i=list.size()-1; i>= 0; i--) {
			if(result.length() == 0 || list.get(i).length() == result.length()) {
				for(int j = 1; j < list.get(i).length(); j++) {
					String str = list.get(i).substring(0,j);
					if(list.contains(str)) {
						result = list.get(i); 
						break;
					}
				}   
			}else if(!result.isEmpty()) {
				break;
			}

		}

		return result;
	}

	public String Nice_longestWord(String[] words) {
		String res = "";
		Arrays.sort(words);
		Set<String> set = new HashSet<>();
		for (String item: words) {
			if (item.length() == 1 || set.contains((item.substring(0, item.length() - 1)))) { 
				// 该问题: 考虑的字符串必须是b, br, bre, brea, break, breakf, breakfa, breakfas, breakfast, 每次都添加一个字符!
				res = item.length() > res.length() ? item : res; //Core. 用大于来过滤后续相等字符串的拼接!
				set.add(item);
			}
		}
		return res;
	}
}
