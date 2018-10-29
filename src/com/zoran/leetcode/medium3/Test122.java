package com.zoran.leetcode.medium3;

/**
 * �ۼ���
 * https://leetcode-cn.com/submissions/detail/8796317/
 * 
 * [Solution]
 * https://blog.csdn.net/jmspan/article/details/51195509
 */
public class Test122 {

    public boolean isAdditiveNumber(String num) {
        //����
        boolean res = false;
        for (int i=1; i+1<num.length(); i++) {
            res = backTrace(num, num.substring(0,i), num.substring(i,i+1), i, i+1);
        }

        return res;
    }
    
    //����ֵ �����ȷ����??
    //secIndex �ڶ���Ԫ��ĩβλ�� 
    private boolean backTrace(String num, String num1, String num2, int firIndex, int secIndex) {
        if (secIndex == num.length()-1) return true;
        
        for (int i=secIndex; i<num.length(); i++) {
            String third = String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
            if (secIndex+1<num.length() && num.indexOf(third, secIndex+1) == secIndex+1) {
                backTrace(num, num2, third, secIndex, secIndex+third.length());
            }
            
        }
        
        return false;
    }
}

class LeetCode_Test122 {
	
    public boolean isAdditiveNumber(String num) {
        char[] arr = num.toCharArray();
        long num1 = 0, num2 = 0, num3 = 0;
        boolean result = false;
        for (int i = 0; i < arr.length - 2; i++){
            num1 = num1 * 10 + arr[i] - '0';
            num2 = 0;
            for (int j = i + 1; j < arr.length - 1; j++){
                num2 = num2 * 10 + arr[j] - '0';
                if (Helper(num1, num2, j+1, arr)) return true;
                if (num2 == 0 && arr[j] == '0') break;
            }
            if (num1 == 0 && arr[i] == '0') break;
        }
        return false;
    }
    
    //�����㷨, �������, û��num1, num2, û�л���
    private boolean Helper(long num1, long num2, int p, char[] arr){
        if (p >= arr.length) return true;
        long num3 = 0;
        boolean result = false;
        for (int i = p; i < arr.length; i++){
            num3 = num3 * 10 + arr[i] - '0'; //Core. ���ַ���,��ȡ����
            if (num3 == num1 + num2 && Helper(num2, num3, i+1, arr)) return true;
            else if (num3 > num1 + num2) return false;
            if (num3 == 0 && arr[i] == '0') break;
        }
        return false;
    }
}