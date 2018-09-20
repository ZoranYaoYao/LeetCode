package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ·���ܺ� II
 * https://leetcode-cn.com/submissions/detail/7337764/
 * 
 * LeetCode
 */
public class Test62 {
	/**
	 * ����: ����ʱ, listÿ��·����δ���?
	 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //������,�ڵ���� �Ա�target
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        iteratorTree(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    
    public void iteratorTree(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if(root == null) return;
        
        list.add(root.val);
        if(root.left != null) iteratorTree(res, list, root, sum-root.val);
        if(root.right != null) iteratorTree(res, list, root, sum-root.val);
        
        if(root.left == null && root.right == null && sum==0) {
            res.add(new ArrayList<Integer>(list));
        } else {
            list.remove(list.size()-1);
        }
    }
}

/**
 * ��: �ڽ���������, ���������������֮��, �淽�����л���,����
 * 
 * ���ݷ�!!
 */
class Nice_Test63 {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) return res;
		dfs(root, new ArrayList<Integer>(), sum);
		return res;
	}
	private void dfs(TreeNode root, ArrayList<Integer> list, int sum) {
		list.add(root.val);
		sum -= root.val;
		if (root.left==null && root.right==null && sum==0) {
			res.add(new ArrayList<>(list));
		}
		
		if (root.left != null) dfs(root.left, list, sum);
		if (root.right != null) dfs(root.right, list, sum);
		list.remove(list.size()-1); //Nice_Core. �ýڵ�����֮��,���л���!
	}
}






















