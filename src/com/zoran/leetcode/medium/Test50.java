package com.zoran.leetcode.medium;


/**
 * 解码方法
 * https://leetcode-cn.com/submissions/detail/7118658/
 * 
 * [Solution]
 * http://www.cnblogs.com/tengdai/p/9245714.html
 * https://blog.csdn.net/u012156116/article/details/79763005
 * 
 *  动态规划: 每加一格数,之后的组合情况 依赖前面的数组 (有依赖关系)
 *   定义最后一位数的可能情况 + 前面的组合情况 
 * dp = Dynamic planning
 */
public class Test50 {
	
    int res = 0;
    /**
     * 算法不对 
     */
    public int numDecodings(String s) {
        //组合: 回溯算法, 2个数字组合的个数
        if(s == null || s.length() == 0) return 0;
        
        int count = s.length() /2;
        char[] chrs = s.toCharArray();
        for(int i=0; i<=count; i++) {
//            backTrace(chrs, i,)
        }
        
        return -1;
    }
    
    public void backTrace(char[] chrs, int countOf2, int curCountOf2) {
        if(curCountOf2 == countOf2) {
            res++;
        } else {
            for(int i=0; i< chrs.length; i++) {
                
            }
        }
    }
}

/**
 * 动态规划: 每加一格数,之后的组合情况 依赖前面的数组 (有依赖关系)
 * 定义最后一位数的可能情况 + 前面的组合情况 
 */
class Nice_Test50 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int[] dp = new int[s.length()];
		dp[0] = s.charAt(0) == '0' ? 0: 1; //Core. 计算一位的情况
		if (s.length() == 1) return dp[0];
		
		int k = s.charAt(0) >'0' && s.charAt(1)>'0'?1:0;
		dp[1] = k + (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1)<='6'? 1:0); //Core. 计算二位的情况
		
		for (int i=2; i<dp.length; i++) {
			if (s.charAt(i) != '0') {
				dp[i] += dp[i-1];  //Core. 最后一位为个数的情况下, 前面i-1的组合就是i的组合.
			}
			
			if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2' && s.charAt(i)<='6') {
				dp[i] += dp[i-2]; //COre. 当最后一个数只能和前一个数合并的情况下, 前面i-2的组合就是i的组合总数
			}
		}
		
		return dp[s.length()-1];
	}
}























