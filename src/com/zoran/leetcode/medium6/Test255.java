package com.zoran.leetcode.medium6;

import java.util.ArrayList;
import java.util.List;

/**
 * ��󽻻�
 * https://leetcode-cn.com/submissions/detail/12287805/
 *
 * ��ѧ����
 * Core, ����Ӧ���ǵ��滻��ֵ ����Ҫ���滻λ�õ�ֵ�����滻
 */
public class Test255 {

    public int maximumSwap(int num) {
        //�����������б�ǰ���ģ��򽻻�������
        List<Integer> list = new ArrayList<>();
        while(num > 0) {
            int tmp = num % 10;
            list.add(0,tmp);
            num = num /10;
        }

        for (int i=0; i<list.size();i++) {
            int swpIndex = i;
            int swpValue = list.get(i);
            for (int j=i+1; j<list.size();j++) {
                if (swpValue <= list.get(j)) {
                    swpIndex = j;
                    swpValue = list.get(j);
                }
            }

            //Core, ����Ӧ���ǵ��滻��ֵ ����Ҫ���滻λ�õ�ֵ�����滻
//            if (swpIndex != i && swpValue != list.get(i)) {
              if (swpValue > list.get(i)) {
                int temp = list.get(i);
                list.set(i, swpValue);
                list.set(swpIndex, temp);
                break;
            }
        }

        int res = 0;
        for (Integer item : list) {
            res = res * 10 + item;
        }

        return res;
    }
}
