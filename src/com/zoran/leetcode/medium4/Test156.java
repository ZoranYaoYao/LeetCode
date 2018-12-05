package com.zoran.leetcode.medium4;

import java.util.LinkedList;

/**
 * 消除游戏
 * https://leetcode-cn.com/submissions/detail/10111759/
 *
 * [Solution]
 * https://blog.csdn.net/qq_36946274/article/details/81416957
 */
public class Test156 {

    /**
     * 数组结构问题，删除之后，是按照删除之后的元素排列，在进行删除
     */
    public int lastRemaining(int n) {
        //数组+删除的个数
        //标记法
        int[] nums = new int[n + 1];
        nums[0] = -1;
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        int delNums = 0;
        int orientation = 0; //0-向右， 1-向左
        int lastIndex = 0;
        while (n - delNums>0) {
            if (orientation == 0) {
                for (int i = lastIndex; i <= n; ) {
                    nums[i] = -1;
                    delNums++;
                    i += 2;
                    lastIndex = i;
                }
                if (lastIndex > n) lastIndex -= 2;
                if (lastIndex+1<=n && nums[lastIndex+1] != -1) lastIndex=lastIndex+1; //得到最后一个位置
                else lastIndex -= 1;
            } else {
                for (int i = lastIndex; i >= 0; ) {
                    nums[i] = -1;
                    delNums++;
                    i -= 2;
                    lastIndex = i;
                }
                if (lastIndex < 0) lastIndex += 2;
                if (lastIndex-1 >0 && nums[lastIndex-1] != -1) lastIndex =lastIndex-1;
                else lastIndex += 1;
            }

        }

        return 1;

    }
}

























