package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 两个列表的最小索引总和
 * https://leetcode-cn.com/submissions/detail/4614153/
 */
public class Test134 {
	
	public static void main(String[] args) {
		String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] list2 = {"KFC","Shogun","Burger King"};
		
		Test134 test134 = new Test134();
		String[] result = test134.findRestaurant(list1, list2);
		for(String item: result) {
			System.out.println(item);
		}
	}

	/**
	 *  Map数据集合的运用
	 */
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list2.length > list1.length) findRestaurant(list2, list1);
        
        Map<String,Integer> result = new HashMap<>();
        int minAdd = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++) {
            for(int j = 0; j < list1.length; j++) {
                if(list2[i].equals(list1[j])) {
                    if(minAdd >i+j) {
                        minAdd = i+j;
                    }
                    result.put(list2[i],i+j);
                    break;
                }
            }
        }
        
        List<String> list = new ArrayList<>();
        for(Entry<String, Integer> item: result.entrySet()) {
            if(item.getValue() == minAdd) {
                list.add(item.getKey());
            }
        }
        
        /**
         *  ArrayList    public <T> T[] toArray(T[] a) {  
         *		1. 采用的是数据拷贝方式
         *      2. 返回值也是a数组
         *  public Object[] toArray() {
         *  	1. 
         *  
         */
        return list.toArray(new String[list.size()]);
    }
}
