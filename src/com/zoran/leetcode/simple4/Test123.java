package com.zoran.leetcode.simple4;

import java.util.List;

/**
 * N������������
 * https://leetcode-cn.com/submissions/detail/4388807/
 */
public class Test123 {
//	public static void main(String[] args) {
//		Test123 test123 = new Test123();
//		
//		List<Node> list = new ArrayList<>();
//		Node root = 
//	}

	/**
	 * ������һ��ķ���ֵ. �ݹ�ʵ��
	 */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (Node node: root.children) {
            int high = maxDepth(node);
            if(high > max) max = high;
        }
        
        if(root.children == null) {
            return 1;
        }
        
        return max + 1; //Core. ��ǰһ��ĸ߶�
    }
    
 // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
