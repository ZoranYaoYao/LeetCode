package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * �����������е�����
 * https://leetcode-cn.com/submissions/detail/4115947/
 * 
 * ������Ŀ: û�б�ע������ͬ�����.
 */
public class Test110 {

	static Map<Integer,Integer> map =new HashMap<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2147483647);
		//		TreeNode item1 = new TreeNode(2); root.right = item1;
		//		TreeNode item2 = new TreeNode(2); item1.left = item2;

		int[] reuslt = findMode(root);
		System.out.println(Arrays.toString(reuslt));
	}

	/**
	 * ������ͬʱ,�����
	 */
	public static int[] findMode(TreeNode root) {
		if(root == null ) {return new int[0];}
		
		findMode0(root);

		if(map.size() == 0) {
			return null;
		}
		
		//˫�������¼��ֵ(index)�ͳ��ֵĴ���(result)
		int[] index = new int[map.size()];
		int[] result = new int[map.size()]; int i = 0;
		for (Map.Entry<Integer,Integer> item: map.entrySet()) {
			index[i] = item.getKey();
			result[i] = item.getValue();
			i++;
		}

		List<Integer> list = new ArrayList<>(); int maxIndex = 0;

		for(int j = 0; j < result.length; j++) {
			if(maxIndex < result[j]) {
				maxIndex = result[j];
			} 
		}
		
		//��ȡ���ֶԶ����������
		for(int k = 0; k < result.length; k++) {
			if(result[k] == maxIndex) {
				list.add(k);
			}
		}
		
		int[] arr = new int[list.size()];
		//��������
		for(int m = 0; m < list.size(); m++) {
			arr[m] = index[list.get(m)];
		}

		return arr;
	}

	public static void findMode0(TreeNode root) {
		if(root == null) {
			return;
		}

		if(map.get(root.val) != null) {
			map.put(root.val,map.get(root.val) +1);
		} else {
			map.put(root.val, 1);
		}

		findMode0(root.left);
		findMode0(root.right);
	}

	//     Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
