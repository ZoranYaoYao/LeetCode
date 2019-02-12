package com.zoran.leetcode.medium6;

/**
 * 冗余连接
 * https://leetcode-cn.com/submissions/detail/12598344/
 *
 * [Solution]
 * https://blog.csdn.net/qq_26410101/article/details/80616553
 * https://blog.csdn.net/qq_38595487/article/details/79661466
 *
 * 利用一位数组索引值，进行检查是否有环！！
 */
public class Test261 {
    public static void main(String[] args) {
        int[][] nums = {{1,2}, {1,3}, {2,3}};
        Test261 test261 = new Test261();
        test261.findRedundantConnection(nums);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] nums = new int[2000];

        for(int[] i : edges){
            int root1 = find(i[0],nums);
            int root2 = find(i[1],nums);
            if (root1 == root2)
                return i;
            else {
                nums[root1] = root2;
            }
        }
        return null;

    }

    /**
     * Core. 利用一位数组索引值，进行检查是否有环！！
     */
    public static int find(int x, int[] nums){
        while (nums[x] != 0){
            x = nums[x];
        }
        return x;
    }

}
