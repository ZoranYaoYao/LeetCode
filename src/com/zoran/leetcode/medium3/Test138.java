package com.zoran.leetcode.medium3;

/**
 * 整数拆分
 * https://leetcode-cn.com/submissions/detail/9112163/
 * 
 * https://blog.csdn.net/lml0703/article/details/80058421
 * 
 * 正确[Solution]
 * https://blog.csdn.net/OneDeveloper/article/details/79958654
 * 
 * 根据规律找到动态规划公式 , 分离出2,3的分子
 * dp[i] = Math.max(dp[i-2]*2, dp[i-3]*3)
 */
public class Test138 {
	
	public static void main(String[] args) {
		Test138 test138 = new Test138();
		int res = test138.integerBreak(48);
		System.out.println(res);
	}

    public int integerBreak(int n) {
        //动态规划 dp[n] = max{dp[n-1]*1, dp[n-2]*2,...} 或者 2个数相乘!
    	if (n==2) return 1;
    	
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i=3; i<n+1; i++) {
            for (int j=i-1; j>=1; j--) {
                dp[i] = Math.max(dp[i], dp[j]*(i-j));
                dp[i] = Math.max(dp[i], j*(i-j));  //Nice_core: 结果集可能发生在i*(i-j)上
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
