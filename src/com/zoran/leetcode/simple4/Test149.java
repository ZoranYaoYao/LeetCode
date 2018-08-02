package com.zoran.leetcode.simple4;

import java.util.Set;
import java.util.TreeSet;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉树中第二小的节点
 * https://leetcode-cn.com/submissions/detail/4979783/
 */
public class Test149 {
	
	/**
	 * OT 
	 */
    public int findSecondMinimumValue(TreeNode root) {
    	TreeSet<Integer> set = new TreeSet<>();
        iteratorTree(set,root);
        int result = -1;
        if(set.size() > 1) {
        	set.pollFirst();
            result = set.pollFirst();
        }
        return result;
    }
    
    public void iteratorTree(Set<Integer> set, TreeNode root) {
        if(root == null) return;
        
        set.add(root.val);
        iteratorTree(set,root.left);
        iteratorTree(set,root.right);
    }
}
