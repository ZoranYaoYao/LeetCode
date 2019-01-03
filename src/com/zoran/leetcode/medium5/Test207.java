package com.zoran.leetcode.medium5;

import com.zoran.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在每个树行中找最大值
 * https://leetcode-cn.com/submissions/detail/11163244/
 *
 * dfs遍历所有值，并进行层次替换
 */
public class Test207 {

    public List<Integer> largestValues(TreeNode root) {
        //dfs遍历所有值，更改每层的最大值
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);
        dfs(root, res, 1);

        return res;
    }

    public void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;

        if(res.size() >= depth) {
            res.set(depth-1, Math.max(res.get(depth-1), root.val));
        } else {
            res.add(depth-1, root.val);
        }
        dfs(root.left, res, depth+1);
        dfs(root.right, res, depth+1);
    }
}
