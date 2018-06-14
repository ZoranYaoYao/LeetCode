package com.zoran.leetcode.simple2;

/**
 * 计数质数
 * https://leetcode-cn.com/submissions/detail/3179031/
 */
public class Test47 {

	//质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数
	public static void main(String[] args) {
		System.out.println(Zqs_countPrimes(15));
	}
	
	/**
	 * 超时 : 499979 
	 */
    public static int countPrimes(int n) {
        if(n == 1) return 0;
        
        int count = 0;
        for(int i = 2;i <n; i++) { //穷举
            if(i ==2) {
                count++;
                continue;
            }
            
            for(int j =2; j < i; j++) {
                if(i%j == 0) {
                    break;
                }
                
                if(j == i -1) {
                    count++;
                }
            }
        }
        
        return count;
    }

    /**
     * 1.标记奇数所有为质数
     * 2.遍历查找奇数中,可以分解因子的数,如果可以分解, 则减1
     */
    public static int Nice_countPrimes(int n) {
            if (n <= 2) {
               return 0;
           }
           boolean[] notPrimes = new boolean[n];
           int cnt = n / 2;//假设所有奇数都是质数
           for (int i = 3; i * i < n; i += 2) {//只判断奇数的情况 nice_core:  3*5 =15, 5*3 =15, 首先在3的时候就先过滤掉3*5的情况
               if (notPrimes[i]) continue;//如果已经设为合数 不再标记和计数
               for (int j = i * i; j < n; j += 2 * i) {  //nice_core: j = i * (i +2*n) 因式分解
                   if (!notPrimes[j]){
                       cnt--;
                       notPrimes[j] = true;
                   }
               }

           }
           return cnt;
    }
    
    public static int Zqs_countPrimes(int n) {
        if (n <= 1 || n==2) return 0;
        
        boolean[] notPrimes = new boolean[n];
        int count = n/2;
        for(int i =3; i*i < n; i = i+2) { //core i*i
            if(notPrimes[i]) continue; //已经是因数
            
            for(int j = i *i; j < n; j += i*2) { //core j = i*(i+2*n)
                if(!notPrimes[j]) { //core 2个数的公倍数时, 要做判定, 比如 9与25, 值3*(3+72) = 225 ,5*(5+40) = 225  避免重复
                    notPrimes[j] = true;
                    count--;
                }
            }
        }
        
        return count;
    }
}
