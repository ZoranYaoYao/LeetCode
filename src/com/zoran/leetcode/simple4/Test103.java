package com.zoran.leetcode.simple4;


/**
 * 数字的补数
 * https://leetcode-cn.com/submissions/detail/4033334/
 */
public class Test103 {
	
	public static void main(String[] args) {
		System.out.println(findComplement(5));
	}
	
    public static int findComplement(int num) {
        String binaryNum = Integer.toBinaryString(num);
        char[] chrs = binaryNum.toCharArray();
        String negate = new String();
        for(int i = 0; i < chrs.length; i++) {
        	if(chrs[i] == '0') {
        		chrs[i] = '1';
        	}else {
        		chrs[i] ='0';
        	}
        	negate = negate + chrs[i];
        }
      
        char[] negateChrs = negate.toCharArray();
        int result = 0;
        for(int i = negateChrs.length -1; i >= 0; i--) {
        	if(negateChrs[i] == '1') {
        		result += Math.pow(2, negateChrs.length - 1 -i); //Core. 高位的二进制位数
        	}
        }
        
        return result;
    }

    
    /**
     * Core. 通过数学的方式计算每个数字的和
     */
    public int Nice_findComplement(int num) {
    	int m =0; int sum = 0;
    	int j =0;
    	while (num != 0) {
    		m = num%2;
    		if (m ==0) {
    			m =1;
    		}else {
    			m = 0;
    		}
    		num = num /2;
    		sum += m*Math.pow(2, j);
    		j++;
    	}
    	
    	return sum;
    }
}
