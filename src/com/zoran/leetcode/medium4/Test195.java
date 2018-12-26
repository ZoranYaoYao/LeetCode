package com.zoran.leetcode.medium4;

/**
 * 汉明距离总和
 * https://leetcode-cn.com/submissions/detail/10881926/
 *
 * [Solution]
 * https://blog.csdn.net/qq_26410101/article/details/82631873
 *
 * 数学找规律 降低时间复杂度
 */
public class Test195 {
    /**
     * 36 / 47 个通过测试用例
     * 状态：超出时间限制
     */
    public int totalHammingDistance(int[] nums) {
        //异或求有多少个1
        if (nums == null || nums.length == 0) return 0;

        int res = 0;
        for (int i =0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int temp = nums[i] ^ nums[j];
                while (temp != 0) {
                    if ((temp & 1) == 1) res++;
                    temp >>= 1;
                }
            }
        }
        return res;
    }
}

class Nice_Test195 {
    public static void main(String[] args) {
        int[] num = {4,14,2};
        Nice_Test195 test195 = new Nice_Test195();
        int res = test195.totalHammingDistance(num);
        System.out.println(res);
    }

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i=0; i<32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if ((num&(1<<i)) == (1<<i)) cnt++; //Nice_core 每列1的个数
            }
            res += ((nums.length - cnt) * cnt);
        }
        return res;
    }
}
