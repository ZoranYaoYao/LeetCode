package com.zoran.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * https://leetcode-cn.com/submissions/detail/2865626/
 */
public class Test28 {

	public static void main(String[] args) {
		System.out.println(Nice_getRow(3));
	}

	public static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> list = generate(rowIndex + 1);

		if(list == null) return null;

		return list.get(rowIndex);

	}

	/**
	 * core : 只保存 previousList, currentList 双重循环,获得元素
	 */
	public static List<Integer> Nice_getRow(int rowIndex) {      
		List<Integer> row = new ArrayList<>();
		List<Integer> prevRow ;
		if(rowIndex == 0){
			row.add(1);
		}
		for(int numRow = 1; numRow <=rowIndex; numRow ++){
			prevRow = row;			
			row =  new ArrayList<>();
			row.add(1);
			for(int j =1; j < numRow ; j++){
				row.add(prevRow.get(j-1)+prevRow.get(j));
			}
			row.add(1);			
		}
		return row;
	}

	/**
	 * core : 每次生成下一排数据都依赖上一排的数据
	 */
	 public static List<List<Integer>> generate(int numRows) {
		 if(numRows <= 0) return null;

		 List<List<Integer>> list = new ArrayList<>();
		 List<Integer> previousList = new ArrayList<>();
		 for(int i = 1; i <= numRows; i++) {
			 previousList = generateItem(previousList, i);
			 list.add(previousList);
		 }

		 return list;
	 }

	 private static List<Integer> generateItem(List<Integer> previousList, int numRows) {
		 List<Integer> list = new ArrayList<>();
		 if(numRows == 1) {
			 list.add(1); return list;
		 }

		 for(int i = 0; i < previousList.size(); i++) {
			 if(i == 0) {
				 list.add(1);
				 continue;
			 } 
			 list.add(previousList.get(i -1) + previousList.get(i));
		 }
		 list.add(1); //core最后元素

		 return list;
	 }
}
