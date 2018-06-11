package com.zoran.leetcode.simple2;

import java.util.concurrent.CountDownLatch;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * 旋转数组
 * https://leetcode-cn.com/submissions/detail/3091056/
 * 
 * 局部变量 放在for循环体内, 循环一次,生命周期就结束
 * 
 * [Solution]
 * https://blog.csdn.net/hy971216/article/details/80418783
 */
public class Test41 {

	public static void main(String[] args) {
//		输入: [1,2,3,4,5,6,7] 和 k = 3
//		输出: [5,6,7,1,2,3,4]
//		解释:
//		向右旋转 1 步: [7,1,2,3,4,5,6]
//		向右旋转 2 步: [6,7,1,2,3,4,5]
//		向右旋转 3 步: [5,6,7,1,2,3,4]
		
		int[] nums = new int[] {1,2,3,4,5,6,7};
		rotateOne(nums, 3);
		for (int i : nums) {
			System.out.println(i);
		}

	}
	
	/**
	 * 一次性旋转到正确的位置
	 * 逻辑问题 
	 */
    public static void rotate(int[] nums, int k) {
        int rotate = nums.length; int tmp;
        int currentIndex = 0; boolean init = true;
        while(rotate > 0) {
        	
        }
    }
    
    /**
     * 公式: (x + km) % length = x 
     * x代表数组索引, k代表旋转步数, m代表旋转几次
     * 如果要想索引值等于x的话, 那么 km = length的倍数, 所以m就等于 k与length的最小公倍数
     * 结论: 最后旋转都会走回到x的起始位置  
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
    			nums[next] = preNum; //core, 不是nums[next] = nums[current];
    			preNum= tmpNum;
    			
    			current = next;
    			count++; //控制循环次数
			} while (start != current);
    	}
    }

    public static void rotateOne(int[] nums, int k) {
    	if(nums == null || nums.length == 0) return;
    	int count = 0; 
    	
    	for(int i = 0; count < k; count++) {
    		int next=0; int tmp = 0; int preNum = nums[0]; //core: 循环体中初始变量的生命周期!!  http://will-turner.iteye.com/blog/1604671
    		for (int j = 0; j < nums.length; j++) {
    			//core 上一个,下一个数据轮回
    			next = (j + 1) % nums.length; //core 循环
    			tmp = nums[next];
    			nums[next] = preNum;
    			preNum = tmp;  
    		}
    	}
    }
}
