package com.zoran.leetcode.simple3;

/**
 * 猜数字大小
 * https://leetcode-cn.com/submissions/detail/3585723/
 */
public class Test77 {
	
	public static void main(String[] args) {
		System.out.println(guessNumber(10));
	}

	/**
	 * Eclipse正确, LeetCode得不到正确的答案 
	 */
    public static int guessNumber(int n) {
        int left =0, right = n;
        while(left <= right) {
            int middle = left + (right -left)/2;
            int result = guess(middle);
            if(result == 1) {
                right = middle - 1; 
            } else if (result == -1) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        
        return n;
    }

	private static int guess(int num) {
		int correct = 6;
		return num > 6 ? 1 : num < 6 ? -1 : 0;
	}
    
    
}
