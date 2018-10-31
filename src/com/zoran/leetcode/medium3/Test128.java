package com.zoran.leetcode.medium3;

import java.util.Arrays;

/**
 * ���ݿ���
 * https://leetcode-cn.com/submissions/detail/8862942/
 * 
 * [Solution]
 * https://blog.csdn.net/weixin_37373020/article/details/80605810
 */
public class Test128 {

	//����ʱ������ 99999
    public int bulbSwitch(int n) {
        //��������, ����
        if (n == 1) return 1;
        if (n == 2) return 1;
        
        int[] bulb = new int[n+1]; //index 0 ������.
        Arrays.fill(bulb, 1);
        bulb[0] = 0;
        for (int i=2; i<n+1; i++) {
            if (i % 2 == 0) bulb[i] =0;
        }
        
        for (int j=3; j<=n; j++) {
            for (int k=1; k<n+1; k++) {
                if (k%j == 0) bulb[k] = bulb[k] == 1 ? 0 : 1;
            }
        }
        
        int res = 0;
        for (int i =1; i<n+1; i++) {
            if (bulb[i] == 1) res++;
        }
        
        return res;
    }
}
