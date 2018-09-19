package com.zoran.leetcode.medium2;

import java.util.Stack;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ��ǰ��������������й��������
 * https://leetcode-cn.com/submissions/detail/7295939/
 * 
 * [Solution]
 * http://www.cnblogs.com/xiagnming/archive/2018/09/07/9603925.html
 * 
 * ǰ�������DLR�����Ƕ�����������һ�֣�Ҳ�����ȸ����������������ǰ�����Σ��ɼ��������ҡ�ǰ��������ȷ��ʸ����Ȼ���������������������������(���ǹ������!!!!)
 * ���������LDR���Ƕ�����������һ�֣�Ҳ�����и��������������Ρ��ڶ������У�����������ȱ�����������Ȼ����ʸ���㣬�������������� (�������)
 */
public class Test59 {

	/**
	 * ֻͨ��ǰ����������γ����յ���
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //����ǰ���γɶ�����
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
 *  �������Ϊ: �ȱ�����,�ڱ���������, ������������  3,(9,6),(20,15,7)
 * �������Ϊ: �ȱ���������,�ڱ�����,������������, (6,9),3,(15,20,7)  
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
		//����ջ�ķ�ʽ���е�
		Stack<Integer> stack = new Stack<>();
		for (int i=preorder.length-1; i>=0; i--) {
			stack.push(preorder[i]);
		}
		return helper(stack, inorder, 0, inorder.length-1);
	}

	/**
	 * @param lo ��ʾ��inorder�����λ
	 * @param high ��ʾ��inorder�����λ
	 * ����case: pop������9ʱ, 
	 * (stack,inorder, 0,-1) ��Ч
	 * (stack, inorder,1, 0) ��Ч
	 */
	private TreeNode helper(Stack<Integer> stack, int[] inorder, int lo, int high) {
		if (lo <0 || high>=inorder.length || stack.size()==0 || lo>high) return null;
		
		int index = lo;
		int pop = stack.pop();
		for (int i=lo; i<=high; i++) {
			if(inorder[i] == pop) {
				index = i;  //Core. �ҵ������������λ��
				break;
			}
		}
		// �ȸ�,������������,������������ , ��һ��ǰ���������
		TreeNode top = new TreeNode(pop);
		top.left = helper(stack, inorder, lo, index-1);
		top.right = helper(stack, inorder, index+1, high);
		return top;
	}
}




















