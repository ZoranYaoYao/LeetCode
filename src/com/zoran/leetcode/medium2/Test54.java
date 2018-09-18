package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 不同的二叉搜索树 II
 * https://leetcode-cn.com/submissions/detail/7238087/
 * 
 * [Solution]
 * https://blog.csdn.net/cumt_cx/article/details/47866747
 * 
 * 动态规划
 */
public class Test54 {

}

class Nice_Test54 {
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res  = new ArrayList<>();
        if(n<=0) return res;
        return createTree(1, n);
	}

	private List<TreeNode> createTree(int start, int end) {
		List<TreeNode> res = new ArrayList<>();
		if (start>end) {
			res.add(null);
			return res;
		}
		
		for (int i=start; i<=end; i++) {
			List<TreeNode> left = createTree(start, i-1);
			List<TreeNode> right = createTree(i+1, end);
			for (int j=0; j<left.size(); j++) {
				for (int k=0; k<right.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(j);  //Core. 组合功能
					root.right = right.get(k); //组合功能
					res.add(root);
				}
			}
		}
		return res;
	}
}