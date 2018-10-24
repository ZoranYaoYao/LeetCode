package com.zoran.leetcode.medium3;

import java.util.Arrays;

/**
 * ��ȫƽ����
 * https://leetcode-cn.com/submissions/detail/8618243/
 * 
 * [Solution]
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51584790
 *
 * ��̬�滮:
 * dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
 * 
 * �Ż���̬�滮: �ҹ��ɿɵ�, ��С����, һ�����Ը� (ƽ���� + һ��ʣ��ֵ)!!
 * 	dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //��С�������
 */
public class Test115 {

}

class Nice_Test115 {
	public int numSquares(int n) {
		int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 1;
		for (int i=1; i<=n; i++) {
			int sqr = (int) Math.sqrt(i);
			if (sqr*sqr == i) dp[i] = 1;
			else {
				for (int j=1; j<=i/2; j++) { //Core. һ��֮��, �����ظ�2�������+
					dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
				}
			}
		}
		
		return dp[n];
	}
}

class NNice_Test115 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; i++) 
            dp[i * i] = 1;
        for(int i = 1; i <= n; i++) {  //ѡ����һ����Ϊ i
            for(int j = 1; i + j * j <= n; j++) {  //ѡ����һ����Ϊ j*j  NNice_Core. һ�����Ը�ƽ���� + ʣ��ֵ
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //��С�������
            }
        }
        return dp[n];
    }
}