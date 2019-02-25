package com.zoran.leetcode.simple6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ������������
 * https://leetcode-cn.com/submissions/detail/13307825/
 *
 * [Nice_Solution]
 * https://leetcode-cn.com/submissions/detail/13307825/
 */
public class Test224 {

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        int param_1 = obj.ping(1);
        System.out.println(param_1);

         param_1 = obj.ping(100);
        System.out.println(param_1);

         param_1 = obj.ping(3001);
        System.out.println(param_1);

         param_1 = obj.ping(3002);
        System.out.println(param_1);
    }

    static class RecentCounter {
        //ʹ��һ��ArrayList ˳��洢
        List<Integer> list;

        public RecentCounter() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            int res = 1;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) + 3000 >= t)
                    res++;
                else
                    break;
            }
            list.add(t);

            return res;
        }
    }
}


class LeetCode_Test224 {
    class RecentCounter {
        Queue<Integer> q;
        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.add(t);
            //Nice_Core ����ʱ����˳��ģ�
            // ���Զ�ǰ��ʱ�䲻���������Ľ����޳�!!
            while (q.peek()+3000 < t) {
                q.poll();
            }
            return q.size();
        }

    }
}
