package com.zoran.leetcode.simple6;

/**
 * ɾ������
 * https://leetcode-cn.com/submissions/detail/13459986/
 */
public class Test228 {

    public static void main(String[] args) {
        String[] nums = {"cba","daf","ghi"};
        int res = new Test228().minDeletionSize(nums);
        System.out.println(res);
    }

    public int minDeletionSize(String[] A) {
        //ÿ�������������������+1
        // char[][] arrs = new char[A.length][A[0].length];

        int res = 0;
        for(int col=0; col<A[0].length(); col++) {
            char last = A[0].charAt(col); //ÿ�λ�ȡ��0�еĵ�col�е�ֵ
            for (int row=0; row<A.length; row++) {
                char next = '0';
                if (row+1 < A.length && last> (next=A[row+1].charAt(col))) {
                    res++;
                    break;
                } else {
                    last = next;
                }
            }
            last = '0';
        }
        return res;
    }
}

class LeetCode_Test228 {
    public int minDeletionSize(String[] A) {
        int num = 0;
        for (int i=0; i<A[0].length(); i++) {
            for (int j=1; j<A.length; j++) {
                //Nice_Core �������ͨ���������п��ٷ���
                if (A[j].charAt(i) < A[j-1].charAt(i)) {
                    num++;
                    break;
                }
            }
        }

        return num;
    }
}
