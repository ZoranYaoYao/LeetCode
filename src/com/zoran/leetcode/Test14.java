package com.zoran.leetcode;

import java.util.Arrays;

public class Test14 {
	public static void main(String[] args) {
		//����: a = "1010", b = "1011"
		//���: "10101"
		System.out.println(addBinary("101111", "10"));
	}
	
	
	/**
	 * 1.�ȴ�������ȵ�ʱ��
	 * 2.�ڴ���������ַ�����
	 * 3.���λ�Ƿ��λ
	 */
    public static String addBinary(String a, String b) {
    	char[] charA = a.toCharArray();
    	char[] charB = b.toCharArray();
    	int lessLength = charA.length >= charB.length ? charB.length : charA.length;
    	char[] moreArr = charA.length >= charB.length ? charA : charB;
    	int carry = 0;
    	for(int i = 0; i < lessLength; i++) {
    		int tmpA = charA[charA.length-1-i] == '1' ? 1: 0;
    		int tmpB = charB[charB.length-1-i] == '1' ? 1: 0;
    		if(tmpA + tmpB +carry> 1 ) {
    			if((tmpA + tmpB + carry)%2 == 1) {    //zqs ��λ ��1�����
        			moreArr[moreArr.length-1-i] = '1'; //�ַ�Ҫ�õ�����������
    			} else {
    				moreArr[moreArr.length-1-i] = '0'; //�ַ�Ҫ�õ�����������
    			}
    			carry =1; //��λ
    		} else {
    			moreArr[moreArr.length-1-i] = String.valueOf((tmpA + tmpB + carry)).toCharArray()[0]; //zqs. ��ǰ��λ Ҫ��carry
    			carry =0; //����
    		}
    	}
    	
    	int yu = moreArr.length - lessLength; //����λ��
    	for(int j =0; j < yu;j++) {
    		int tmp = moreArr[yu-j-1] == '1' ? 1: 0;
    		if(tmp + carry > 1) {   //zqs һ�����㶼��ת��Ϊint��,�ڽ��м���
    			moreArr[yu-j-1]= '0';
    			carry=1; //��λ
    		} else {
    			if(tmp + carry ==1) { //zqs ��λ����1
    				moreArr[yu-j-1]= '1';
    			}
    			carry=0; //zqs ����
    		}
    	}
    	
    	char[] finalChar;
    	if(carry == 1) { // ���λ��λ
    		finalChar = new char[moreArr.length + 1];
    		finalChar[0] = '1';
    		System.arraycopy(moreArr, 0, finalChar, 1, moreArr.length);
    		return String.valueOf(finalChar);
    	}
    	
        return String.valueOf(moreArr);
    }
    
    /**
     * �����ַ�λ�� '0' ,��ʼ���мӷ�����
     */
    public String Nice_addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int m = a.length();
        int n = b.length();
        int size = Math.max(m, n);
        char[] result = new char[size];
        char[] longArray = m > n ? a.toCharArray() : b.toCharArray();
        char[] shortArray = m > n ? b.toCharArray() : a.toCharArray();
        int diff = longArray.length - shortArray.length; // important
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int sum = carry + (longArray[i] - '0');
            if (i - diff >= 0) {
                sum += (shortArray[i - diff] - '0');
            }
            carry = sum / 2;
            result[i] = (char)(sum % 2 + '0');
        }

        if (carry != 0) {
            return "1" + new String(result);
        }
        return new String(result);
    }
}
