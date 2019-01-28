package com.zoran.leetcode.medium5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Dota2 ����Ժ
 * https://leetcode-cn.com/submissions/detail/12170149/
 *
 * ͨ�����У�����һ�ֱȽ�֮�����N��ΪȨֵ���ֻغͼ�������
 */
public class Test246 {
    public static void main(String[] args) {
        String str = "DRRDRDRDRDDRDRDR";
        Test246 test246 = new Test246();
        String res = test246.predictPartyVictory(str);
        System.out.println(res);
    }

    /**
     * �㷨�� ��ɾ�������ִ��Ȩ�ĶԷ����ˣ���
     */
    public String predictPartyVictory(String senate) {
        //���marked�Ƿ���֣������ķ�ʣ0���������
        char[] chrs = senate.toCharArray();
        boolean[] out = new boolean[chrs.length];
        int rNum = 0, dNum = 0;
//        int curRIndex = senate.indexOf('R');
//        int curDIndex = senate.indexOf('D');
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == 'R') {
                rNum++;
            } else {
                dNum++;
            }
        }
        if (rNum == 0) return "Dire";
        if (dNum == 0) return "Radiant";

        while (true) {
            for (int i = 0; i < chrs.length; i++) {
                if (out[i]) continue;

                if (chrs[i] == 'R') {
                    int curDIndex = senate.indexOf('D', i + 1);
                    while (curDIndex != -1 && out[curDIndex]) {
                        curDIndex = senate.indexOf('D', curDIndex + 1);
                    }
                    if (curDIndex != -1) {
                        out[curDIndex] = true;
                    } else {
                        int index = 0;
                        while (out[senate.indexOf('D', index)]) {
                            index = senate.indexOf('D', index + 1);
                        }
                        out[index] = true;
                    }
                    dNum--;
                } else {
                    int curRIndex = senate.indexOf('R', i + 1);
                    while (curRIndex != -1 && out[curRIndex]) {
                        curRIndex = senate.indexOf('R',  curRIndex+ 1);
                    }
                    if (curRIndex != -1) {
                        out[curRIndex] = true;
                    } else {
                        int index = 0;
                        while(out[senate.indexOf('R', index)]) {
                            index = senate.indexOf('R', index+1);
                        }
                        out[index] = true;
                    }
                    rNum--;
                }
                if (rNum == 0) return "Dire";
                if (dNum == 0) return "Radiant";
            }
        }
    }
}

class Nice_Test246 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> queueD = new LinkedList<>();
        Queue<Integer> queueR = new LinkedList<>();
        int N = senate.length();
        for (int i=0; i<senate.length(); i++) {
            if (senate.charAt(i) == 'D')
                queueD.offer(i);
            else
                queueR.offer(i);
        }

        while (!queueD.isEmpty() && !queueR.isEmpty()) {
            int indexD = queueD.poll();
            int indexR = queueR.poll();
            if (indexD < indexR){
                //NNice_Core ͨ������+N����ʾһ�����ȼ�
                queueD.offer(indexD+N);
            } else {
                queueR.offer(indexR+N);
            }
        }
        return queueD.isEmpty() ? "Radiant" : "Dire";
    }
}
