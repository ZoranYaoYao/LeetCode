package com.zoran.leetcode.medium6;

/**
 * 灯泡开关 Ⅱ
 * https://leetcode-cn.com/submissions/detail/12319721/
 *
 * [Solution]
 * https://blog.csdn.net/start_lie/article/details/83903071
 *
 * 数学找规律问题!
 */
public class Test256 {
}

class Nice_Test256 {

    public int flipLights(int n, int m) {
        n = n<3?n:3;
        return 1<<n<(1+n*m)?1<<n:(1+n*m);
    }


}