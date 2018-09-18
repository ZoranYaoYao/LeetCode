package com.zoran.leetcode.medium2;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;
import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/submissions/detail/7244904/
 * 
 * [Solution]
 * https://www.cnblogs.com/grandyang/p/4298435.html
 *
 * 不用判断方向的好解法
 */
public class Test56 {
	
	/**
	 * 算法不对 
	 */
    public boolean isValidBST(TreeNode root) {
        //中序遍历, 验证左右子树跟 根大小的关系
        // 子树与上上上根的关系...
        if(root == null) return true;
        
        if(root.left != null && root.left.val >= root.val) return false;
        if(root.right != null && root.right.val <= root.val) return false;
        return isValidBST0(root.left, 1, root.val) && isValidBST0(root.right, 2, root.val); 
    }
    
    public boolean isValidBST0(TreeNode root, int oritation, int value) {
        if(root == null) return true;
        
        if (oritation == 1) {
            if(root.left != null  && (root.val <= root.left.val || root.left.val >= value)) return false;
            if(root.right != null && root.right.val>=value) return false;
        } else if (oritation == 2) {
            if(root.right != null && (root.val >= root.right.val || root.right.val <= value)) return false;
            if(root.left != null && root.left.val<=value) return false;
        } 
        
        return isValidBST0(root.left, 1, value) && isValidBST0(root.right, 2, value);
    }
}

class Nice_Test56 {
	
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public boolean valid(TreeNode root, long low, long high) {
		if (root == null) return true;
		if (root.val <= low || root.val >= high) return false;
		return valid(root.left,low, root.val) && valid(root.right, root.val, high); //在父节点的往右侧走, 依赖上一个节点的值, 所以通过hight = root.val, 开控制该节点小于父节点的值!!
	}
}


