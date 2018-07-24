package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * N叉树的前序遍历
 * https://leetcode-cn.com/submissions/detail/4566288/
 */
import com.zoran.leetcode.util.NodeTest.Node;

public class Test130 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        forwardIterator(list,root);
        return list;
    }
    
    public void forwardIterator(List<Integer> list,Node root) {
        if (root == null) return;
        
        list.add(root.val);
        for(Node node : root.children) {
            forwardIterator(list,node);
        }
    }
    
    /**
     * 迭代方法遍历:
     * 运用while + LinkedList栈结构处理 
     */
    public List<Integer> Nice_preorder(Node root) {
    	List<Integer> result = new ArrayList<>();
    	if (root == null) return result;
    	
    	LinkedList<Node> fathers = new LinkedList<>();
    	LinkedList<Node> sons;
    	fathers.add(root);
    	
    	while (fathers.size() > 0) {
    		Node node = fathers.pop();
    		result.add(node.val);
    		fathers.addAll(0,node.children);
    	}
    	
    	return result;
    }
    
}
