package com.zoran.leetcode.simple6;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * ���Ʒ���
 * https://leetcode-cn.com/submissions/detail/13145951/
 *
 * [Solution]
 * ttps://blog.csdn.net/MachineRandy/article/details/83510619
 *
 * ��һ�����������Լ���ķ�������
 */
public class Test219 {

    public static void main(String[] args) {
        Test219 test219 = new Test219();
        int[] nums ={0,0,0,0,0,0,0,0,0,1,1,1,2,2,2,3,3,3};
        boolean res = test219.hasGroupsSizeX(nums);
        System.out.println(res);
    }


    /**
     * 61 / 69 ��ͨ����������
     * ״̬��������
     */
    public boolean hasGroupsSizeX(int[] deck) {
        //HashMap ��¼���������з���
        if (deck.length == 1) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int lastValue = -1;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) return false;
            if (lastValue == -1) {
                lastValue = item.getValue();
                continue;
            }

            int curValue = item.getValue();
            if (curValue%2 == 0 && lastValue%2==0) {
                continue;
            } else if (lastValue%2 != curValue%2){
                //һ��һż
                if (lastValue%2 == 1) {
                    if (curValue%lastValue != 0) return false;
                } else {
                    return false;
                }
            } else {
                //2��
                if (curValue<lastValue) {
                    int temp = curValue;
                    curValue = lastValue;
                    lastValue = temp;
                }

                if (curValue%lastValue != 0) return false;
            }
        }

        return true;

    }
}

class Nice_Test219 {
    public boolean hasGroupSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck)
            map.put(i, map.getOrDefault(i,0)+1);
        int minSize = Integer.MAX_VALUE;
        for (int i : map.values())
            minSize = Math.min(minSize, i);
        int i = 2;

        /**Nice_Core. ��һ�����������Լ���ķ�������*/
        while (i<=minSize) {
            boolean sign = true;
            for (int x : map.values()) {
                if (x % i != 0) {
                    sign = false;
                    break;
                }
            }

            if (sign) return true;
            i++;
        }

        return false;
    }

}
