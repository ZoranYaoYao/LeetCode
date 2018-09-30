package com.zoran.leetcode.medium2;

/**
 * �˻����������
 * https://leetcode-cn.com/submissions/detail/7747901/
 * 
 * ��������: �ȷָ�0, �ڷָ����λ��, ����
 * �����ö�̬�滮: dp[i] = dp[i-1] * nums[i] (nums[i] > 0);
 */
public class Test83 {
	
	public static void main(String[] args) {
		Test83 test83 = new Test83();
		int[] nums = {1,0,-1,2,3,-5,-2};
		int res = test83.maxProduct(nums);
		System.out.println(res);
	}

    int max = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        //��������: �ȷָ�0, �ڷָ����λ��, ����
        
        if(nums == null || nums.length == 0) return 0;
        int preZeroLoc = -1;
        for(int i=0; i<nums.length; i++) {
        	max = Math.max(max, nums[i]); //����Ԫ��
            if (nums[i] == 0 )  { 
              divide(nums, preZeroLoc, i);
              preZeroLoc = i;
            }
            
            if(preZeroLoc!=-1 && i==nums.length-1) { //�����β
                divide(nums, preZeroLoc, i+1);
            }
        }
        
        if(preZeroLoc == -1) divide(nums, -1, nums.length);

        return max;
    }
    
    public void divide(int[] nums, int start, int end) { //������start, end
    	if (end - start <= 2) return; //�޳�ֵ����һ��Ԫ��.
        int all = 1;
        int negativeCount = 0;
        for (int i=start+1; i<end; i++) {
            if(nums[i] < 0) negativeCount++;
            all *= nums[i];
        }    
        if(negativeCount%2 == 0) {
            max = Math.max(max, all);
        } else { //������,2�����
            int containHead = all;
            for (int i=end-1; i>start; i--) {
                containHead /= nums[i];
                if(nums[i] <0)  {
                    max = Math.max(max, containHead);
                    break;
                }
            }
            int containTail = all;
            for (int i=start+1; i<end; i++) {
            	containTail /= nums[i];
                if (nums[i] <0) {
                    max = Math.max(max, containTail);
                }
            }
        }
    }
}
