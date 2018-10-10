package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ������������ͼ
 * https://leetcode-cn.com/submissions/detail/8061266/
 * 
 * LeetCode ��һ�ֽⷨ
 */
public class Test91 {

    public List<Integer> rightSideView(TreeNode root) {
        //�㼶����, ���ÿһ������һ��Ԫ��
    	// LinkedHashMap + �ݹ�㼶����
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        int level = 1;
        LinkedHashMap<Integer, TreeNode> map = new LinkedHashMap<>();
        stageTraversing(root, map, 1);
        for (TreeNode item: map.values()) {
            res.add(item.val);
        }
        return res;
    }
    
    public void stageTraversing(TreeNode root, LinkedHashMap<Integer, TreeNode> map, int level) {
        map.put(level, root);
        if(root.left != null) stageTraversing(root.left, map, level+1);
        if(root.right != null) stageTraversing(root.right, map, level+1);
    }
}

class LeetCode_Test91 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		if (root == null) return list;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int s= q.size(); 	
			for (int i=0; i<s; i++) {
				TreeNode node = q.poll();
				if (i == s-1) list.add(node.val);  // Core. ͨ�����ÿ���ڶ��������size,����i=s-1��¼���ұߵĽ��
				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
			}
		}
		
		return list;
	}
}



















