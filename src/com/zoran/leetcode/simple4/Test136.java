package com.zoran.leetcode.simple4;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ���ݶ����������ַ���
 * https://leetcode-cn.com/submissions/detail/4666418/
 * 
 * [Solution]
 * https://blog.csdn.net/obrcnh/article/details/77996276
 */
public class Test136 {

    public String Nice_tree2str(TreeNode t) {
        if (t == null) return "";
        
        String str = String.valueOf(t.val);
        if (t.left != null) {
			str += '(' + Nice_tree2str(t.left) + ')';
		}else if (t.right != null) {
			str += "()"; //Core. ͬ����,��left�ڵ�,��right
		}
        
        if (t.right != null) {
        	str += '(' + Nice_tree2str(t.right) + ')';
        }
        
        return str;
    }
}
