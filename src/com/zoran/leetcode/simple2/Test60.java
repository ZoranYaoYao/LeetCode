package com.zoran.leetcode.simple2;

import java.util.ArrayList;
import java.util.List;

/**
 * ������������·��
 * https://leetcode-cn.com/submissions/detail/3366418/
 */
public class Test60 {
	public static void main(String[] args) {
		//[1,2,3,null,5]
				TreeNode root = new TreeNode(1);
				TreeNode item1 = new TreeNode(2);
				TreeNode item2 = new TreeNode(3);
				TreeNode item3 = new TreeNode(5); 
				
				root.left = item1; root.right = item2;
				item1.right = item3;
		//
		//		TreeNode item4 = new TreeNode(13); item2.left = item4;
		//		TreeNode item5 = new TreeNode(4); item2.right = item5;
		//
		//		TreeNode item6 = new TreeNode(7); item3.left = item6;
		//		TreeNode item7 = new TreeNode(2); item3.right = item7;
		//
		//		TreeNode item8 = new TreeNode(1); item5.right = item8;
		//		root.left = item1; root.right = item2;

		System.out.println(binaryTreePaths(root));
	}

	/**
	 * ÿ���ڵ㷵�ص����ݶ�����List<String> 1��Ϊ2,2��Ϊ4,4��Ϊ8..
	 * �ݹ� ���� �Ƕ������ı�����ʽ 
	 * [clever]
	 */
	public static List<String> binaryTreePaths(TreeNode root) {
		if(root == null) return null;
		List<String> list = new ArrayList<>();

		if(root.left !=null) {
			List tmplist = binaryTreePaths(root.left);
			for(int i = 0; i < tmplist.size(); i++) {
				list.add(root.val + "->" + tmplist.get(i));
			}
		} 

		if(root.right != null) {
			List tmplist = binaryTreePaths(root.right);
			for(int i = 0; i < tmplist.size(); i++) {
				list.add(root.val + "->" + tmplist.get(i));
			}
		}

		if(root.left == null && root.right == null) {
			list.add(""+root.val);
		}

		return list;
	}




	//     Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
