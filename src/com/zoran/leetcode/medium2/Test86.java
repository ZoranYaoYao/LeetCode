package com.zoran.leetcode.medium2;


/**
 * 比较版本号
 * https://leetcode-cn.com/submissions/detail/7965552/
 * 
 * LeetCode
 */
public class Test86 {
	
	public static void main(String[] args) {
		Test86 test86 = new Test86();
		int res = test86.compareVersion("1.2", "1.10");
		System.out.println(res);
	}

    public int compareVersion(String version1, String version2) {
        //拆分"." 进行比较
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        
        for(int i=0; i<arr1.length; i++) {
            if (i>=arr2.length) {
            	if(Integer.parseInt(arr1[i]) > 0) return 1;  //1.0 1比较
            	else if (i == arr1.length-1) {
            		return 0;
            	} else {
            	    continue;
            	}
            }
            int num1 = Integer.parseInt(arr1[i]);
            int num2 = Integer.parseInt(arr2[i]);
            
            if(num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
         
        if (arr1.length == arr2.length)  return 0;
        
        int convert = compareVersion(version2, version1);
        if(convert == 1) return -1;
        if(convert == 0) return 0;
        return 1;
     }
}

class LeetCode_Test86 {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int len = Math.max(v1.length, v2.length); //Nice_Core; 对最长的数组进行遍历, 只需要给短的数组默认值就可以比较了
		int l1, l2;
		for (int i=0; i<len; i++) {
			l1 = 0;
			l2 = 0;
			if (i <v1.length) l1 = Integer.valueOf(v1[i]);
			if (i <v2.length) l2 = Integer.valueOf(v2[i]);
			
			if (l1 > l2) return 1;
			if (l1 < l2) return -1;
		}
		
		return 0;
	}
}























