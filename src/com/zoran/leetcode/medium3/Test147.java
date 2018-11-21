package com.zoran.leetcode.medium3;

import java.util.Arrays;

/**
 * �ڶ�����
 * https://leetcode-cn.com/submissions/detail/9596450/
 *
 * [Solution]
 * https://blog.csdn.net/laputafallen/article/details/79874727
 * https://blog.csdn.net/xuchonghao/article/details/81082673
 */
public class Test147 {

    public static void main(String[] args) {
        Test147 test147 = new Test147();
        int[] nums = {1,7,4,9,2,5};
        int res = test147.wiggleMaxLength(nums);
        System.out.println(res);
    }

    /**
     * ����㣺 ��0��1����Ϊ��Ҫ�ĵ㣬��������
     */
    public int wiggleMaxLength(int[] nums) {
        //��̬�滮������¼���һ��Ԫ�ز�ֵ
        //dp[i] = (dp[i-1], dp[i-1]+1)
        if (nums == null || nums.length == 0) return 0;

        int[] loc = new int[nums.length];  //��¼���һ��Ԫ��ֵ
        int[] symbol = new int[nums.length]; //��¼���һ�εĲ�ֵ
        int[] dp = new int[nums.length];
        dp[0] = 1;
        loc[0] = nums[0];
        symbol[0] = nums[0] > 0 ? 1 : -1;
        dp[1] = 2;
        loc[1] = nums[1];
        symbol[1] = nums[1] - nums[0] > 0 ? 1 : -1;
        for (int i = 2; i < nums.length; i++) {
            if ((symbol[i - 1] == 1 && nums[i] - loc[i-1] < 0)
                    || (symbol[i - 1] == -1 && nums[i] - loc[i-1] > 0)) {
                dp[i] = dp[i - 1] + 1;
                symbol[i] = nums[i] - loc[i-1] < 0 ? -1 : 1;
                loc[i] = nums[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[nums.length - 1];
    }
}

class Nice_Test147 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        Arrays.fill(up,1);
        Arrays.fill(down,1);  //Core ����ÿһԪ�أ�Ĭ�϶��Ǵ�0��ʼ��С�ģ�
        for (int i=1; i< nums.length; i++) {
            for (int j =0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] +1); //Core. up[i]��ͨ��ǰ���down[j]ֵ�����ģ���ٱ���
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1); //Core. down[i] ��ͨ��ǰ���up[j]ֵ�����ģ���ٱ���
                }
            }
        }

        return Math.max(down[nums.length -1], up[nums.length -1]);
    }
}
