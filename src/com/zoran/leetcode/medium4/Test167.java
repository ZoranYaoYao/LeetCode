package com.zoran.leetcode.medium4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��������ؽ�����
 * https://leetcode-cn.com/submissions/detail/10454415/
 *
 * [Solution]
 * https://www.jianshu.com/p/3eee89a6417a
 */
public class Test167 {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return new int[0][0];

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0]-a[0])); //Core. ���� ��ͬʱ�Ƚ�a[1]ֵ
        List<int[]> queue = new ArrayList<>();
        for(int[] p : people) {
            queue.add(p[1], p); //Nice_Core. ���벻Ӱ��ԭʼ���е�a[1]ֵ
        }
        return queue.toArray(new int[queue.size()][]); //ת��2λ����
    }
}
