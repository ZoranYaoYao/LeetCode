package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/submissions/detail/4879838/
 */
public class Test144 {
	

    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        iteratorTree(root);
        if(list.size() <= 1) return false;
        
        int max = list.get(list.size() -1) + list.get(list.size() -2);
        if(k > max) return false;
        
        for(Integer item : list) {
            if(list.contains((Integer)k-item) && k-item != item ) return true; //重复元素相加 1+1 =2 //前提保证元素不能有重复!
        }
        return false;
    }
    
    //按值大小进行遍历
    public void iteratorTree(TreeNode root) {
        if(root == null) return;
        
        if(root.left != null) iteratorTree(root.left);
        list.add(root.val);
        if(root.right != null) iteratorTree(root.right);
    }
    
    public boolean Nice_findTarget(TreeNode root, int k) {
        iteratorTree(root);
        if(list.size() <= 1) return false;
        
        int max = list.get(list.size() -1) + list.get(list.size() -2);
        if(k > max) return false;
        
        for(int i=0,j=list.size()-1; i<j; ) {  //夹逼准则
        	if(list.get(i) + list.get(j) == k) {
        		return true;
        	} else if (list.get(i) + list.get(j) < k) {
        		i++;
        	} else {
        		j--;
        	}
        }
        
        return false;
    }
}
