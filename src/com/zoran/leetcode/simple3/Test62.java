package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.List;

/**
 * ³óÊý
 * https://leetcode-cn.com/submissions/detail/3406020/
 * 
 * [Solution]
 * https://blog.csdn.net/hy971216/article/details/80556992
 */
public class Test62 {

	public static void main(String[] args) {
		System.out.println(isUgly(1369479539));
	}

	/**
	 * ³¬Ê±: 1369479539 
	 */
	public static boolean isUgly(int num) {
		if(num == 1 || num == 2 || num == 3 || num == 5) return true;
		if(num <= 0) return false;  //ÌØÊâcase
		
		List<Integer> list = new ArrayList<>();
		for(int i = 2; i < num; i++) {
			if(num % i != 0){
				continue;
			}
			int tmp = num / i;
			if(tmp %2 == 0) {
				list.add(tmp);
				continue;
			}else if(tmp %3 == 0) {
				list.add(tmp);
				continue;
			}else if(tmp %5 == 0) {
				list.add(tmp);
				continue;
			}

			return false;
		}

		if(list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean Nice_isUgly(int num) {
        if(num==0) return false;
        if(num==1) return true;
        if(num%2==0){
            num=num/2;
            return Nice_isUgly(num);
        }
        if(num%3==0){
            num=num/3;
            return Nice_isUgly(num);
        }
        if(num%5==0){
            num=num/5;
            return Nice_isUgly(num);
        }

        return false;
    }
}
