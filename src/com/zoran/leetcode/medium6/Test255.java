package com.zoran.leetcode.medium6;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大交换
 * https://leetcode-cn.com/submissions/detail/12287805/
 *
 * 数学问题
 * Core, 这里应该是当替换的值 大于要被替换位置的值，才替换
 */
public class Test255 {

    public int maximumSwap(int num) {
        //如果后面的数有比前面大的，则交换最大的数
        List<Integer> list = new ArrayList<>();
        while(num > 0) {
            int tmp = num % 10;
            list.add(0,tmp);
            num = num /10;
        }

        for (int i=0; i<list.size();i++) {
            int swpIndex = i;
            int swpValue = list.get(i);
            for (int j=i+1; j<list.size();j++) {
                if (swpValue <= list.get(j)) {
                    swpIndex = j;
                    swpValue = list.get(j);
                }
            }

            //Core, 这里应该是当替换的值 大于要被替换位置的值，才替换
//            if (swpIndex != i && swpValue != list.get(i)) {
              if (swpValue > list.get(i)) {
                int temp = list.get(i);
                list.set(i, swpValue);
                list.set(swpIndex, temp);
                break;
            }
        }

        int res = 0;
        for (Integer item : list) {
            res = res * 10 + item;
        }

        return res;
    }
}
