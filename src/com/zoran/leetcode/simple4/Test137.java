package com.zoran.leetcode.simple4;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * �ϲ�������
 * https://leetcode-cn.com/submissions/detail/4695700/
 */
public class Test137 {

	/**
	 * rebase һ��tree t1������ 
	 */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;

        if(t1 == null && t2 != null) {
            t1 = new TreeNode(t2.val);
            if(t2.left != null) {
                TreeNode tmp = new TreeNode(0);
                t1.left = tmp;
                mergeTrees(tmp, t2.left);
            }
            if(t2.right != null) {
                TreeNode tmp = new TreeNode(0);
                t1.right = tmp;
                mergeTrees(tmp, t2.right);
            }
        } else if(t1 != null && t2 != null) {
            t1.val += t2.val;
            mergeTrees(t1, t1.left, t2.left, true);
            mergeTrees(t1, t1.right, t2.right, false);
        }
        return t1;
    }
    
    public TreeNode mergeTrees(TreeNode t1_parent,TreeNode t1, TreeNode t2, boolean isLeft) {
        if(t1_parent != null && t1 != null && t2 != null) {
            t1.val += t2.val;
        } else if(t1_parent != null && t1 == null && t2 != null){
            TreeNode tmp = new TreeNode(t2.val);
            if(isLeft) {
               t1_parent.left = tmp;
            } else {
                t1_parent.right = tmp;
            }
        } else if (t1_parent == null && t2 != null) {
            TreeNode tmp = new TreeNode(t2.val);
            
        }
		return t2;
    }


    public TreeNode mergeTreesU1(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        
        TreeNode result = new TreeNode(0);
        if(t1 != null && t2 != null) {
           result.val = t1.val + t2.val; 
           mergeTrees0(result, t1.left, t2.left, true); 	//�Ż���: �����ڵ�����ӷ�����, ����һ���ظ��߼�
           mergeTrees0(result, t1.right, t2.right, false);  //[Solution]  
        } else if(t1 == null && t2 != null) {				// reuslt.left = mergeTreesU1(t1.left, t2.left); �������ɵĽڵ㷵�ػ���
            result.val = t2.val;
            mergeTrees0(result,null, t2.left, true);
            mergeTrees0(result,null, t2.right, false);
        } else if(t1 != null && t2 == null) {
            result.val = t1.val;
            mergeTrees0(result,t1.left, null, true);
            mergeTrees0(result,t1.right, null, false); 
        } 
        return result;
    }
    
    public void mergeTrees0(TreeNode result, TreeNode t1, TreeNode t2,boolean isLeft) {
        TreeNode child = new TreeNode(0);
        if(t1 != null && t2 != null) {
            child.val = t1.val + t2.val; 
            mergeTrees0(child,t1.left, t2.left, true);
            mergeTrees0(child,t1.right, t2.right, false); 
        } else if(t1 == null && t2 != null) {
            child.val = t2.val;
            mergeTrees0(child,null, t2.left, true);
            mergeTrees0(child,null, t2.right, false); 
        } else if(t1 != null && t2 == null){
            child.val = t1.val;
            mergeTrees0(child,t1.left, null, true);
            mergeTrees0(child,t1.right, null, false); 
        } else {
            return;
        }
        
        if(isLeft) {
           result.left = child;
        } else {
           result.right = child;
        }
    }
    
    
    public TreeNode Nice_mergeTrees(TreeNode t1, TreeNode t2) {
    	TreeNode t3 = null;
    	if (t1 != null && t2 != null) {
    		t3 = new TreeNode(t1.val + t2.val);
    		t3.left = mergeTrees(t1.left, t2.left); //Core. �������Ľڵ㸳ֵ����Ӧ�Ľڵ���ӽڵ�!!
    		t3.right = mergeTrees(t1.right, t2.right);
    	} else if(t1 != null && t2 == null) {
    		t3 = new TreeNode(t1.val);
    		t3.left = mergeTrees(t1.left, null);
    		t3.right = mergeTrees(t1.right, null);
    	} else if (t1 == null && t2 != null) {
    		t3 = new TreeNode(t2.val);
    		t3.left = mergeTrees(null, t2.left);
    		t3.right = mergeTrees(null, t2.right);
    	}
    	return t3;
    }
}
