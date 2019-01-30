package com.zoran.leetcode.medium5;

import com.zoran.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找重复的子树
 * https://leetcode-cn.com/submissions/detail/12242561/
 *
 * [Solution]
 * https://blog.csdn.net/xiezongsheng1990/article/details/79732909
 *
 * 先序遍历 + HashMap
 */
public class Test248 {
}

class Nice_Test248 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) return list;
        find(root, new HashMap<String, Integer>(), list);
        return list;
    }

    public String find(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list){
        if (root == null) return "#";
        //Nice_Core. 通过前序遍历获取到每个子树的的前序的结构！！
        String str = root.val + find(root.left, map, list)
                + "," + find(root.right, map, list);
        if(map.getOrDefault(str, 0) == 1) list.add(root);
        map.put(str, map.getOrDefault(str, 0) + 1); //只记录2个重复的
        return str;
    }
}