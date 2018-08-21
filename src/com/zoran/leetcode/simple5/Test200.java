package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * Ò¶×ÓÏàËÆµÄÊ÷
 * https://leetcode-cn.com/submissions/detail/5839414/
 */
public class Test200 {
	
	public static void main(String[] args) {
		Test200 test200 = new Test200();
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		test200.leafSimilar(root, root2);
	}
	
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        
        iteratorTree(list1, root1);
        iteratorTree(list2, root2);
        for(int i=0; i<list1.size(); i++) {
            if(list1.get(i).val != list2.get(i).val) return false;
        }
        
        return true;
    }
    
    public void iteratorTree(List list, TreeNode root) {
        if(root == null) return;
        
        iteratorTree(list, root.left);
        iteratorTree(list, root.right);
        
        if(root.left == null && root.right == null) list.add(root);
    }
}
