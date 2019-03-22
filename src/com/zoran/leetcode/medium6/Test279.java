package com.zoran.leetcode.medium6;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 网络延迟时间
 * https://leetcode-cn.com/submissions/detail/15265673/
 *
 * [Solution]
 * https://blog.csdn.net/afei__/article/details/83780362
 */
public class Test279 {
}

class Nice_Test279 {

    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, NetNode> map = new HashMap<>();
        PriorityQueue<NetNode> queue = new PriorityQueue<>(N, (o1,o2) -> o1.distance-o2.distance);

        for (int i=1; i<=N; i++) {
            NetNode node = new NetNode(i);
            if (i == K)
                node.distance = 0;
            map.put(i, node);
            queue.offer(node);
        }

        for (int i=0; i<times.length; i++) {
            NetNode node = map.get(times[i][0]);
            //Core 每个节点的邻居节点赋值
            node.neighbors.put(times[i][1], times[i][2]);
        }

        while (!queue.isEmpty()) {
            NetNode min = queue.poll();
            if (min.distance == Integer.MAX_VALUE) return -1;

            for (int v : min.neighbors.keySet()) {
                NetNode curr = map.get(v);
                int distance = min.distance + min.neighbors.get(v);
                if (distance < curr.distance) {
                    curr.distance = distance;
                    queue.remove(curr);
                    queue.add(curr);
                }
            }

        }

        // Step 6: find max
        int max = 0;
        for (Map.Entry<Integer, NetNode> entry : map.entrySet()) {
            if (entry.getValue().distance > max) {
                max = entry.getValue().distance;
            }
        }
        return max;
    }

    public static class NetNode {
        int u;
        HashMap<Integer, Integer> neighbors = new HashMap<>();
        int distance = Integer.MAX_VALUE; //Core 从发源点！到该节点的最短距离值

        public NetNode(int u) {
            this.u =  u;
        }
    }
}
