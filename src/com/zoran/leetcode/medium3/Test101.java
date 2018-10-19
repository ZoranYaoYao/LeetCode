package com.zoran.leetcode.medium3;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 完全二叉树的节点个数
 * https://leetcode-cn.com/submissions/detail/8439374/
 * 
 * [Solution]
 * https://blog.csdn.net/qz530308783/article/details/52155867
 * 根据完全二叉树性质, 进行求解
 */
public class Test101 {

	//超时
    int res;
    public int countNodes(TreeNode root) {
        //深度优先遍历
        if (root == null) return 0;
        
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        
        dfs(root.left);
        res++;
        dfs(root.right);
    }
}


class Nice_Test101 {
	
	//动态规划
	int countNodes(TreeNode root) {
		if (root == null) return 0;
		int lHeight = getHeight1(root.left);
		int rHeight = getHeight2(root.right);
		if (lHeight == rHeight) 
			return (int) (Math.pow(2, 1+lHeight) -1);
		else 
			return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	int getHeight1(TreeNode root) {
		if (root == null) return 0;
		int n=1;
		while (root.left != null) {
			n++;
			root = root.left;
		}
		return n;
	}
	
	int getHeight2(TreeNode root) {
		if (root == null) return 0;
		int n=1;
		while (root.right != null) {
			n++;
			root =root.right;
		}
		return n;
	}
}