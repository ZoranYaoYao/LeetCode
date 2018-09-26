package com.zoran.leetcode.medium2;

/**
 * ����վ
 * https://leetcode-cn.com/submissions/detail/7572348/
 * 
 * [Solution]
 * http://www.cnblogs.com/liuliu5151/p/9206898.html
 * 
 * ���ľ���һ��������δ�ͷѭ��
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
        //��ٱ���,ÿ������վ��ʼ,�Ƿ��ܵõ����
        for(int i=0; i<gas.length; i++) {
            int total =0;
            boolean flag = true;;
            for(int j=i, k=0; k<cost.length; k++) {
                total += gas[j%cost.length];
                System.out.println("total = "+total + ", cost=" + cost[j%cost.length]);
                if(total <= cost[j%cost.length] && k<cost.length-1) { //Core. ��ǰ��������С�ڵ��ڻ�����,  ��˼����˵:�м����ʱ,����total<=0
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
