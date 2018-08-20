package com.zoran.leetcode.simple5;

/**
 * 柠檬水找零
 * https://leetcode-cn.com/submissions/detail/5796653/
 */
public class Test197 {

    public boolean lemonadeChange(int[] bills) {
        int[] nums = new int[3]; //5,10,20
        for(int i =0; i< bills.length; i++) {
            if(bills[i] == 5) {
                nums[0] += 1;
            } else if (bills[i] == 10) {
                if(nums[0] > 0) {
                    nums[1] += 1;
                    nums[0] -= 1;
                } else {
                    return false;
                }
            } else {
                if(nums[1]>0 && nums[0]>0) {
                    nums[2] += 1;
                    nums[1] -= 1;
                    nums[0] -= 1;
                } else if(nums[0] >= 3) {
                    nums[2] += 1;
                    nums[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    //用switch case 代码更易阅读
    public boolean LeetCode_lemonadeChange(int[] bills) {
        int a=0;
        int b=0;
        for(int i=0;i<bills.length;i++) {
            switch (bills[i]) {
                case 5:
                    a++;
                    break;
                case 10:
                    a--;
                    b++;
                    break;
                case 20:
                    if(b>0) {
                        b--;
                        a--;
                    }else {
                        a=a-3;
                    }
                    break;
            }
            if(a<0||b<0) return false;
        }
        
        return true;
        
    }
}
