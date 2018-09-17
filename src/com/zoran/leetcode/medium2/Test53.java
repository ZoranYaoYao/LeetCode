package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ���������LDR���Ƕ�����������һ�֣�Ҳ�����и��������������Ρ��ڶ������У�����������ȱ�����������Ȼ����ʸ���㣬��������������
 *
 */
public class Test53 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        iteratorTree(res, root);
        return res;
    }
    
    public void iteratorTree(List<Integer> res, TreeNode node) {
        if(node == null) return;
        
        iteratorTree(res, node.left); //��
        if(node != null) res.add(node.val); //��
        iteratorTree(res, node.right);  //��
    }
}
