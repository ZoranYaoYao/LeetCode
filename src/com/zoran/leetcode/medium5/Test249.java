package com.zoran.leetcode.medium5;

import com.zoran.leetcode.util.TreeNode;

import java.util.Arrays;

/**
 * 最大二叉树
 * https://leetcode-cn.com/submissions/detail/12243437/
 *
 * 递归遍历生成
 */
public class Test249 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        Test249 test249 = new Test249();
        test249.constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //递归遍历生成
        int maxIndex = -1,max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > max)  {
                max = nums[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) return null;

        TreeNode node = new TreeNode(nums[maxIndex]);
        if (maxIndex-1 >= 0) node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxIndex)); //to 不包含
        if (maxIndex+1 < nums.length) node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIndex+1,nums.length));
        return node;
    }
}
