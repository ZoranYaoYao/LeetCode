package com.zoran.leetcode;

/**
 * ��¥��
 * 
 *  ţ��: https://blog.csdn.net/my_jobs/article/details/43535179
 */
public class Test16 {

	public static void main(String[] args) {
		/*���룺 3
		����� 3
		���ͣ� �����ַ�����������¥����
		1.  1 �� + 1 �� + 1 ��
		2.  1 �� + 2 ��
		3.  2 �� + 1 ��*/
		System.out.println(Nice_climbStairs(5));
	}
	
	/**
	 * ��ʱ����: ���д洢 
	 */
	public static int Nice_climbStairs(int n) {
		if(n ==1 || n==2) return n;
		
		int[] all = new int[n+1];
		
		for(int i = 3; i<=n; i++) {
			all[i] = all[i-1] + all[i-2];
		}
		
		return all[n];
	}
	
	//��ͬԪ��,��Ϸ�ʽ ����ȡ
    public static int climbStairs(int n) {
    	if(n == 0 ) return 0;
    	
    	int total = 1;
        //����2�ĸ���,�������
        for(int i = 1;i*2 <= n; i++) {
            int remaining =  n - 2*i;
            int gap = remaining + 1;
            if(remaining != 0) {
                total += zuhe(gap,i);
            } else {
            	total += 1;
            }
        }
        
        return total;
    }
    
    public static int zuhe(int startIndex, int num) {
        if(num >= 2) {
            return  startIndex * zuhe(startIndex,num -1);
        } else {
            return startIndex;
        }
    }
}
