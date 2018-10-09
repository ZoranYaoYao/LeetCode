package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉搜索树迭代器
 * https://leetcode-cn.com/submissions/detail/8011464/
 * 
 * 二叉搜索树的迭代器: 每次都删除最小的一个, 并且把最小节点的右子树给上一节点
 * LeetCode
 */
public class Test88 {

    //转换成列表
    List<Integer> list = new ArrayList<>();
    int curIndex;
//    public BSTIterator(TreeNode root) {
//        dsf(root);
//    }
    
    public void dsf(TreeNode root) {
        if(root == null) return;
        dsf(root.left);
        list.add(root.val);
        dsf(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curIndex < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(curIndex++);
    }
}


class LeetCode_Test88 {
	private TreeNode root;
//	public BSTIterator(TreeNode root) {
//		this.root = root;
//	}
	
	public boolean hasNext() {
		// 返回一个就删除一个，当root不为空时说明还有元素
		return root != null;
	}
	
	public int next() {
		TreeNode cur = root;
		TreeNode pre = root;
		while (cur.left != null) {
			pre = cur;
			cur = cur.left;
		}
		int ret = cur.val;
		if (root.left != null) {
			pre.left = cur.right; //Core. 删除最小值,把最小值的右子树给上一层节点.
		} else {
			root = root.right;
		}
		
		return ret;
	}
}





















