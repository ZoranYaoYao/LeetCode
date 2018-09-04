package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/submissions/detail/6529068/
 * 
 * [Solution]
 * https://www.cnblogs.com/lightwindy/p/8564387.html
 */
public class Test28 {
	
	public static void main(String[] args) {
		Test28 test28 = new Test28();
		int[][] nums = {
				 { 2,5,8 },
				 { 4,0,-1 },
		};
		
		System.out.println(test28.spiralOrder(nums));
	}

	/**
	 * 算法有问题
	 * 退出条件太复杂 , 逻辑混乱, 下一个值得约束条件不对
	 */
    public List<Integer> spiralOrder(int[][] matrix) {
        //处理边界, 上下行 和左右列
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;
        
        //如何遍历
        int orientation = 0; int count = 0; int exit = 4;
        int topRow = -1; int bottomRow= matrix.length;
        int leftColoumn = -1; int rightColoumn = matrix[0].length;
        
        int curRow =0; int curColumn =0;
        while (count < exit) {
            if(orientation == 0) {  //右遍历
                if(curColumn >= rightColoumn || count ==2) {
                    orientation=1;
                    curColumn--;
                    rightColoumn = curColumn;
                    topRow++;
                    curRow++;
                    count++;
                }
                else {
                    result.add(matrix[curRow][curColumn]);
                    curColumn++;
                    count =0;
                }
            } else if(orientation == 1) { //下遍历
                if(curRow >= bottomRow || count ==2) {
                    orientation=2;
                    curRow--;
                    bottomRow = curRow;
                    curColumn--;
                    count++;
                }
                else {
                    result.add(matrix[curRow][curColumn]);
                    curRow++;
                    count =0;
                }
            } else if(orientation == 2) { //左遍历
                if(curColumn <= leftColoumn || count ==2) { //Core. count==2
                    orientation=3;
                    curColumn++;
                    leftColoumn = curColumn;
                    curRow--;
                    count++;
                }
                else {
                    result.add(matrix[curRow][curColumn]);
                    curColumn--;
                    count =0;
                }
            } else if(orientation == 3) { //上遍历
                if(curRow <= topRow || count == 2) {
                	orientation = 0;
                	curRow++;
                    topRow = curRow;
                    curColumn++;
                    count++;
                } else {
                    result.add(matrix[curRow][curColumn]);
                    curRow--;
                    count =0;
                }
            }
        }
        
        return result;
    }
}

class Nice_Test28 {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length ==0) return res;
		
		int rowNum = matrix.length; int colNum = matrix[0].length;
		int left =0; int right = colNum -1; //Core. 四个变量
		int top = 0; int bot = rowNum -1;
		
		while (res.size() < rowNum*colNum) { //Core. 退出条件:取出所有值时
			for (int col = left; col <= right; col++) {
				res.add(matrix[top][col]);
			}
			top++;
			
			if(res.size() < rowNum*colNum) {
				for (int row = top; row <= bot; row++) {
					res.add(matrix[row][right]);
				}
				right--;
			}
			
			if (res.size() < rowNum*colNum) {
				for(int col=right; col >= left; col--) {
					res.add(matrix[bot][col]);
				}
			}
			
			if (res.size() < rowNum*colNum) {
				for (int row = bot; row >= top; row--) {
					res.add(matrix[row][left]);
				}
				left++;
			}
		}
		
		return res;
	}
}