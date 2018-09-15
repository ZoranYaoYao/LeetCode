package com.zoran.leetcode.medium;


/**
 * ���뷽��
 * https://leetcode-cn.com/submissions/detail/7118658/
 * 
 * [Solution]
 * http://www.cnblogs.com/tengdai/p/9245714.html
 * https://blog.csdn.net/u012156116/article/details/79763005
 * 
 *  ��̬�滮: ÿ��һ����,֮��������� ����ǰ������� (��������ϵ)
 *   �������һλ���Ŀ������ + ǰ��������� 
 * dp = Dynamic planning
 */
public class Test50 {
	
    int res = 0;
    /**
     * �㷨���� 
     */
    public int numDecodings(String s) {
        //���: �����㷨, 2��������ϵĸ���
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
 * ��̬�滮: ÿ��һ����,֮��������� ����ǰ������� (��������ϵ)
 * �������һλ���Ŀ������ + ǰ��������� 
 */
class Nice_Test50 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int[] dp = new int[s.length()];
		dp[0] = s.charAt(0) == '0' ? 0: 1; //Core. ����һλ�����
		if (s.length() == 1) return dp[0];
		
		int k = s.charAt(0) >'0' && s.charAt(1)>'0'?1:0;
		dp[1] = k + (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1)<='6'? 1:0); //Core. �����λ�����
		
		for (int i=2; i<dp.length; i++) {
			if (s.charAt(i) != '0') {
				dp[i] += dp[i-1];  //Core. ���һλΪ�����������, ǰ��i-1����Ͼ���i�����.
			}
			
			if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2' && s.charAt(i)<='6') {
				dp[i] += dp[i-2]; //COre. �����һ����ֻ�ܺ�ǰһ�����ϲ��������, ǰ��i-2����Ͼ���i���������
			}
		}
		
		return dp[s.length()-1];
	}
}























