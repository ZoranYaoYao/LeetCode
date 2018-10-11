package com.zoran.leetcode.medium2;


/**
 * ��ҽ��� II
 * https://leetcode-cn.com/submissions/detail/8141820/
 * 
 * [Solution]
 * 2����̬�滮�����ֵ:
 * 
 * f(n) = nums(1)~nums(n-1)�Ľ��
 * f(n) = nums(2)~nums(n) �Ľ��
 * 2���е����ֵ
 */
public class Test96 {

	//    public int rob(int[] nums) {
	//        //��̬�滮,͵��ǰ���� ������һ���滮
	//        //f(n) = f(n-2) + nums[n];
	//        //f(n) = f(n-1);
	//        //��ͷ��ûβ, ��β��û��ͷ, ����ж�?
	//        
	//        if (nums == null || nums.length == 0) return 0;
	//        int[] count = new int[nums.length];
	//        for (int i=0; i<nums.length; i++) {
	//            if (i == 0) {
	//                count[i] = nums[i];
	//                continue;
	//            }
	//            int case1 = count[i-1];
	//            int case2 = Integer.MAX_VALUE;
	//            if(i >= 2) case2 = count[i-2] + nums[i];
	//            
	//        }
	//        
	//        return -1;
	//    }

	int[] count;
	public int rob(int[] nums) {
		//��̬�滮,͵��ǰ���� ������һ���滮
		//f(n) = nums(1)~nums(n-1);
		//f(n) = nums(2)~nums(n);
		//��ͷ��ûβ, ��β��û��ͷ, ����ж�?

		if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
		count = new int[nums.length];
		count[0] = nums[0];
		count[1] = Math.max(nums[0], nums[1]);
		
		count[2] = Math.max(nums[0], nums[1]); 
		count[2] = Math.max(count[2], nums[2]);
		iterator(nums);
		return count[nums.length-1];

	}

	public int iterator(int[] nums) {
		for (int i=3; i<nums.length; i++) {
			int len = i;
			int[] temp = new int[len];
			System.arraycopy(nums, 0, temp, 0, len);
			count[i] = getMax(temp);

			int[] temp2 = new int[len];
			System.arraycopy(nums, 1, temp2, 0, len);
			int case2 = getMax(temp2);
			count[i] = Math.max(count[i], case2);
		}

		return count[nums.length-1];
	}
	
	public int getMax(int[] nums) {
		int[] cur = new int[nums.length];
		cur[0] = nums[0];
		cur[1] = Math.max(nums[0], nums[1]);
		
		for (int i =2; i<nums.length; i++) {
			cur[i] = cur[i-1];
			int another = cur[i-2] + nums[i];
			cur[i] = Math.max(cur[i], another);
		}
		
		return cur[nums.length-1];
	}
}

class LeetCode_Test96 {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		
		return Math.max(robsub(nums, 0, nums.length-2), robsub(nums, 1,nums.length-1)); //Core. �������nums�����޸�, ����ֱ�Ӵ��ݷ�Χ������ֵ�͸�����
	}
	
	private int robsub(int[] nums, int s, int e) {
		int d[] =new int[e-s+1];
		int n = e-s+1;
		d[0] = nums[s];
		d[1] = Math.max(nums[s], nums[s+1]);
		for (int i=2; i<n; i++) {
			d[i] = Math.max(d[i-2]+nums[s+i], d[i-1]);
		}
		return d[n-1];
	}
}































