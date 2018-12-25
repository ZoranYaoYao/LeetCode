package com.zoran.leetcode.medium4;

import java.util.Random;

/**
 * �� Rand7() ʵ�� Rand10()
 * https://leetcode-cn.com/submissions/detail/10844323/
 *
 * [Solution]
 * https://www.cnblogs.com/kaituorensheng/p/3970452.html
 *
 * ������ѧ
 */
public class Test192 {
    public static void main(String[] args) {
        Test192 test192 = new Test192();
        for (int i = 1; i <= 50; i++) {
            int res = test192.rand10();
            System.out.println(res);
        }

    }

    /**
     * �㷨���⣺ �����������ɢ��
     * @return
     */
    public int rand10() {
        //7�ȷ� ת��Ϊ 10�ȷ�
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            count += new Random().nextInt(8);
        }
        return count / 7;
    }
}
