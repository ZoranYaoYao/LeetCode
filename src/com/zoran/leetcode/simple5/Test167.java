package com.zoran.leetcode.simple5;

/**
 * 1比特与2比特字符
 * https://leetcode-cn.com/submissions/detail/5310014/
 * 
 * 遍历判断最后一个到底是一个比特, 还是2个比特
 */
public class Test167 {

	   public boolean isOneBitCharacter(int[] bits) {
	        for(int i=0; i<bits.length; i++) {
	            if(bits[i] == 1) {
	                if(i == bits.length -2) return false; //Core. 如果2比特数, 并且出现在倒数第二位, 则必定是一个组合
	                i++;
	            } else if(bits[i] == 0){
	                //其他情况直接 i++
	            }
	        }
	        
	        return true;
	    }
}
