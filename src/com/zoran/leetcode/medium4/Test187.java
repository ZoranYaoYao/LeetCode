package com.zoran.leetcode.medium4;

import java.util.HashMap;
import java.util.Map;

/**
 * 环形数组循环
 * https://leetcode-cn.com/submissions/detail/10800694/
 *
 * 理解环形数组结构
 */
public class Test187 {

    public static void main(String[] args) {
        Test187 test187 = new Test187();
        int[] nums ={-2, 1, -1, -2, -2}; //环中的元素一律“向前”或者一律“向后
        boolean res = test187.circularArrayLoop(nums);
        System.out.println(res);
    }

    public boolean circularArrayLoop(int[] nums) {
        //遍历每个起始点， 查看是否成环
        boolean res = false;
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Boolean> map = new HashMap<>();

        int length = nums.length;
        for(int i=0; i<length; i++) {
            int lastNum = nums[i];
            int lastIndex = i;
            int curIndex = i;
            boolean isClockwise = lastNum >0;
            while(true) {
                int step = lastNum;
                if ((isClockwise && step<0) || (!isClockwise && step>0)) {
                    map.clear(); //Core. 注意每一次case，都需要重置map
                    break;
                }

                curIndex = (curIndex+step)%length;
                if (curIndex < 0) curIndex = length + curIndex;
                if(map.getOrDefault(curIndex, false) && lastNum != nums[curIndex]) {
                    return true;
                } else if (lastIndex == curIndex) {
                    map.clear();
                    break;
                } else {
                    lastIndex = curIndex;
                    lastNum = nums[curIndex];
                    map.put(curIndex, true);
                }

            }
        }
        return false;
    }
}
