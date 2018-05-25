package com.zoran.leetcode;

/**
 * 爬楼梯
 * 
 *  牛逼: https://blog.csdn.net/my_jobs/article/details/43535179
 */
public class Test16 {

	public static void main(String[] args) {
		/*输入： 3
		输出： 3
		解释： 有三种方法可以爬到楼顶。
		1.  1 步 + 1 步 + 1 步
		2.  1 步 + 2 步
		3.  2 步 + 1 步*/
		System.out.println(Nice_climbStairs(5));
	}
	
	/**
	 * 超时问题: 进行存储 
	 */
	public static int Nice_climbStairs(int n) {
		if(n ==1 || n==2) return n;
		
		int[] all = new int[n+1];
		
		for(int i = 3; i<=n; i++) {
			all[i] = all[i-1] + all[i-2];
		}
		
		return all[n];
	}
	
	//相同元素,组合方式 不可取
    public static int climbStairs(int n) {
    	if(n == 0 ) return 0;
    	
    	int total = 1;
        //步数2的个数,排列组合
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
