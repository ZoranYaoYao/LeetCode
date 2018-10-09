package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ����������������
 * https://leetcode-cn.com/submissions/detail/8011464/
 * 
 * �����������ĵ�����: ÿ�ζ�ɾ����С��һ��, ���Ұ���С�ڵ������������һ�ڵ�
 * LeetCode
 */
public class Test88 {

    //ת�����б�
    List<Integer> list = new ArrayList<>();
    int curIndex;
//    public BSTIterator(TreeNode root) {
//        dsf(root);
//    }
    
    public void dsf(TreeNode root) {
        if(root == null) return;
        dsf(root.left);
        list.add(root.val);
        dsf(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curIndex < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(curIndex++);
    }
}


class LeetCode_Test88 {
	private TreeNode root;
//	public BSTIterator(TreeNode root) {
//		this.root = root;
//	}
	
	public boolean hasNext() {
		// ����һ����ɾ��һ������root��Ϊ��ʱ˵������Ԫ��
		return root != null;
	}
	
	public int next() {
		TreeNode cur = root;
		TreeNode pre = root;
		while (cur.left != null) {
			pre = cur;
			cur = cur.left;
		}
		int ret = cur.val;
		if (root.left != null) {
			pre.left = cur.right; //Core. ɾ����Сֵ,����Сֵ������������һ��ڵ�.
		} else {
			root = root.right;
		}
		
		return ret;
	}
}





















