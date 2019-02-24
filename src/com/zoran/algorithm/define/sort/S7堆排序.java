package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * https://www.cnblogs.com/0zcl/p/6737944.html
 *
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 *
 * <p>
 * 堆排序（英语：Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆是一个近似完全二叉树的结构，
 * 并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 原理：
 * 利用的大顶堆的特性，每个节点都大于或等于他的子结点。 然后结合数组索引 i >= 2i+1 i>=2i+2的特性保持大顶堆
 */
public class S7堆排序 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 10};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void heapSort(int[] arr) {
        //1. 构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            //NNice_Core.将堆顶元素与末尾元素进行交换, 相当于末尾值就是最大的值！！
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            //Nice_Core 交换位置之后，需要调整索引0值，保证调整后也是大顶堆
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * @param arr    元素数据
     * @param i      i位置生成大顶堆
     * @param length 变化长度
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; //先取出当前元素i
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) { //从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) { //如果左子结点小于右子结点，k指向右子结点
                k++;
            }

            if (arr[k] > temp) { //如果子节点大于父节点，将子节点赋值给父节点(不用进行交换)
                arr[i] = arr[k];
                i = k; //Nice_Core 用i来记录需要交换的位置。
            } else {
                break;
            }
        }
        arr[i] = temp; //将temp值放到最终的位置
    }
}
