package com.zoran.leetcode.medium6;

import com.zoran.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * �����������
 * https://leetcode-cn.com/submissions/detail/12285536/
 *
 * [Solution]
 * http://www.cnblogs.com/parzulpan/p/10090566.html
 *
 * �����������������ҽڵ�����ڵ�λ�õĹ�ϵ��������Ŀ��
 * fu��n ��2n �ң�2n+1
 */
public class Test253 {
    /**
     * 104 / 108 ��ͨ����������
     * ״̬������ʱ������
     * ��̫���ˣ���
     */
    public int widthOfBinaryTree(TreeNode root) {
        //�㼶������null����Ҳ�����ڼ�����
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int left = -1, right=0;
            for (int i=0; i<size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp != null){
                    if (left == -1) left = i;
                    right = i;
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                } else {
                    queue.add(null);
                    queue.add(null);
                }
            }
            if (left == -1) return res;

            res = Math.max(right-left+1, res);
        }

        return res;
    }
}

class Nice_Test253 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int res =0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = -1, right=0;
            for (int i=0; i<size; i++) {
                TreeNode tmp = queue.poll();
                int cur = map.get(tmp);
                if (i == 0)
                    left = cur;
                right = cur;

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    map.put(tmp.left, 2*cur);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    map.put(tmp.right, 2*cur + 1);
                }
            }
            res = Math.max(right-left+1, res);
        }
        return res;
    }
}
























