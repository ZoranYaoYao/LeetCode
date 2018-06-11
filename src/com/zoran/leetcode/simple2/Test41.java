package com.zoran.leetcode.simple2;

import java.util.concurrent.CountDownLatch;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * ��ת����
 * https://leetcode-cn.com/submissions/detail/3091056/
 * 
 * �ֲ����� ����forѭ������, ѭ��һ��,�������ھͽ���
 * 
 * [Solution]
 * https://blog.csdn.net/hy971216/article/details/80418783
 */
public class Test41 {

	public static void main(String[] args) {
//		����: [1,2,3,4,5,6,7] �� k = 3
//		���: [5,6,7,1,2,3,4]
//		����:
//		������ת 1 ��: [7,1,2,3,4,5,6]
//		������ת 2 ��: [6,7,1,2,3,4,5]
//		������ת 3 ��: [5,6,7,1,2,3,4]
		
		int[] nums = new int[] {1,2,3,4,5,6,7};
		rotateOne(nums, 3);
		for (int i : nums) {
			System.out.println(i);
		}

	}
	
	/**
	 * һ������ת����ȷ��λ��
	 * �߼����� 
	 */
    public static void rotate(int[] nums, int k) {
        int rotate = nums.length; int tmp;
        int currentIndex = 0; boolean init = true;
        while(rotate > 0) {
        	
        }
    }
    
    /**
     * ��ʽ: (x + km) % length = x 
     * x������������, k������ת����, m������ת����
     * ���Ҫ������ֵ����x�Ļ�, ��ô km = length�ı���, ����m�͵��� k��length����С������
     * ����: �����ת�����߻ص�x����ʼλ��  
     */
    public static void Nice_rotate(int[] nums, int k) {
    	k = k % nums.length; //core
    	int count = 0;
    	
    	for(int start = 0; count < nums.length; start++) {
    		int current = start;
    		int preNum = nums[start]; 
    		int next = start;
    		int tmpNum = nums[start];
    		do {
    			next = (current + k) % nums.length; 
    			tmpNum = nums[next];
    			nums[next] = preNum; //core, ����nums[next] = nums[current];
    			preNum= tmpNum;
    			
    			current = next;
    			count++; //����ѭ������
			} while (start != current);
    	}
    }

    public static void rotateOne(int[] nums, int k) {
    	if(nums == null || nums.length == 0) return;
    	int count = 0; 
    	
    	for(int i = 0; count < k; count++) {
    		int next=0; int tmp = 0; int preNum = nums[0]; //core: ѭ�����г�ʼ��������������!!  http://will-turner.iteye.com/blog/1604671
    		for (int j = 0; j < nums.length; j++) {
    			//core ��һ��,��һ�������ֻ�
    			next = (j + 1) % nums.length; //core ѭ��
    			tmp = nums[next];
    			nums[next] = preNum;
    			preNum = tmp;  
    		}
    	}
    }
}
