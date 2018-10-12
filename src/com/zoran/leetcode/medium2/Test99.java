package com.zoran.leetcode.medium2;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * �����ظ�Ԫ�� III
 * https://leetcode-cn.com/submissions/detail/8156029/
 * 
 * [Soluion]
 * https://blog.csdn.net/weixin_41681068/article/details/82721992
 *
 *������Ʋ���ȷ����, ����
 */
public class Test99 {
	
	public static void main(String[] args) {
		Test99 test99 = new Test99();
		int[] nums = {1,2,3,1};
		test99.containsNearbyAlmostDuplicate(nums, 3, 0);
	}

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //��ٱ���, ͬʱ����2����������,��hashmap��������2��ֵ������λ��
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
		
		//����һ������
		SortedSet<Long> set=new TreeSet<Long>();
		for(int i=0;i<nums.length;i++) {
			//����������ڵ�һ���Ӽ����Ӽ��� ȡֵ��ΧΪ(nums[i]-t,nums[i]+t+1)��Ҳ������nums[i]���t��Ԫ����ɵļ���
			Set<Long> subSet=set.subSet((long) nums[i]-t,(long) nums[i]+t+1);
			
			//�����ϲ�Ϊ�գ���֤������������Ԫ��
			if(!subSet.isEmpty()) return true;
			//����Ĵ�����Ϊ��ά�����ڵĳ���Ϊk
			if(i>=k) set.remove((long) nums[i-k]);
			set.add((long) nums[i]);
		}
		
		return false;
    }
}