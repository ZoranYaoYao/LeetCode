package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉树展开为链表
 * https://leetcode-cn.com/submissions/detail/7340148/
 * 
 * [Solution]
 * https://blog.csdn.net/thousa_ho/article/details/77961918
 * 
 * 每层递归, 都有一个层次的概念., 在该层上的后续位置,可以做其他的操作.
 */
public class Test63 {

    TreeNode hero;
    public void flatten(TreeNode root) {
        //先把右子树形成单链,然后左子树往右子树插入
        if (root == null) return;
        
        hero = root;
        updateRightTree(root);
    }
    
    public void updateRightTree(TreeNode root) {
        if(root == null) return;
        if(root.left != null) insert(hero,root.left);
    }
    
    TreeNode preNode;
    public void insert(TreeNode root, TreeNode node) {
        if (node == null) return;
        
        if (root == null) {
            preNode.right = node; 
            return;
        }
        
        if(root.val <= node.val) {
            preNode = root;
            insert(root.right, node);
        }
        else {
            if(preNode == null) {
                node.right = root; root = node; 
            } else {
                preNode.right = node; 
            }
        }
    }
}

/**
 * 二叉树原地转换为链表, 没有要求节点值顺序
 */
class Nice_Test63 {
	public void flatten(TreeNode root) {
		if(root == null) return;
		
		/*使用DFS思路找到最左子节点*/
		if (root.left != null) flatten(root.left);
		if (root.right != null) flatten(root.right);
		
		/*把其父节点和右子节点断开, 将原左子结点连上父节点的右子节点上*/
		TreeNode tmp = root.right;
		root.right = root.left;
		root.left = null;
		/*然后再把原右子节点链接到新右子节点上*/
		while (root.right != null) {
			root = root.right;
		}
		root.right = tmp;
	}
}
