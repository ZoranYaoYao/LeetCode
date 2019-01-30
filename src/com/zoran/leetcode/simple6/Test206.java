package com.zoran.leetcode.simple6;

import com.zoran.leetcode.util.NodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static com.zoran.leetcode.util.NodeTest.Node;

/**
 * N叉树的层序遍历
 * https://leetcode-cn.com/submissions/detail/12253424/
 */
public class Test206 {
    public List<List<Integer>> levelOrder(Node root) {
        //层级遍历
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<NodeTest.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0) {
                Node tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.children != null) queue.addAll(tmp.children);
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
