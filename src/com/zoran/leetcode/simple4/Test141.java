package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * �������Ĳ�ƽ��ֵ
 * https://leetcode-cn.com/submissions/detail/4827190/
 *
 * [Solution]
 * https://blog.csdn.net/obrcnh/article/details/77932937
 * 
 * �㼶���� �ж������ʱ, �õ���,���д洢���н���
 */
public class Test141 {
	
	public static void main(String[] args) {
		Test141 test141 = new Test141();
		TreeNode root = new TreeNode(10);
		TreeNode item1 = new TreeNode(5); root.left = item1;
		TreeNode item2 = new TreeNode(15); root.right = item2;
		
		TreeNode item3 = new TreeNode(6); item2.left = item3;
		TreeNode item4 = new TreeNode(20); item2.right = item4;
		
		System.out.println(test141.averageOfLevels(root));
	}
	
	public List<Double> averageOfLevels(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		List<Double> result = new ArrayList<>();
		
		queue.add(root);
		while (!queue.isEmpty()) {
			long sum = 0;
			int number = queue.size();
			for (int i = 0; i < number; i++) { //Core. ���ͬһ���ϵ�һ�����н��б���
				TreeNode temp = queue.poll();  //�Ƕ��е���ʽ,��poll()
				if(temp.left != null) queue.addLast(temp.left); //������
				if(temp.right != null) queue.addLast(temp.right);
				sum += temp.val;
			}
			result.add((double) sum / number);
		}
		
		return result;
	}
}
