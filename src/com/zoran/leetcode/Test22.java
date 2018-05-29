package com.zoran.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * �������Ĳ�α��� II 
 * https://leetcode-cn.com/submissions/detail/2711416/
 *
 * [Solution]
 * https://www.cnblogs.com/theskulls/p/5126456.html
 */
public class Test22 {

	public static void main(String[] args) {
//		    3
//		   / \
//		  9  20
//		    /  \
//		   15   7
		
//		[
//		  [15,7],
//		  [9,20],
//		  [3]
//		]
	}
	
	
	//>3�� �༶Ŀ¼
	// ����:��֪��ÿ��ڵ�ı��� ��β���
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> list0 = new ArrayList<>();
        list0.add(root.val);
        
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(getCurrentLevelNode(root.left, root.right));
        
        List<Integer> list2 = new ArrayList<>();
        if(root.left != null) {
        	list2.addAll(getCurrentLevelNode(root.left.left, root.left.right));
        }
        if(root.right != null) {
        	list2.addAll(getCurrentLevelNode(root.right.left,root.right.right));
        }
        
        List<List<Integer>> total = new ArrayList<>();
        if (list2.size() > 0) total.add(list2);
        if(list1.size() > 0)  total.add(list1);
        total.add(list0);
        return total;
    }
    

	private List<Integer> getCurrentLevelNode(TreeNode... nodes) {
		List<Integer> list = new ArrayList<>();
		for(TreeNode node: nodes) {
			if(node!=null) list.add(node.val);
		}
		return list;
	}

	//ͨ��ͬһ�㼶���뵽һ��������, ��������Ԫ��, ������ͬ������!!
	//ͨ��poll ����Ԫ�ص���ʽ, ���ö���
	public List<List<Integer>> Nice_levelOrderBottom(TreeNode root){
		List<List<Integer>> tree = new ArrayList<>();
		if (root == null) {
			return tree;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<>();
			int size = queue.size();  //core : ͬһ�㼶��node ����һ��������
			for(int i =0; i< size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			tree.add(0, list); //core : �����б���ͷ
		}
		
		return tree;
	}
	
	//     Definition for a binary tree node.
      public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
