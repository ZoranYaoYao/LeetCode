package com.zoran.leetcode.medium2;

/**
 * 加油站
 * https://leetcode-cn.com/submissions/detail/7572348/
 * 
 * [Solution]
 * http://www.cnblogs.com/liuliu5151/p/9206898.html
 * 
 * 考的就是一个数组如何从头循环
 */
public class Test72 {
	public static void main(String[] args) {
		Test72 test72 = new Test72();
		int[] gas = {4,5,3,1,4};
		int[] cost = {5,4,3,4,2};
		int res = test72.canCompleteCircuit(gas, cost);
		System.out.println(res);
	}

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //穷举遍历,每个加油站开始,是否能得到结果
        for(int i=0; i<gas.length; i++) {
            int total =0;
            boolean flag = true;;
            for(int j=i, k=0; k<cost.length; k++) {
                total += gas[j%cost.length];
                System.out.println("total = "+total + ", cost=" + cost[j%cost.length]);
                if(total <= cost[j%cost.length] && k<cost.length-1) { //Core. 当前总数不能小于等于话费数,  意思就是说:中间加油时,不能total<=0
                    flag = false;
                    break;
                } else {
                    total -= cost[j%cost.length];
                }
                j++;
            }
            
            if(flag && total>=0) return i;
        }
        
        return -1;
    }
}
