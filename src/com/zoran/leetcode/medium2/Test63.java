package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ������չ��Ϊ����
 * https://leetcode-cn.com/submissions/detail/7340148/
 * 
 * [Solution]
 * https://blog.csdn.net/thousa_ho/article/details/77961918
 * 
 * ÿ��ݹ�, ����һ����εĸ���., �ڸò��ϵĺ���λ��,�����������Ĳ���.
 */
public class Test63 {

    TreeNode hero;
    public void flatten(TreeNode root) {
        //�Ȱ��������γɵ���,Ȼ��������������������
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
 * ������ԭ��ת��Ϊ����, û��Ҫ��ڵ�ֵ˳��
 */
class Nice_Test63 {
	public void flatten(TreeNode root) {
		if(root == null) return;
		
		/*ʹ��DFS˼·�ҵ������ӽڵ�*/
		if (root.left != null) flatten(root.left);
		if (root.right != null) flatten(root.right);
		
		/*���丸�ڵ�����ӽڵ�Ͽ�, ��ԭ���ӽ�����ϸ��ڵ�����ӽڵ���*/
		TreeNode tmp = root.right;
		root.right = root.left;
		root.left = null;
		/*Ȼ���ٰ�ԭ���ӽڵ����ӵ������ӽڵ���*/
		while (root.right != null) {
			root = root.right;
		}
		root.right = tmp;
	}
}
