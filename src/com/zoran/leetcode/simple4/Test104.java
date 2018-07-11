package com.zoran.leetcode.simple4;

/**
 * 最大回文数乘积
 * https://leetcode-cn.com/submissions/detail/4033926/
 * 
 * [Solution]
 * https://blog.csdn.net/Shauna_Wu/article/details/78247372
 */
public class Test104 {

    public int largestPalindrome(int n) {
        if(n == 1)
            return 9;
        int upper = (int)Math.pow(10,n)-1;
        for(int i = upper; i>upper/10; i--){
            long palin = toPalindrome(i);
            for(int j = upper; j>upper/10; j--){
                if(palin / j > upper)
                    break;
                if(palin % j == 0)
                    return (int)(palin % 1337);
            }
        }
        return -1;        
    }
    public long toPalindrome(int i){
        StringBuffer str = new StringBuffer();
        str.append(i+"");
        String a = str.reverse().toString();
        return Long.parseLong(i+""+a);
    }
}
