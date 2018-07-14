package com.zoran.leetcode.simple4;

/**
 * ������
 * https://leetcode-cn.com/submissions/detail/4151813/
 * 
 * [Solution]
 * https://blog.csdn.net/LITTENg/article/details/80202780
 */
public class Test113 {
	
	public static void main(String[] args) {
		System.out.println(checkPerfectNumberU1(28));
	}

	/**
	 * ��ʱ :99999993 
	 */
    public boolean checkPerfectNumber(int num) {
        int count = 0;
        for(int i = 1; i < num; i ++) {
            if(num % i == 0) count += i;
        }
        return count == num;
    }
    
	/**
	 * ��ʱ :99999993 
	 */
    public static boolean checkPerfectNumberU1(int num) {
        int count = 0; int flag = num;
        for(int i = 2; i < num ; i ++) {
            if(num % i == 0 && i < flag ) {
                count += i;
                flag = num/i;
                count += flag;
            }
        }
        return count + 1 == num;
    }

    /**
     *  ��֪һ����nһ������Ӷ��� [1,sqrt(n)]���䵱��
     *  n * n = nums �м�ֵΪ n
     */
    public static boolean Nice_checkPerfectNumber(int num) {
    	if(num == 1) return false;
    	int count = 1;
    	for (int i = 2; i <= Math.sqrt(num); i++) {
    		if (num % i == 0) {
				count += i + num/i;
			}
    	}
    	return count == num;
    }
}
