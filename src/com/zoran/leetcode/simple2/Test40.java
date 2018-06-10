package com.zoran.leetcode.simple2;

/**
 * �׳˺����
 * https://leetcode-cn.com/submissions/detail/3065373/
 * 
 * ʱ�临�Ӷ�Ϊ O(log(n)) �Ƕ�����ʽ��ʱ��,�ض���ѭ�����Ե�״̬
 * [eg]
 * nums = 5 ^ n -> log5 (30) 
 * 
 * [Solution]
 * https://www.cnblogs.com/qflyue/p/8974263.html
 */
public class Test40 {

	public static void main(String[] args) {
		System.out.println(Nice_trailingZeroes(40));
	}
	
	/**
	 * long ȡֵ��Χ 2^63 -1 = 9.22 * 10*19
	 * 30! ����long��ȡֵ��Χ ��ֵ���
	 */
    public static int trailingZeroes(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;
        
        long num = 1;    int count = 0;
        while (n > 0) {
            num *= n;
            
            if  (num % 10 == 0) {
                count++;
                num = num /10;
            }
            
            n--;
        }
        
        return count;
    }
    
    /**
     * ʱ�临�Ӷ� O(logN)
     * ����: nums (long)��ֵ���
     */
    public static int trailingZeroesUpdate(int n) {
    	if (n == 0) return 0;
    	
    	int left = 1; int right = n; long nums = 1;int count = 0;
    	while (left <= right) {
    		nums *= left * right;
    		if(left == right) nums = nums / left;
    		
    		if(nums % 10 == 0) {
    			count++;
    			nums = nums / 10;
    		}
    		left++;
    		right--;
    	}
    	
    	return count;
    }

    /**
     * Ѱ�� �˷�����5�ĸ���
     * ʱ�临�Ӷ� O(logN)
     */
    public static int Nice_trailingZeroes(int n) {
    	int sum = 0;
    	while (n > 0) {
    		sum += n/5;
    		n /= 5; //core ��n=25 = 5*5 , ��2��5.
    				//��5���ػ��һ��5
    	}
    	
    	return sum;
    }
}
