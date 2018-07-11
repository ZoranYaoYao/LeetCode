package com.zoran.leetcode.simple4;

/**
 * 密钥格式化
 * https://leetcode-cn.com/submissions/detail/4036270/
 * 
 * [Solution] Nice-algorithm
 * https://blog.csdn.net/MebiuW/article/details/54409682
 */
public class Test105 {
	
	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
	}

	/**
	 * 输入："2-4A0r7-4k" 4
	 * 输出： "2-4A0R-74K"
	 * 预期： "24A0-R74K"
	 * 
	 * 除了第一组,后续组都需要满足K个值
	 */
	public static String licenseKeyFormatting(String S, int K) {
		char[] chrs = S.toCharArray();
		StringBuilder sb = new StringBuilder(); boolean first = true;
		//A-Z 65 -90 
		//a-z 97 - 122
		int itemCount = 0;
		for(int i = 0; i < chrs.length;i++) {
			if(first) {
				if((int)chrs[i] > 97 &&  (int)chrs[i]< 122) {
					sb.append(Character.toUpperCase(chrs[i]));
				}else if ((int)chrs[i]  == '-') {
					first = false;
					sb.append(chrs[i]);
				} else {
					sb.append(chrs[i]);
				}
			} else {
				if(itemCount < K) {
					if((int)chrs[i] > 97 &&  (int)chrs[i] < 122) {
						sb.append(Character.toUpperCase(chrs[i]));
						itemCount++;
					} else if ((int)chrs[i]  == '-') {
						continue;
					} else {
						sb.append(chrs[i]);
						itemCount++;
					}
				} if(itemCount == K) {
					sb.append('-');
					itemCount = 0;
				}
			}
		}
		
		if (sb.toString().substring(sb.length()- 1).equals("-")) {
			return sb.substring(0,sb.length() -1);
		}
		
		return sb.toString();
	}

	public String Nice_licenseKeyFormatting (String S, int K) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = S.length() -1; i >= 0; i--) {
			if(S.charAt(i) != '-') {
				if (stringBuilder.length() % (K+1) == K) {
					stringBuilder.append('-');
				}
				stringBuilder.append(S.charAt(i));
			}
		}
		
		return stringBuilder.reverse().toString().toUpperCase(); //Core. 反转字符串进行匹配后k个值
	}
}
