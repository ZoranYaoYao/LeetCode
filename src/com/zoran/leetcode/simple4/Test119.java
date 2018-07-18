package com.zoran.leetcode.simple4;

/**
 * 反转字符串 II
 * https://leetcode-cn.com/submissions/detail/4320989/
 */
public class Test119 {
	public static void main(String[] args) {
		Test119 test119 = new Test119();
		System.out.println(test119.reverseStr("abcdefg", 8));
	}

	/**
	 * 针对字符串进行分组,在进行奇数组反转 
	 */
	public String reverseStr(String s, int k) {
		StringBuilder sb =new StringBuilder();
		char[] chrs = s.toCharArray();
		int times = 1; int number = k; int neibu = k*times-1;
		for(int i =0; i < chrs.length; i++) {
			if(i <= times*k -1 && i >= (times-1)*k) {
				while (true) {
					if(neibu >= chrs.length) {
						neibu--;
					} else {
						sb.append(chrs[neibu--]); //Core. 添加该组中的下一个元素
						break;
					}
				}

			} else {
				sb.append(chrs[i]);
				number--;
				if(number == 0) {
					number = k;
					times += 2;
					neibu = k*times-1;
				}
			}
		}

		return sb.toString();
	}

	public String Nice_reverseStr(String s, int k) {
		if (s == null || s.length() == 0) {
			return s;
		}

		char[] data = s.toCharArray();
		int i = 0;
		while (i < data.length) {
			if(i+k <= data.length) {
				reverse(data, i, i + k -1);
			} else {
				reverse(data, i, data.length -1);
			}

			i += 2*k;
		}
		return new String(data);
	}

	private void reverse(char[] data, int l, int r) {
		while (l < r) {
			char temp = data[l];
			data[l] = data[r];
			data[r] = temp;
			l++;
			r--;
		}
	}
}
