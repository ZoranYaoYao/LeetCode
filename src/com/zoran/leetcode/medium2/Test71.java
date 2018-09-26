package com.zoran.leetcode.medium2;

import java.util.HashMap;

import com.zoran.leetcode.util.NodeTest.UndirectedGraphNode;

/**
 * ¿ËÂ¡Í¼
 * https://leetcode-cn.com/submissions/detail/7569881/
 * 
 * [Solution]
 * https://www.cnblogs.com/lightwindy/p/8491354.html
 */
public class Test71 {

    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
 
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
         
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
	
}
