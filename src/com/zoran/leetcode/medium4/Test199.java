package com.zoran.leetcode.medium4;

import java.util.*;

/**
 * 递增子序列
 * https://leetcode-cn.com/submissions/detail/10934511/
 *
 * 如何去重？ 467
 * addNum 如果是 467879 就会出现4679 2次！！ 所以用一个标记前后位是不可靠的！！ ， 必须用HashSet 去重
 */
public class Test199 {

    public static void main(String[] args) {
        Test199 test199 = new Test199();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<List<Integer>> res = test199.findSubsequences(nums);
        System.out.println(res);

    }

    /**
     * 15 / 57 个通过测试用例
     * 状态：解答错误
     * 算法有问题
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        //回溯算法
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) return res;
        backTrace(res, nums, 0, new ArrayList<Integer>());

        return res;
    }



    public void backTrace(List<List<Integer>> res, int[] nums, int start, List<Integer> cur) {
        //|| (cur.size()>1 && cur.get(cur.size()-1) > nums[start])
        if (start == nums.length ) {

            if (cur.size() < 2) return;
//            System.out.println("start = " + start + ", cur = " + cur);
            res.add(new ArrayList<>(cur));
            return;
        }

        /**
         * 如何去重？ 467
         * addNum 如果是 467879 就会出现4679 2次！！ 所以用一个标记前后位是不可靠的！！ ， 必须用HashSet 去重
         * */
        boolean added = false;
        int addNum = Integer.MIN_VALUE;
        for (int i=start; i<nums.length; i++) {
            if (cur.size() == 0 || (cur.get(cur.size()-1) <= nums[start])) {
                if (cur.size() > 1 && !added) {
                    res.add(new ArrayList<>(cur));
                    added = true;
                }
                if (addNum == nums[i]) continue;

                cur.add(nums[i]);
                addNum = nums[i];
                backTrace(res, nums, i+1, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}

class LeetCode_Test199 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backTrace(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }

    private void backTrace(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res) {
        if (list.size()>1) res.add(new LinkedList<Integer>(list));
        //Nice_Core 对当前层后面的元素 进行去重
        /***
         * eg: 4 6 7 7
         *  set: 在嵌入的第二层中 46， 添加(第一个)7之后，变为467
         *  然后在添加第二个7时，是不会进行添加的。
         */
        Set<Integer> used = new HashSet<>();
        for (int i=index; i<nums.length; i++) {
            if (used.contains(nums[i])) continue;
            if (list.size() ==0 || nums[i] >=list.peekLast()) {
                used.add(nums[i]);
                list.add(nums[i]);
                backTrace(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
    }

}















































