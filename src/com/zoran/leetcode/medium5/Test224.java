package com.zoran.leetcode.medium5;

/**
 * ���ų���
 * https://leetcode-cn.com/submissions/detail/11786776/
 *
 * [Solution]
 * https://blog.csdn.net/JackZhang_123/article/details/78831281
 *
 * ��ѧ����
 */
public class Test224 {
    public String optimalDivision(int[] nums) {
        //��ѧ���⣬ ����������3��ʱ��
        //a/b * (c/d/e) => a*c*d*e /b�Ż�������ֵ
        if (nums == null || nums.length == 0) return "";
        if (nums.length == 1) return ""+nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuilder sb = new StringBuilder();
        sb.append(""+nums[0]);
        for (int i=1; i<nums.length; i++) {
            sb.append("/");
            if (i == 1) {
                sb.append("(");
            }
            sb.append(""+nums[i]);
            if (i == nums.length -1) {
                sb.append(")");
            }
        }
        return sb.toString();
    }
}
