package com.zoran.leetcode;

/**
 * ����������ת��Ϊ����������
 * https://leetcode-cn.com/submissions/detail/2746336/
 * 
 * [Solution]
 * https://blog.csdn.net/u012249528/article/details/47144107
 */
public class Test23 {
	//	������������: [-10,-3,0,5,9],
	//
	//	һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
	//
	//	      0
	//	     / \
	//	   -3   9
	//	   /   /
	//	 -10  5

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null && nums.length == 0) return null;

		int middle = nums.length/2; 
		int left = 0; int right = middle;
		TreeNode root = new TreeNode(nums[middle]);
		TreeNode nextNode = root;
		while(right > 0) {
			TreeNode tmp = new TreeNode(nums[middle/2]);
			nextNode.left = tmp;
			nextNode = tmp;
			right = middle/2;
		}
		
		return root;
	}

	public  TreeNode Nice_sortedArrayToBST(int[] nums) {  
		int end=nums.length;  
		if(end<=0)  
			return null;  
		return buildTree(nums, 0, end-1);//��Ϊ��0��ʼ���� ���Լ�һ  
	}  

	//	      0
	//	     / \
	//	   -10   5
	//	     \   \
 	//	      -3   9  //�ݹ�ȡ�м��� ��Ϊ�м�ֵ
	public TreeNode buildTree(int[] nums,int start,int end)  
	{  
		if(start<=end)   //core
		{  
			int mid=(start+end)/2;  
			TreeNode root=new TreeNode(nums[mid]);  
			root.left=buildTree(nums, start, mid-1);  
			root.right=buildTree(nums, mid+1, end);  
			return root;  
		}  
		else {  
			return null;  
		}  

	} 

	//     Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; 
		}
	}
}
