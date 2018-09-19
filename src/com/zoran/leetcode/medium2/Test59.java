package com.zoran.leetcode.medium2;

import java.util.Stack;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/submissions/detail/7295939/
 * 
 * [Solution]
 * http://www.cnblogs.com/xiagnming/archive/2018/09/07/9603925.html
 * 
 * 前序遍历（DLR），是二叉树遍历的一种，也叫做先根遍历、先序遍历、前序周游，可记做根左右。前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。(不是广度优先!!!!)
 * 中序遍历（LDR）是二叉树遍历的一种，也叫做中根遍历、中序周游。在二叉树中，中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。 (深度优先)
 */
public class Test59 {

	/**
	 * 只通过前序遍历不能形成最终的数
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //根据前序形成二叉树
        if(preorder == null) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1; i<preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            insertTree(root, node);
        }
        
        return root;
    }
    
    public void insertTree(TreeNode root, TreeNode node) {
        if(root == null) return;
        
        if(root.val > node.val && root.left == null) root.left = node;
        if(root.val < node.val && root.right == null) root.right = node;
        
        if(root.val > node.val && root.left != null) {
            insertTree(root.left, node);
        } else if (root.val < node.val && root.right != null) {
            insertTree(root.right, node);
        }
    }
}

/**
 *      3
 *    9  20 
 *  6   15 7
 *  先序遍历为: 先遍历根,在遍历左子树, 最后遍历右子树  3,(9,6),(20,15,7)
 * 中序遍历为: 先遍历左子树,在遍历根,最后遍历右子树, (6,9),3,(15,20,7)  
 */
class LeetCode_Test59 {
	
	public static void main(String[] args) {
		LeetCode_Test59 test59 = new LeetCode_Test59();
		int[] preorder = {3,9,6,20,15,7};
		int[] inorder = {6,9,3,15,20,7};
		TreeNode res = test59.buildTree(preorder, inorder);
		res.toString();
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		//换成栈的方式进行弹
		Stack<Integer> stack = new Stack<>();
		for (int i=preorder.length-1; i>=0; i--) {
			stack.push(preorder[i]);
		}
		return helper(stack, inorder, 0, inorder.length-1);
	}

	/**
	 * @param lo 表示在inorder的最低位
	 * @param high 表示在inorder的最高位
	 * 特殊case: pop弹出是9时, 
	 * (stack,inorder, 0,-1) 无效
	 * (stack, inorder,1, 0) 无效
	 */
	private TreeNode helper(Stack<Integer> stack, int[] inorder, int lo, int high) {
		if (lo <0 || high>=inorder.length || stack.size()==0 || lo>high) return null;
		
		int index = lo;
		int pop = stack.pop();
		for (int i=lo; i<=high; i++) {
			if(inorder[i] == pop) {
				index = i;  //Core. 找到在中序遍历的位置
				break;
			}
		}
		// 先根,再左子树遍历,再右子树遍历 , 是一个前序遍历过程
		TreeNode top = new TreeNode(pop);
		top.left = helper(stack, inorder, lo, index-1);
		top.right = helper(stack, inorder, index+1, high);
		return top;
	}
}




















