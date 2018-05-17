package com.zoran.leetcode;

/**
 * 提交记录
 * https://leetcode-cn.com/submissions/detail/2349554/
 */
public class Test10 {

	public static void main(String[] args) {
		System.out.println(countAndSay(8));
		System.out.println("+++++++++++++++++++++++++");
		System.out.println(countAndSay(8));
	}
	
/*	 1.     1
	 2.     11
	 3.     21
	 4.     1211*/
    public static String countAndSay(int n) {
    	if(n <= 0) return "-1";
    	if(n == 1) return "1";
    	
    	String preStr = countAndSay(n-1);
    	int starIndex = 0;boolean hasDouble = false;
    	StringBuilder sb = new StringBuilder();
    	for(int i =0;i < preStr.length();i++) {
    		//处理末尾跟前面不重复数字的情况
    		if((i == preStr.length() -1) && !hasDouble) {
    			sb.append(1).append(preStr.charAt(i));
    			break;
    		}
    		
    		//处理末尾跟前面重复数字的情况
    		if((i == preStr.length() -1)) {
    			sb.append(i - starIndex + 1).append(preStr.charAt(i));
    			break;
    		}
    		
    		if (preStr.charAt(i) == preStr.charAt(i + 1)) {
				if (!hasDouble) {  //记录第一个重复元素的位置
					starIndex = i;
				}
				hasDouble = true;
    			continue;
			} 
    		
    		//处理逻辑
    		if(hasDouble){
	   			sb.append(i - starIndex + 1).append(preStr.charAt(i));
			}else{
				sb.append(1).append(preStr.charAt(i));
			}
			starIndex = i; //重置重复元素的位置
			hasDouble = false;//重置重复元素的标识
    		
    	}
    	
    	System.out.println("n=" + n + "value=" + sb.toString());
        return sb.toString();
    }
    
    //1. 一个int的标识符, 能够标识有值 并且标识个数!
    //    int starIndex = 0;boolean hasDouble = false; =>  int times =1  
    //2. 遍历点的末尾特殊处理, 逻辑互斥
    //    if(i == preStr.length()-1){}else{}
    public static String Zqs_Opt_countAndSay(int n) {
    	if(n <= 0) return "-1";
    	if(n == 1) return "1";

    	String preStr = countAndSay(n-1);
    	int times = 1;
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i < preStr.length();i++) {
    		if(i == preStr.length()-1){
    			
    		}else{
    			if (preStr.charAt(i) == preStr.charAt(i+1)) { 
        			times++;
        			continue;
        		} 
    		}
    		
    		//处理逻辑
    		sb.append(times).append(preStr.charAt(i));
    		times = 1; //重置标识符
    	}

    	//System.out.println("n=" + n + "value=" + sb.toString());
    	return sb.toString();
    }
}
