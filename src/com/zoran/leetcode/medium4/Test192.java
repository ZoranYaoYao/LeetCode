package com.zoran.leetcode.medium4;

import java.util.Random;

/**
 * 用 Rand7() 实现 Rand10()
 * https://leetcode-cn.com/submissions/detail/10844323/
 *
 * [Solution]
 * https://www.cnblogs.com/kaituorensheng/p/3970452.html
 *
 * 概率数学
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
     * 算法问题： 随机数不够分散！
     * @return
     */
    public int rand10() {
        //7等分 转换为 10等分
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            count += new Random().nextInt(8);
        }
        return count / 7;
    }
}
