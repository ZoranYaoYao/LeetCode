package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/submissions/detail/4275146/
 */
public class Test116 {
	
	public static void main(String[] args) {
		//[10,5,-3,3,2,null,11,3,-2,null,1]
		TreeNode root = new TreeNode(1);
		TreeNode item2 = new TreeNode(2); root.right = item2;
//		TreeNode item3 = new TreeNode(2); item2.left = item3;
		
		System.err.println(getMinimumDifference(root));
	}

    static List<Integer> list;
    public static int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();
        iteratorTree(root);
        Collections.sort(list);
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= list.size() -1; i++) {
            int tmp = Math.abs(list.get(i) -list.get(i -1));
            min = min > tmp ? tmp : min;
        }
        
        return min;
        
    }
    
    public static void iteratorTree(TreeNode root) {
        if(root != null) {
            list.add(root.val);
        }
        
        if(root.left != null) {
            iteratorTree(root.left);
        }
        
        if(root.right != null) {
            iteratorTree(root.right);
        }
    }

    /**
     * 遍历树的同时,记录差值
     */
    int pre = -1; int minNum = Integer.MAX_VALUE;
    public int Nice_getMininumdifference(TreeNode root) {
    	if (root != null) {
			getMinimumDifference(root.left);
			if(pre != -1) {
				minNum = Math.min(minNum, Math.abs(root.val - pre));
			}
			pre = root.val;
			getMinimumDifference(root.right);
		}
		return minNum;
    	
    }
}
