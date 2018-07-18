package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 把二叉搜索树转换为累加树 
 * https://leetcode-cn.com/submissions/detail/4313934/
 * 
 * Nice_Solution
 * LeetCode
 */
public class Test118 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode item1 = new TreeNode(2); root.left = item1;
		TreeNode item2 = new TreeNode(13); root.right = item2;
		Test118 test118 = new Test118();
		test118.convertBST(root);
		
	}

    List<Integer> list = new ArrayList<>();
    
    public TreeNode convertBST(TreeNode root) {
        iteratorTree(root);
        Collections.sort(list);
        convertBST0(root);
        
        return root;
    }
    
    public void convertBST0 (TreeNode root) {
        if(root == null) return;
        
        int value = root.val;
        for(int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i) > value) {
                root.val += list.get(i);
            } else {
                break;
            }
        }
        
        convertBST0(root.left);
        convertBST0(root.right);
    }
    
    public void iteratorTree(TreeNode root) {
        if(root == null) return;
        
        list.add(root.val);
        iteratorTree(root.left);
        iteratorTree(root.right);
    }
    
    /**
     * 二叉搜索树 本来的特点 右子树 > 当前节点 > 左子树
     * 递归: 递归到最深层在一层一层回调.
     */
    private int rightSum = 0;
    public TreeNode Nice_converBST(TreeNode root) {
    	if (null == root) {
    		return null;
    	}
    	
    	Nice_converBST(root.right);  //Core. 先遍历右侧树, 可以得到所有大于该节点的值.
    	root.val = root.val + rightSum;
    	rightSum = root.val;
    	Nice_converBST(root.left);
    	
    	return root;
    }
}
