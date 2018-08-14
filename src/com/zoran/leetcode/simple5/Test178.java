package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉搜索树结点最小距离
 * https://leetcode-cn.com/submissions/detail/5521443/
 */
public class Test178 {

    List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        if(root == null) return -1;
        
        iteratorTree(root);
        Collections.sort(list);
        if(list.size() == 2) return Math.abs(list.get(0) - list.get(1));
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i-1));
        }
        
        return min;
    }
    
    public void iteratorTree(TreeNode root) {
        if(root == null) return;
        
        list.add(root.val);
        iteratorTree(root.left);
        iteratorTree(root.right);
    }
}
