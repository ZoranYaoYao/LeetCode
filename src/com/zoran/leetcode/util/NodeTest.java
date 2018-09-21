package com.zoran.leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zoran.leetcode.Test17.ListNode;
import com.zoran.leetcode.medium.Test46;
import com.zoran.leetcode.simple3.Test90.TreeNode;

public class NodeTest {

	public static void main(String[] args) {
		/**字符转 列表*/
		List<Character> list1 = new ArrayList<Character>( Arrays.asList('q','w','e','r','t','y','u','i','o','p'));

		/**数组快速转换成字符串格式*/
		String[] items = {"Hello","Alaska","Dad","Peace"};
		System.out.println(Arrays.toString(items));
	}

	public void nodeObject() {
		//[10,5,-3,3,2,null,11,3,-2,null,1]
		TreeNode root = new TreeNode(10);
		TreeNode item1 = new TreeNode(5); root.left = item1;
		TreeNode item2 = new TreeNode(-3); root.right = item2;

		TreeNode item3 = new TreeNode(3); item1.left = item3;
		TreeNode item4 = new TreeNode(2); item1.right = item4;

		TreeNode item5 = new TreeNode(11); item2.right = item5;

		TreeNode item6 = new TreeNode(3); item3.left = item6;
		TreeNode item7 = new TreeNode(-2); item3.right = item7;

		TreeNode item8 = new TreeNode(1); item4.right = item8;
		//		System.out.println(pathSum(root, 8));
	}
	
	public void ListNodeObject() {
		ListNode root = new ListNode(1);
		ListNode node1 = new ListNode(1); root.next = node1;
		ListNode node2= new ListNode(3);  node1.next = node2;
		ListNode node3 = new ListNode(3); node2.next = node3;
		ListNode node4 = new ListNode(4); node3.next = node4;
		ListNode node5 = new ListNode(4); node4.next = node5;
		ListNode node6 = new ListNode(5); node5.next = node6;

		Test46 test46 = new Test46();
		test46.deleteDuplicates(root);
	}

	//     Definition for a binary tree node.
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) { val = x; }
	}

	// Definition for a Node.
	public static class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
	}

	//	 * Definition for an interval.
	public static class Interval {
		public int start;
		public int end;
		Interval() { start = 0; end = 0; }
		public Interval(int s, int e) { start = s; end = e; }
	}
	
//	  Definition for binary tree with next pointer.
	  public static class TreeLinkNode {
		  public int val;
		  public TreeLinkNode left, right, next;
		  public TreeLinkNode(int x) { val = x; }
	  }
}
