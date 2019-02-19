package com.zoran.leetcode.simple6;

/**
 * 到达终点数字
 * https://leetcode-cn.com/submissions/detail/12961324/
 *
 * [Solutoin]
 * https://blog.csdn.net/elpsycongr00/article/details/81840602
 *
 * 数学，找规律
 */
public class Test209 {

}

class Nice_Test209 {
    public int reachNumber(int target) {
        int times =1;
        int sum =0;
        //Nice_Core. 正负只是符号，进行互换！！
        if (target<0) target = -target;

        while (sum < target) {
            sum += times;
            times++;
        }
        //Core
        times--;

        int diff = Math.abs(sum - target);
        /**Nice 如果差值是偶数的话，通过可以改变符号进行实现！！*/
        if (diff%2 == 0) {
            return times;
        } else {
            if (times%2 == 0) {
                return times+1;
            } else {
                return times+2;
            }
        }
    }
}
