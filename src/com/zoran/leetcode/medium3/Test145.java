package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 查找和最小的K对数字
 * https://leetcode-cn.com/submissions/detail/9515604/
 *
 *【solution】
 * http://www.cnblogs.com/lightwindy/p/9363836.html
 */
public class Test145 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //组合， 返回前K对数
        List<int[]> res = new ArrayList<>();
        if (k <= 0) return res;
        
        int count = 0;
        boolean jumpi = false;
        int loci = 0, locj = 0;
        for (int i=0; i<nums1.length; i++) {
            labelI:
            for (int j=0; j<nums2.length; j++) {
                if (count < k) {
                    int[] temp = {nums1[i],nums2[j]};
                    res.add(temp);
                    count++;
                    if (i+1<nums1.length && nums1[i+1]==nums1[i]) {
                        jumpi = true;
                        loci = i;
                        locj = j;
                        break labelI;
                    }
                    if (j+1 < nums2.length && nums2[j+1] == nums2[j]) {
                        jumpi = false;
                    } 
                }
            }
        }
        
        return res;
    }
}

class Nice_LeetCode_Test145 {
	public static void main(String[] args) {
		int[] nums1 = {1,1,1,1,7,8}, nums2 = {1,2,3,4};
		Nice_LeetCode_Test145 test145 = new Nice_LeetCode_Test145();
		List<int[]> res = test145.kSmallestPairs(nums1, nums2, 400);
		for (int[] item : res) {
			System.out.println(Arrays.toString(item));
		}

	}
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<int[]> res = new ArrayList<int[]>();
        if(nums1.length==0 || nums2.length ==0)
            return res;
        boolean visit[][] = new boolean[nums1.length][nums2.length];
        Queue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] i, int[] j) {
                return (nums1[i[0]] + nums2[i[1]] - (nums1[j[0]] + nums2[j[1]]));  //Core.从源码看，i是刚添加的元素，j是集合中的元素
            }
        });

        heap.add(new int[]{0, 0});
        visit[0][0] = true;   //Core. 记录2位数组哪些元素被访问过

        while (!heap.isEmpty() && res.size() < Math.min(k,nums1.length * nums2.length)) {
            int d[] = heap.poll(); //每次都是推出小根堆！！
            res.add(new int[]{nums1[d[0]], nums2[d[1]]});

            if (d[1] + 1 < nums2.length && visit[d[0]][d[1] + 1] == false) {
                heap.add(new int[]{d[0], d[1] + 1});
                visit[d[0]][d[1] + 1] = true;
            }
            if (d[0] + 1 < nums1.length && visit[d[0] + 1][d[1]] == false) {
                heap.add(new int[]{d[0] + 1, d[1]});
                visit[d[0] + 1][d[1]] = true;
            }
        }
        return res;
    }
}
