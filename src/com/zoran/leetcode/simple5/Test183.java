package com.zoran.leetcode.simple5;

/**
 * 806. 写字符串需要的行数
 * https://leetcode-cn.com/submissions/detail/5570971/
 */
public class Test183 {

    public int[] numberOfLines(int[] widths, String S) {
        //check 边界
        int row = 1; int pos = 0;
        for (char c: S.toCharArray()) {
            int len = widths[c-'a'];
            if(pos+len > 100) {
                row++;
                pos = len;
            } else {
                pos += len;
            }
        }
        
        int[] result = {row, pos};
        return result;
    }
}
