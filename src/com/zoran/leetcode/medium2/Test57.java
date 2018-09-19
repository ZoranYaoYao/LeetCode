package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉树的层次遍历
 * https://leetcode-cn.com/submissions/detail/7288204/
 * 
 * [Solution]
 * https://blog.csdn.net/u010853261/article/details/54946193
 * 
 * 广度优先搜索 : 1个队列保存每层的的节点
 */
public class Test57 {

}

class Nice_Test57 {
	public List<List<Integer>> leverOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;

		queue.offer(root);
		while (!queue.isEmpty()) {
			int leverNum = queue.size(); //获取当前层的节点数
			List<Integer> subList = new ArrayList<>();

			//遍历当前层节点
			for (int i=0; i<leverNum; i++) {
				//队首出队并将val将入子list
				TreeNode node = queue.poll();
				subList.add(node.val);

				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			res.add(subList);
		}

		return res;
	}
}


