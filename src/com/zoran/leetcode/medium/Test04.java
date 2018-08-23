package com.zoran.leetcode.medium;

/**
 * Z字形变换
 * https://leetcode-cn.com/submissions/detail/5941000/
 */
public class Test04 {
	
	public static void main(String[] args) {
		Test04 test04 = new Test04();
		System.out.println(test04.convert("AB", 1));
	}

    public String convert(String s, int numRows) {
    	if(numRows == 1) return s;
    	
        //对字符串数组进行排列额
        String[] strs = new String[numRows];
        for(int i=0; i< strs.length; i++) {
        	strs[i] = "";
        }
        char[] arr = s.toCharArray();
        int curIndex = 0; int oriention = 1; //1-down, 2-up;
        for(int i=0; i<arr.length; i++) {
            if(curIndex == numRows-1) {
                oriention = 2;
            } else if(curIndex == 0) {
                oriention =1;
            }
            strs[curIndex] += arr[i];
            
            if(oriention == 1) {
                curIndex++;  
            } else if (oriention == 2) {
                curIndex--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String item: strs) {
            sb.append(item);
        }
        
        return sb.toString();
    }
}
