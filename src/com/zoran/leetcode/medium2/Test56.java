package com.zoran.leetcode.medium2;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;
import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ��֤����������
 * https://leetcode-cn.com/submissions/detail/7244904/
 * 
 * [Solution]
 * https://www.cnblogs.com/grandyang/p/4298435.html
 *
 * �����жϷ���ĺýⷨ
 */
public class Test56 {
	
	/**
	 * �㷨���� 
	 */
    public boolean isValidBST(TreeNode root) {
        //�������, ��֤���������� ����С�Ĺ�ϵ
        // �����������ϸ��Ĺ�ϵ...
        if(root == null) return true;
        
        if(root.left != null && root.left.val >= root.val) return false;
        if(root.right != null && root.right.val <= root.val) return false;
        return isValidBST0(root.left, 1, root.val) && isValidBST0(root.right, 2, root.val); 
    }
    
    public boolean isValidBST0(TreeNode root, int oritation, int value) {
        if(root == null) return true;
        
        if (oritation == 1) {
            if(root.left != null  && (root.val <= root.left.val || root.left.val >= value)) return false;
            if(root.right != null && root.right.val>=value) return false;
        } else if (oritation == 2) {
            if(root.right != null && (root.val >= root.right.val || root.right.val <= value)) return false;
            if(root.left != null && root.left.val<=value) return false;
        } 
        
        return isValidBST0(root.left, 1, value) && isValidBST0(root.right, 2, value);
    }
}

class Nice_Test56 {
	
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public boolean valid(TreeNode root, long low, long high) {
		if (root == null) return true;
		if (root.val <= low || root.val >= high) return false;
		return valid(root.left,low, root.val) && valid(root.right, root.val, high); //�ڸ��ڵ�����Ҳ���, ������һ���ڵ��ֵ, ����ͨ��hight = root.val, �����Ƹýڵ�С�ڸ��ڵ��ֵ!!
	}
}


