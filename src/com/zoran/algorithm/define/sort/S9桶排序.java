package com.zoran.algorithm.define.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://blog.csdn.net/developer1024/article/details/79770240
 * https://www.cnblogs.com/zer0Black/p/6169858.html 桶的数量为(max-min)/arr.length+1
 *
 * 时间复杂度：O（n+k）
 * 空间复杂度：O(n * k)
 *
 * 分治的思想
 */
public class S9桶排序 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 1000};
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 数组嵌套列表
     * @param arr 原始数组
     */
    private static void bucketSort(int[] arr) {
        int k = (int) Math.ceil(Math.sqrt(arr.length)); //Core 多少个桶
        int max = Integer.MIN_VALUE; //Nice_Core. 找到最大值，对最大值进行分每个桶的范围
        for (int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        //1.创建桶个数
        ArrayList<Integer>[] bucket = new ArrayList[k];
        for(int i=0; i<k; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        //2.将每个值放入对应的桶
        for(int i=0; i<arr.length; i++) {
            int index = arr[i] / max * (k-1) ; //NNice_Core 映射函数一般是 f = array[i] / k; k^2 = n; n是所有元素个数
            bucket[index].add(arr[i]);
        }

        //3.每个桶进行排序, 然后进行非空桶赋值
        int start = 0;
        for (int i=0; i<bucket.length; i++) {
            Collections.sort(bucket[i]); //Core. 内部排序
            for (int j=0;j<bucket[i].size(); j++) {
                arr[start++] = bucket[i].get(j);
            }
        }
    }
}
