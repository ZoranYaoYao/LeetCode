package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉树的锯齿形层次遍历
 * https://leetcode-cn.com/submissions/detail/7290599/
 */
public class Test58 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		//广度优先遍历的变种, 添加一个队列遍历的方向
		//左-> 右, 取队首, 下一个队列
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean fromLeftToRight = true;
		while(!queue.isEmpty()) {
			int levelCount = queue.size();
			List<Integer> subList = new ArrayList<>();
			for (int i=0; i<levelCount; i++) {
				TreeNode node = queue.poll();
				subList.add(node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);

			}
			if(!fromLeftToRight) Collections.reverse(subList);
			res.add(subList); //Core. 对subList进行去反
			fromLeftToRight = !fromLeftToRight;
		}
		return res;
	}
}
