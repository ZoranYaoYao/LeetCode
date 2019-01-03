package com.zoran.leetcode.medium5;

import com.zoran.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出现次数最多的子树元素和
 * https://leetcode-cn.com/submissions/detail/11159249/
 *
 * First Submit
 */
public class Test205 {

    public int[] findFrequentTreeSum(TreeNode root) {
        //dfs遍历+HashMap
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root,map);

        int max = 0;
        for(Map.Entry<Integer, Integer> item : map.entrySet()) {
            max = Math.max (max, item.getValue());
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == max) list.add(item.getKey());
        }
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int dfs(TreeNode root, Map<Integer, Integer> map) {
        if(root == null) return 0;

        int count = root.val;
        if (root.left != null) count += dfs(root.left, map);
        if (root.right != null) count += dfs(root.right, map);
        map.put(count, map.getOrDefault(count, 0) + 1);

        return count;
    }
}
