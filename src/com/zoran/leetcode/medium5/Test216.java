package com.zoran.leetcode.medium5;

import java.util.Random;

/**
 * ��Ȩ�����ѡ��
 * https://leetcode-cn.com/submissions/detail/11737472/
 *
 * [Solution]
 * https://blog.csdn.net/fuxuemingzhu/article/details/81807215
 * https://blog.csdn.net/BigFatSheep/article/details/83318061
 *
 * �������������Ȩ����̫�ֲ�
 * ʹ��ռ������/������
 */
public class Test216 {

}

class Nice_Test216 {
    class Solution {
        int[] sum;
        Random rand;

        public Solution(int[] w) {
            this.rand = new Random();
            for (int i=1; i<w.length; i++) {
                w[i] += w[i-1]; //Nice_Core �����Ȩ������
            }
            this.sum = w;
        }

        public int pickIndex() {
            int value = rand.nextInt(sum[sum.length-1]) + 1;
            int left = 0, right = sum.length - 1;
            while (left <= right) {
                int mid = (left+right)/2;
                if (sum[mid] == value) {
                    return mid;
                } else if (sum[mid] > value) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
