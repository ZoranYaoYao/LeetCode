package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * �������ľ���β�α���
 * https://leetcode-cn.com/submissions/detail/7290599/
 */
public class Test58 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		//������ȱ����ı���, ���һ�����б����ķ���
		//��-> ��, ȡ����, ��һ������
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
			res.add(subList); //Core. ��subList����ȥ��
			fromLeftToRight = !fromLeftToRight;
		}
		return res;
	}
}
