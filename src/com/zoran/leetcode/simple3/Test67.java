package com.zoran.leetcode.simple3;

/**
 * Nim游戏 
 * https://leetcode-cn.com/submissions/detail/3512977/
 */
public class Test67 {

	/**
	 * 2个人拿石头一轮最少是4个,所以是4的倍数
	 * 有一个先手,所以总数不是4的倍数时,都会根据对方拿多少,进行补齐4操作.
	 * Core:拿石头从后面往前拿.最前面必须要有一个1-2-3的数字
	 *      意思是谁先拿4的开始,谁就会输! 
	 *      比如: 6, 自己拿2, 然后开始4的倍数,对方拿4开始,所以对方输
	 */
	public boolean canWinNim(int n) {
		int remainNum = n - ((n/4) *4);
		if(remainNum == 0) return false;
		return true;
	}
	
}
