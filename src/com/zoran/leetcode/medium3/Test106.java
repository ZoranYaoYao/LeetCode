package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * �����������е�KС��Ԫ��
 * https://leetcode-cn.com/submissions/detail/8569086/
 * 
 * LeetCode �۰����
 */
public class Test106 {

    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        //DFS�����������, ���з���
        
        dfs(root);
        return list.get(k-1);
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}

class LeetCode_Test106 {
	public int kthSmallest(TreeNode root, int k) {
		int num = count(root.left);
		if (num == k-1) {
			return root.val;
		} else if (num > k-1) {
			return kthSmallest(root.left, k);
		} else {
			return kthSmallest(root.right, k-num-1);
		}
	}

	private int count(TreeNode node) {
		if(node == null) return 0;
		return 1 + count(node.left) +count(node.right);
	}
}