package com.zoran.algorithm.define.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://blog.csdn.net/developer1024/article/details/79770240
 * https://www.cnblogs.com/zer0Black/p/6169858.html Ͱ������Ϊ(max-min)/arr.length+1
 *
 * ʱ�临�Ӷȣ�O��n+k��
 * �ռ临�Ӷȣ�O(n * k)
 *
 * ���ε�˼��
 */
public class S9Ͱ���� {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 1000};
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * ����Ƕ���б�
     * @param arr ԭʼ����
     */
    private static void bucketSort(int[] arr) {
        int k = (int) Math.ceil(Math.sqrt(arr.length)); //Core ���ٸ�Ͱ
        int max = Integer.MIN_VALUE; //Nice_Core. �ҵ����ֵ�������ֵ���з�ÿ��Ͱ�ķ�Χ
        for (int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        //1.����Ͱ����
        ArrayList<Integer>[] bucket = new ArrayList[k];
        for(int i=0; i<k; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        //2.��ÿ��ֵ�����Ӧ��Ͱ
        for(int i=0; i<arr.length; i++) {
            int index = arr[i] / max * (k-1) ; //NNice_Core ӳ�亯��һ���� f = array[i] / k; k^2 = n; n������Ԫ�ظ���
            bucket[index].add(arr[i]);
        }

        //3.ÿ��Ͱ��������, Ȼ����зǿ�Ͱ��ֵ
        int start = 0;
        for (int i=0; i<bucket.length; i++) {
            Collections.sort(bucket[i]); //Core. �ڲ�����
            for (int j=0;j<bucket[i].size(); j++) {
                arr[start++] = bucket[i].get(j);
            }
        }
    }
}
