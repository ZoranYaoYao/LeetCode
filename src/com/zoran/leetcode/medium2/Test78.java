package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zoran.leetcode.util.TreeNode;

/**
 * ��������ǰ�����
 * https://leetcode-cn.com/submissions/detail/7666932/
 */
public class Test78 {

    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        //ǰ�����, �ȷ��ʸ�, �ٷ�����������
        res = new ArrayList<>();
        if (root == null) return res;
        
        iterator(root);
        return res;
    }
    
    public void iterator(TreeNode root) {
        if(root == null) return;
        
        res.add(root.val);
        
        iterator(root.left);
        iterator(root.right);
    }
}

class LeetCode_Test78 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode help ;
		stack.push(root);
		
		while (!stack.isEmpty()) {
			help = stack.pop();
			res.add(help.val);
			if (help.right != null) stack.push(help.right);
			if (help.left != null) stack.push(help.left);  //Core. �Ȱ�������ѹ��ջ��, �ȴ����������ĵ�
		}
		return res;
	}
}
