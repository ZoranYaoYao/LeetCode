package com.zoran.leetcode;

import java.util.Stack;


/**
 * ·���ܺ�
 * https://leetcode-cn.com/submissions/detail/2806036/
 * 
 * [Solution]
 * http://www.mamicode.com/info-detail-2274544.html
 */
public class Test26 {
	//	����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�
	//
	//	˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
	//
	//	ʾ��: 
	//	�������¶��������Լ�Ŀ��� sum = 22��
	//
	//	              5
	//	             / \
	//	            4   8
	//	           /   / \
	//	          11  13  4
	//	         /  \      \
	//	        7    2      1
	//	���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��


	public static void main(String[] args) {
		//[5,4,8,11,null,13,4,7,2,null,null,null,1]
		//		TreeNode root = new TreeNode(5);
		//		TreeNode item1 = new TreeNode(4);
		//		TreeNode item2 = new TreeNode(8);
		//		TreeNode item3 = new TreeNode(11); item1.left = item3;
		//
		//		TreeNode item4 = new TreeNode(13); item2.left = item4;
		//		TreeNode item5 = new TreeNode(4); item2.right = item5;
		//
		//		TreeNode item6 = new TreeNode(7); item3.left = item6;
		//		TreeNode item7 = new TreeNode(2); item3.right = item7;
		//
		//		TreeNode item8 = new TreeNode(1); item5.right = item8;
		//		root.left = item1; root.right = item2;

		TreeNode root = new TreeNode(-2);
		TreeNode item1 = new TreeNode(-3);root.right = item1;
		System.out.println(hasPathSum(root, -2));
	}

	/**
	 *  1.Error: ����ʱ������  
	 *  	[Solution] ������ѭ��
	 *  2. ��Ҫʹ��Stack ���ݽṹ, (1) �߳�ͬ�� (2) pop, peek Ϊ��ʱ, ��ֱ���׳��쳣
	 *  3. �ڵ��и��� -2 ,null, -3
	 */
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null && sum >= 0) return false;

		int tmp = 0; TreeNode iterator = root;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) { //�������
			iterator = stack.peek();
			tmp += iterator.val;

			if(sum < 0) {
				if(tmp == sum && iterator.left == null && iterator.right == null) return true;
			} else {
				if ( tmp >= sum ) {
					if(tmp == sum && iterator.left == null && iterator.right == null) return true;
					tmp -= iterator.val;
					stack.pop();
					if(!stack.isEmpty() && stack.peek().left == iterator) {
						stack.peek().left = null;
					} else if(!stack.isEmpty() && stack.peek().right == iterator) {
						stack.peek().right = null; //����,���Ƴ�������
					}

					if(!stack.isEmpty()) {
						tmp -= stack.peek().val;// �����ڵ�ֵ
						continue;
					} 

					continue;
				}
			}



			if(iterator.left != null) {
				iterator = iterator.left;
				stack.push(iterator);
				continue;
			}

			if(iterator.right != null) {
				iterator = iterator.right;
				stack.push(iterator);
				continue;
			}

			if(!stack.isEmpty() && (stack.peek().left == null|| stack.peek().right == null)) {
				stack.pop();  // ��ûִ�еĻ����Լ�����
			}

		}

		return false;
	}


	/**
	 * �������ĵݹ� : ���������ݹ�!!!!!!!!
	 */
	public boolean Nice_hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.val == sum && root.left == null && root.right == null) return true;
		return hasPathSum(root.right, sum-root.val) || hasPathSum(root.left, sum-root.val);
	}


	//     Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
