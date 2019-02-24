package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * https://www.cnblogs.com/0zcl/p/6737944.html
 *
 * ʱ�临�Ӷȣ�O(nlogn)
 * �ռ临�Ӷȣ�O(1)
 *
 * <p>
 * ������Ӣ�Heapsort����ָ���ö��������ݽṹ����Ƶ�һ�������㷨������һ��������ȫ�������Ľṹ��
 * ��ͬʱ����ѻ������ʣ����ӽ��ļ�ֵ����������С�ڣ����ߴ��ڣ����ĸ��ڵ㡣
 *
 * ԭ��
 * ���õĴ󶥶ѵ����ԣ�ÿ���ڵ㶼���ڻ���������ӽ�㡣 Ȼ������������ i >= 2i+1 i>=2i+2�����Ա��ִ󶥶�
 */
public class S7������ {

    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 10};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void heapSort(int[] arr) {
        //1. �����󶥶�
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
        for (int j = arr.length - 1; j > 0; j--) {
            //NNice_Core.���Ѷ�Ԫ����ĩβԪ�ؽ��н���, �൱��ĩβֵ��������ֵ����
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            //Nice_Core ����λ��֮����Ҫ��������0ֵ����֤������Ҳ�Ǵ󶥶�
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * @param arr    Ԫ������
     * @param i      iλ�����ɴ󶥶�
     * @param length �仯����
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; //��ȡ����ǰԪ��i
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) { //��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
            if (k + 1 < length && arr[k] < arr[k + 1]) { //������ӽ��С�����ӽ�㣬kָ�����ӽ��
                k++;
            }

            if (arr[k] > temp) { //����ӽڵ���ڸ��ڵ㣬���ӽڵ㸳ֵ�����ڵ�(���ý��н���)
                arr[i] = arr[k];
                i = k; //Nice_Core ��i����¼��Ҫ������λ�á�
            } else {
                break;
            }
        }
        arr[i] = temp; //��tempֵ�ŵ����յ�λ��
    }
}
