package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小高度树
 * https://leetcode-cn.com/submissions/detail/8826109/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_32142535/article/details/78120352
 * https://blog.csdn.net/jmspan/article/details/51205302
 */
public class Test125 {

}


class Nice_Test125 {
	   private int maxNode, maxDepth;
	    private void dfs(int from, int depth, List<Integer>[] graph, boolean[] visited, int[] dist, int[] prev) {
	        if (depth > maxDepth) {
	            maxDepth = depth;
	            maxNode = from;
	        }
	        for(int next: graph[from]) {
	            if (visited[next]) continue;
	            visited[next] = true;
	            prev[next] = from;
	            dist[next] = depth+1;
	            dfs(next, depth+1, graph, visited, dist, prev);
	        }
	    }
	    private List<Integer> roots = new ArrayList<>();
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        List<Integer>[] graph = new ArrayList[n];
	        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
	        for(int i=0; i<edges.length; i++) {
	            graph[edges[i][0]].add(edges[i][1]);
	            graph[edges[i][1]].add(edges[i][0]);
	        }
	        
	        boolean[] visited = new boolean[n];
	 
	        int[] dist1 = new int[n];
	        int[] prev1 = new int[n];
	        maxNode = 0;
	        maxDepth = 0;
	        visited[0] = true;
	        dfs(0, 0, graph, visited, dist1, prev1);
	        int node1 = maxNode;
	 
	        int[] dist2 = new int[n];
	        int[] prev2 = new int[n];
	        Arrays.fill(visited, false);
	        maxNode = node1;
	        maxDepth = 0;
	        visited[node1] = true;
	        dfs(node1, 0, graph, visited, dist2, prev2);
	        int node2 = maxNode;
	 
	        int node = node2;
	        for(int i=0; i<maxDepth/2; i++) node = prev2[node];
	        if ((maxDepth & 1) == 0) {
	            roots.add(node);
	        } else {
	            roots.add(node);
	            roots.add(prev2[node]);
	        }
	        return roots;
	    }
}