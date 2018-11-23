package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有序矩阵中第K小的元素
 * https://leetcode-cn.com/submissions/detail/9676411/
 */
public class Test149 {

    public int kthSmallest(int[][] matrix, int k) {
        //用List排序，求k元素
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                list.add(matrix[i][j]);
            }
        }

        Collections.sort(list);
        return k <= list.size() ? list.get(k-1) : -1;
    }
}
