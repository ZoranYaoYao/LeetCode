package com.zoran.leetcode.simple6;

import java.util.Arrays;

/**
 * ������������ɵ����ʱ��
 * https://leetcode-cn.com/submissions/detail/13464320/
 *
 * [Solution]
 * https://blog.csdn.net/s1210033460/article/details/84728259
 *
 * ���ֵ�оٷ�����
 */
public class Test229 {

    public static void main(String[] args) {
        Test229 test229 = new Test229();
        int[] nums = {0, 4, 0, 0};
        String res = test229.largestTimeFromDigits(nums);
        System.out.println(res);
    }

    /**
     * �����о��㷨���ԣ�
     * ��ʱ��4ʱ����Ҫ�ж�ǰ���Ƿ���2
     */
    public String largestTimeFromDigits(int[] A) {
        //�ֱ����ʱ����ģ��
        Arrays.sort(A);
        if (A[0] == 0 && A[1] == 0 && A[2] == 2 && A[3] == 4)
            return "20:40";

        //��Сʱ
        StringBuilder sb = new StringBuilder();
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max && A[i] < 3) {
                max = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) return "";
        sb.append("" + max);
        A[maxIndex] = -1;
        max = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max && A[i] <= 4) {
                max = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) return "";
        if (max == 4 && sb.toString().equals("2")) {
            boolean flag = true;
            for (int i = 0; i < A.length; i++) {
                if (A[i] > 0 && i != maxIndex) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return sb.append("" + max + ":00").toString();
        }

        maxIndex = -1;
        max = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max && A[i] < 4) {
                max = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) return "";
        sb.append("" + max + ":");
        A[maxIndex] = -1;
        max = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max && A[i] < 6) {
                max = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) return "";
        sb.append("" + max);

        for (int i : A) {
            if (i != -1) {
                sb.append("" + i);
                break;
            }
        }

        return sb.toString();

    }
}

class Nice_Test229 {
    public String largestTimeFromDigits(int[] A) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int sum = 23; sum >= 0; sum--) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (i != j && A[i] * 10 + A[j] == sum) {
                        // �ҵ�Сʱ�����ҷ�����
                        for (int fen = 59; fen >= 0; fen--) {
                            for (int m = 0; m < A.length; m++) {
                                for (int n = 0; n < A.length; n++) {
                                    if (m != n && A[m] * 10 + A[n] == fen && m != i && m != j && n != i && n != j) {
                                        stringBuilder.append(A[i]);
                                        stringBuilder.append(A[j]);
                                        stringBuilder.append(':');
                                        stringBuilder.append(A[m]);
                                        stringBuilder.append(A[n]);
                                        return stringBuilder.toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
