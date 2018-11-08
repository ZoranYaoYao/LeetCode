package com.zoran.leetcode.medium3;

import java.util.HashSet;
import java.util.Set;

/**
 * �������λ����ͬ�����ָ���
 * https://leetcode-cn.com/submissions/detail/9152849/
 * 
 * [Solution]
 * https://blog.csdn.net/genzld/article/details/82946784
 * ���˼��
 */
public class Test141 {

	public static void main(String[] args) {
		Test141 test141 = new Test141();
		int res = test141.countNumbersWithUniqueDigits(3);
		System.out.println(res);
	}
	
	/**
	 * ����ʱ������ n=8
	 */
    public int countNumbersWithUniqueDigits(int n) {
        //01,02��2λ, ��̬�滮
        //f(n) = f(n-1) + [10n-1 - 10n];
        if (n == 0) return 1;
        
        int[] dp = new int[n+1];
        dp[1] = 10;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + sum((int)Math.pow(10,i-1), (int)Math.pow(10,i));
//            System.out.println("dp["+i+"] = " + dp[i]);
        }
        
        return dp[n];
    }
    
    //������end
    public int sum(int start, int end) {
        int count = 0;
        for(int i=start; i<end; i++) {
            if (!duplicateNum(i)) {
//            	System.out.println(i);
            	count++;	
            }
        }
        return count;
    }
    
    Set<Integer> set = new HashSet<>();
    private boolean duplicateNum(int num) {
        set.clear();
        while (num != 0) {
            int temp = num % 10;
            if (!set.add(temp)) return true;
            num = num/10;
        }
        
        return false;
    }
}

//�ҹ���,��ϵ�˼��
class Nice_Test141 {
	int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		if (n == 1) return 10;
		int result = 10;
		int f = 9;
		for (int i=2; i<=n; i++) {
			f *= (10-i+1); //Nice_core: ��ͬλ���µ�����, ÿλ�����ֵ��������ѡ��
			result += f;
		}
		
		return result;
	}
}

