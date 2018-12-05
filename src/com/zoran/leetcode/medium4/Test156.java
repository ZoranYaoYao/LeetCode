package com.zoran.leetcode.medium4;

import java.util.LinkedList;

/**
 * ������Ϸ
 * https://leetcode-cn.com/submissions/detail/10111759/
 *
 * [Solution]
 * https://blog.csdn.net/qq_36946274/article/details/81416957
 */
public class Test156 {

    /**
     * ����ṹ���⣬ɾ��֮���ǰ���ɾ��֮���Ԫ�����У��ڽ���ɾ��
     */
    public int lastRemaining(int n) {
        //����+ɾ���ĸ���
        //��Ƿ�
        int[] nums = new int[n + 1];
        nums[0] = -1;
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        int delNums = 0;
        int orientation = 0; //0-���ң� 1-����
        int lastIndex = 0;
        while (n - delNums>0) {
            if (orientation == 0) {
                for (int i = lastIndex; i <= n; ) {
                    nums[i] = -1;
                    delNums++;
                    i += 2;
                    lastIndex = i;
                }
                if (lastIndex > n) lastIndex -= 2;
                if (lastIndex+1<=n && nums[lastIndex+1] != -1) lastIndex=lastIndex+1; //�õ����һ��λ��
                else lastIndex -= 1;
            } else {
                for (int i = lastIndex; i >= 0; ) {
                    nums[i] = -1;
                    delNums++;
                    i -= 2;
                    lastIndex = i;
                }
                if (lastIndex < 0) lastIndex += 2;
                if (lastIndex-1 >0 && nums[lastIndex-1] != -1) lastIndex =lastIndex-1;
                else lastIndex += 1;
            }

        }

        return 1;

    }
}

























