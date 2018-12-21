package com.zoran.leetcode.medium4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * �����������ļ���������
 * https://leetcode-cn.com/submissions/detail/10712130/
 *
 * [Solution]
 * https://blog.csdn.net/conniewu/article/details/80041067
 *
 * 1. �������
 * 2. ��ÿһ�ε���˽������䣬���бȽϣ�����������������Ҫ���һ��������
 */
public class Test184 {

    public static void main(String[] args) {
        int[][] nums = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        Test184 test184 = new Test184();
        int res = test184.findMinArrowShots(nums);
        System.out.println(res);
    }

    /**
     * [[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
     * �ⲻ�����㷨������
     */
    public int findMinArrowShots(int[][] points) {
        //��ʼ�������������غ���ȥ����ֱ��ĩβ
        if(points == null || points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1]; //Core ��ʼ������,������Ҳ������
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int res = 0;
        int[] cur = points[0];
        for(int i=0; i<points.length; i++) {
            if (points[i][0] > cur[1]) { //��ʼ��>��ǰ������
                res++;  //�����ǰ������
                cur = points[i];
            }

//            if (cur == points[points.length-1])
        }
        return ++res;
    }
}

class Nice_Test184 {
    /**
     * 1. �������
     * 2. ��ÿһ�ε���˽������䣬���бȽϣ�����������������Ҫ���һ��������
     */
    public int findMinArrowShots(int[][] points) {
        int len1 = points.length;
        if (len1 <1) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int arr_num = 0;
        int[] shoot = new int[points[0].length];
        shoot[0] = points[0][0];
        shoot[1] = points[0][1]; //Nice_Core ��һ��һά����洢ÿһ�εĽ������䣡��
        for (int i =1; i<len1; i++) {
            //��ʼ��<�����Ҷˣ���������������һ���ཻ����
            if (points[i][0] <= shoot[1]) {
                shoot[0] = points[i][0];
                //Core ��С������Χ
                if (shoot[1] > points[i][1]) {
                    shoot[1] = points[i][1];
                }
            } else {
                arr_num++;
                shoot[0] = points[i][0];
                shoot[1] = points[i][1];
            }
        }
        return ++arr_num;
    }
}



























