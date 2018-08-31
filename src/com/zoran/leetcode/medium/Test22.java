package com.zoran.leetcode.medium;

/**
 * 字符串相乘
 * https://leetcode-cn.com/submissions/detail/6325104/
 * 
 * [Solution]
 * https://blog.csdn.net/mebiuw/article/details/51156264
 */
public class Test22 {

}

/**
 * 思路：这个题目的思路和我们用笔算做两个数相乘的思路是一样的。从后面往前看：第k位=乘数的第1位乘以被乘数的第k位，+乘数的第2位乘以被乘数的第k-1位
 * ，+...+, 一直到乘数的第k位乘以被乘数的第1位，代码实现即可，注意进位。
 */
class Nice_Test22 {
	
	
    //高精度乘法
    public String Nice_multiply(String num1, String num2) {
        char[] nums1=num1.toCharArray();
        char[] nums2=num2.toCharArray();
        int n=nums1.length,m=nums2.length,i,j,k;
        //一般来说两个数相乘，其最大位数也不会大于啷个位数之和
        int[] result=new int[n+m];
        //转换成数字
        for( i=0;i<n;i++)
            nums1[i]-='0';
        for( i=0;i<m;i++)
            nums2[i]-='0';
        //用nums2的每一位去乘nums1 累加到result
        for( i=0;i<m;i++){
            int carry=0;
            for( j=0;j<n;j++){
                result[i+j]=result[i+j]+nums2[m-1-i]*nums1[n-1-j]+carry;
                carry=result[i+j]/10;
                result[i+j]%=10;
            }
            k=i+j; //Core.  
            //处理进位
            while(carry!=0){ //carry!= 0 最后一位的处理
                result[k]+=carry;
                carry=result[k]/10;
                result[k]%=10;
                k++;
            }
        }
        StringBuilder tmp=new StringBuilder(n+m);
        i=m+n-1;
        while(i>0 && result[i]==0)
            i--;
        while(i>=0)
            tmp.append(result[i--]);
        return tmp.toString();
    }
}