package com.zoran.leetcode.medium2;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 存在重复元素 III
 * https://leetcode-cn.com/submissions/detail/8156029/
 * 
 * [Soluion]
 * https://blog.csdn.net/weixin_41681068/article/details/82721992
 *
 *题意设计不明确的题, 不好
 */
public class Test99 {
	
	public static void main(String[] args) {
		Test99 test99 = new Test99();
		int[] nums = {1,2,3,1};
		test99.containsNearbyAlmostDuplicate(nums, 3, 0);
	}

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //穷举遍历, 同时满足2个给的条件,用hashmap保存最大的2个值得索引位置
        int maxAbs = 0;
        int maxIndexAbs = 0;
        int[] value = new int[2];
        int[] index = new int[2];
        
        for (int i = 0; i<nums.length; i++) {
            for (int j =i+1; j<nums.length; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                int indexAbs = Math.abs(i-j);
                if (abs > maxAbs) {
                    value[0] = i; value[1] = j;
                    maxAbs = abs;
                }
                if (indexAbs > maxIndexAbs) {
                    index[0] = i; index[1] = j;
                    maxIndexAbs = indexAbs;
                }
            }
        }
        
        boolean res = value[0] == index[0] && value[1] == index[1] && maxAbs == t && maxIndexAbs == k;
        return res;
    }
}

class Nice_Test99 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1||t<0||nums.length<=1) return false;
		
		//创建一个窗口
		SortedSet<Long> set=new TreeSet<Long>();
		for(int i=0;i<nums.length;i++) {
			//创建这个窗口的一个子集，子集的 取值范围为(nums[i]-t,nums[i]+t+1)，也就是与nums[i]相差t的元素组成的集合
			Set<Long> subSet=set.subSet((long) nums[i]-t,(long) nums[i]+t+1);
			
			//若集合不为空，则证明存在这样的元素
			if(!subSet.isEmpty()) return true;
			//下面的代码是为了维护窗口的长度为k
			if(i>=k) set.remove((long) nums[i-k]);
			set.add((long) nums[i]);
		}
		
		return false;
    }
}