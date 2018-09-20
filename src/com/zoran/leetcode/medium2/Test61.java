package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.ListNode;
import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 有序链表转换二叉搜索树
 * https://leetcode-cn.com/submissions/detail/7335521/
 * 
 * 处理好生产节点的边界问题 start end索引
 */
public class Test61 {
	
	public static void main(String[] args) {
		Test61 test61 =new Test61();
		//[-10,-3,0,5,9]
		ListNode root = new ListNode(-10);
		ListNode node1 = new ListNode(-3); root.next = node1;
		ListNode node2= new ListNode(0);  node1.next = node2;
		ListNode node3 = new ListNode(5); node2.next = node3;
		ListNode node4 = new ListNode(9); node3.next = node4;
		
		TreeNode res = test61.sortedListToBST(root);
		System.out.println(res);
	}

    public TreeNode sortedListToBST(ListNode head) {
        //递归, 都是从中间生成根节点
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            int temp = head.val;
            list.add(temp);
            head = head.next;
        }
        return createNode(list, 0, list.size()-1);
    }
    
    public TreeNode createNode (List<Integer> list, int start, int end) {
        if(start > end) return null; 
        int index = (start + end) /2;
        TreeNode root = new TreeNode(list.get(index));
        root.left = createNode(list, start, index-1); //Core. 从start开始索引
        root.right = createNode(list, index+1, end); //Core. 在右子树会改变开始的索引位置
        
        return root;
    }
}
