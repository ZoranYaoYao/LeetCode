package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 第k个排列
 * https://leetcode-cn.com/submissions/detail/6619983/
 * 
 * [Solution]
 * https://www.cnblogs.com/ariel-dreamland/p/9149577.html
 * https://blog.csdn.net/Lynn_Baby/article/details/80948414
 * 
 *  类似, 将list<Integer> 转换成了 String形式  -> 超时
 *  https://leetcode-cn.com/problems/permutations/description/
 *  
 *  最终原理,: 对于第n个数, 它在
 *   int indexList = k/factorail;  // factorail 为阶乘总数
 */
public class Test32 {
	public static void main(String[] args) {
		Test32 test32 =new Test32();
		String string = test32.getPermutation(9, 219601);
		System.out.println(string);
	}

	/**
	 * 超时
	 * 9 219601
	 * 
	 * 算法正确, 事件超时
	 */
    public String getPermutation(int n, int k) {
        //回溯算法, 遍历到第K个排列
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = i+1;
        }
        
        List<String> list = new ArrayList<>();
        backTrace(nums, list, k, new StringBuilder());
        
        return list.get(k-1);
    }
    
    public void backTrace(int[] nums, List<String> list, int k, StringBuilder sb) {
        if(list.size() == k) return;
        
        if(sb.toString().length() == nums.length) {
            list.add(sb.toString());
        } else {
            for(int i=0; i<nums.length; i++) { 
            	if(sb.length() >0 && sb.indexOf(nums[i]+"") != -1) continue; //CCore. 去重, StringBuilder包含的字符问题
                sb.append(nums[i]);
                backTrace(nums, list, k, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}

/**
 * 利用回溯算法 -> 找规律
 */
class Nice_Test32 {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<Integer>();//注意存储1-n
        StringBuilder s = new StringBuilder();
        int times = n-1;
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int factorail = 1;//阶乘
        for(int i=2;i<n;i++){//不要×n
            factorail*=i;
        }
        while(times>=0){
            int indexList = k/factorail;
            s.append(list.get(indexList));
            list.remove(indexList);
            k=k%factorail;
            if(times!=0){
                factorail/=times;
            }
            times--;
        }
        return s.toString();

    }
}
