package com.zoran.leetcode.medium5;

import com.zoran.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输出二叉树
 * https://leetcode-cn.com/submissions/detail/12245288/
 *
 * [Solution]
 * https://www.cnblogs.com/lightwindy/p/9859912.html
 *
 * 2的倍数来保证填充值在正中间！
 */
public class Test250 {


}

class Nice_Test250 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new LinkedList<>();
        int heigth = root == null ? 1 : getHeigth(root);
        //Core columns 2的倍数来保证填充值在正中间！
        int rows = heigth, columns = (int) (Math.pow(2, heigth) -1);
        List<String> row = new ArrayList<>();
        for (int i=0; i<columns; i++) row.add("");
        for (int i=0; i<rows; i++) res.add(new ArrayList<>(row));
        populateRes(root, res, 0, rows, 0, columns-1);
        return res;
    }

    /**
     * Nice_Core . dfs 遍历填充！
     */
    public void populateRes(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null) return;
        res.get(row).set((i+j)/2, Integer.toString(root.val));
        populateRes(root.left, res,row+1, totalRows, i,(i+j)/2-1);
        populateRes(root.right, res, row+1, totalRows, (i+j)/2+1, j);
    }

    private int getHeigth(TreeNode root) {
        if (root == null) return 0;
        //Core 得到树的高度
        return 1+ Math.max(getHeigth(root.left), getHeigth(root.right));

    }
}