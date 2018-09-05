package com.zoran.leetcode.medium;

/**
 *  跳跃游戏
 * https://leetcode-cn.com/submissions/detail/6561707/  
 *
 * [Solution]
 * https://blog.csdn.net/MebiuW/article/details/51246767
 */
public class Test29 {
	
	public static void main(String[] args) {
		Test29 test29 = new Test29();
		int[] nums = {2,3,1,1,4};
		System.out.println(test29.canJump(nums));
	}

	/**
	 *  超出时间限制
	 *  [25000,24999,24998,24997,24996,24995,24994,24993,24992,24991,24990,24989,24988,24987,24986,24985,24984,24983,24982,24981,24980,24979,24978
	 *  ,24839,24838,24837,24836,24835,24834,24833,24832,24831,24830,24829,24828,24827,24826,24825,24824,24823,24822,24821,24820,24819,24818,24817,
	 *  ,24629,24628,24627,24626,24625,24624,24623,24622,24621,24620,24619,24618,24617,24616,24615,24614,24613,24612,24611,24610,24609,24608,246 ...
	 */
    public boolean canJump(int[] nums) {
        //遍历, 能达到最后索引则成功
        if(nums == null || nums.length == 0) return false;
        
        return jump(nums, 0);
    }
    
    public boolean jump(int[] nums, int startIndex) {
        boolean canArrive = false;
        if(startIndex >= nums.length-1) return true;
        
        for(int i=1; i<= nums[startIndex]; i++) {
            canArrive = jump(nums, startIndex+i);
            if(canArrive) return true;
        }
        
        return canArrive;
    }
}

/**
 * 贪心算法 : 你连最大的情况下 都满足不了, 那么就真的满足不了 
 * eg: 3 2 1 0 4
 * 	i: 0 1 2 3
 * re: 3 3 3 3
 */
class Nice_Test29 {
	public boolean canJump(int[] nums) {
		int reach = 0;   //Core. 能到达的位置
		int i = 0; //Core. 步数指针
		while (i<nums.length && i<=reach) {
			reach = Math.max(reach, i+nums[i]);
			i++;
		}
		
		return reach >= nums.length-1;
	}
}
