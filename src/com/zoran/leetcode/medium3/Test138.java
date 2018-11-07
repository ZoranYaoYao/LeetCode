package com.zoran.leetcode.medium3;

/**
 * �������
 * https://leetcode-cn.com/submissions/detail/9112163/
 * 
 * https://blog.csdn.net/lml0703/article/details/80058421
 * 
 * ��ȷ[Solution]
 * https://blog.csdn.net/OneDeveloper/article/details/79958654
 * 
 * ���ݹ����ҵ���̬�滮��ʽ , �����2,3�ķ���
 * dp[i] = Math.max(dp[i-2]*2, dp[i-3]*3)
 */
public class Test138 {
	
	public static void main(String[] args) {
		Test138 test138 = new Test138();
		int res = test138.integerBreak(48);
		System.out.println(res);
	}

    public int integerBreak(int n) {
        //��̬�滮 dp[n] = max{dp[n-1]*1, dp[n-2]*2,...} ���� 2�������!
    	if (n==2) return 1;
    	
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i=3; i<n+1; i++) {
            for (int j=i-1; j>=1; j--) {
                dp[i] = Math.max(dp[i], dp[j]*(i-j));
                dp[i] = Math.max(dp[i], j*(i-j));  //Nice_core: ��������ܷ�����i*(i-j)��
            }
//            System.out.println("dp["+i+"] = " + dp[i]);
        }
        
        return dp[n];
    }
}


class NNice_Test138 {
	public int integerBreak(int n) {
		if (n <= 3) return n-1;
		int[] dp = new int[n+1];
		dp[1] = 1; dp[2] = 2; dp[3] = 3;
		for (int i=4; i<=n; i++) {
			dp[i] = Math.max(dp[i-2]*2, dp[i-3]*3);
		}
		return dp[n];
	}
}
