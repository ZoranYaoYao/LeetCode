package com.zoran.leetcode.simple4;

import java.util.List;

/**
 * N叉树的最大深度
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
	 * 依赖上一层的返回值. 递归实现
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
        
        return max + 1; //Core. 当前一层的高度
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
