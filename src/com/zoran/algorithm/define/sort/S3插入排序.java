package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://baike.baidu.com/item/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F/7214992?fr=aladdin
 */
public class S3�������� {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 12, 11};
//        Zqs_insertSort(nums);
        insertSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * �㷨�������������ݵ�����, �Ѿ������˳�������
     */
    private static void Zqs_insertSort(int[] nums) {
        //��0��ʼ�����α��һ�����������
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    moveToBack(nums, j, i - 1);
                    nums[j] = temp;
                    System.out.println("i=" + i + ", j=" + j + ", nums = " + Arrays.toString(nums));
                    break;
                }
            }
        }
    }
    /**
     * @param nums  ԭʼ����
     * @param start ��ʼ�����ƶ�һ�����ʼλ��
     * @param end   �ƶ�һ���ĩβλ��
     */
    private static void moveToBack(int[] nums, int start, int end) {
        for (int i = end; i >= start; i--) {
            nums[i + 1] = nums[i];
        }
    }

    /**
     * ��׼�Ĳ������� ��С����
     * refer : https://www.cnblogs.com/onepixel/articles/7674659.html#undefined
     *
     * ʱ�临�Ӷȣ�O(n2)
     */
    private static int[] insertSort2(int[] arr) {
        //1.����Ǵ�������α�
        //2. ÿ�β��붼�ǴӺ���ǰ��
        //ð������ı���ģʽ
        int len = arr.length;
        int preIndex, current;

        for (int i = 1; i < arr.length; i++) {
            preIndex = i-1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
        return arr;
    }


}
