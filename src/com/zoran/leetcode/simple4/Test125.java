package com.zoran.leetcode.simple4;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉树的坡度
 * https://leetcode-cn.com/submissions/detail/4402818/
 */
public class Test125 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode item1 = new TreeNode(2); root.left = item1;
		TreeNode item2 = new TreeNode(3); root.right = item2;
		
		TreeNode item3 = new TreeNode(4); item1.left = item3;
		TreeNode item4 = new TreeNode(5); item2.left = item4;
		Test125 test125 = new Test125();
		System.out.println(test125.findTilt(root));
	}

	/**
	 * 双递归操作: 显得太麻烦 
	 */
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        int itemLeft = findTilt(root.left,true);
        int itemRight = findTilt(root.right,false);
        result += Math.abs(itemLeft - itemRight);
        result += findTilt(root.left);
        result += findTilt(root.right);
        return result;
    }
    
    public int findTilt(TreeNode root, boolean isLeft) {
        if(root == null) return 0;
        int result = root.val;
        result += findTilt(root.left, isLeft);
        result += findTilt(root.right, isLeft);
        return result;
    }

    int tilt = 0;
    public int Nice_findTilt(TreeNode root) {
    	sum(root);
    	return tilt;
    }

	private int sum(TreeNode root) {
		if (root == null) return 0;
		
		int sumLeft = sum(root.left);
		int sumRight = sum(root.right);
		tilt += Math.abs(sumLeft - sumRight);
		
		return sumLeft + sumRight + root.val; //Nice操作: 针对每一层的返回值
		
	}
    
}
