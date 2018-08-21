package com.zoran.leetcode.simple5;

/**
 * �����Ƽ��
 * https://leetcode-cn.com/submissions/detail/5838194/
 * 
 * �õ��㷨
 */
public class Test199 {
	public static void main(String[] args) {
		Test199 test199 = new Test199();
		System.out.println(test199.Nice_binaryGap(8));
	}

    public int binaryGap(int N) {
        int max =0; int startIndex=0;boolean hasFirst = false;
        while(N>0) {
            int yu = N%2;
            if(yu == 1) {
                startIndex++;
                if(startIndex == 0) {
                } else {
                	if(hasFirst) {
                        max = Math.max(max, startIndex);
                	}
                    startIndex = 0;
                }
                hasFirst = true;
            } else {
                if(hasFirst) {
                    startIndex++;
                }
            }
            N = N/2;
        }
        
        return max;
    }

    public int Nice_binaryGap(int N) {
    	int tail = -1; int dis = 0;
    	for(int i=0; i<32; i++) {
    		if(((N>>i) & 1) > 0) { //Nice. ͨ��N>>1����ȥ��ÿλ������ֵ. 2.ͨ�� & 1����,�ܻ�ȡ��λ����ֵ!
    			if(tail >= 0) {
    				dis = Math.max(dis, i-tail);
    			}
    			tail =i;
    		}
    	}
    	return dis;
    }
}
