package com.zoran.leetcode.medium6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 找到 K 个最接近的元素
 * https://leetcode-cn.com/submissions/detail/12250434/
 *
 * [Solution]
 * https://blog.csdn.net/qq_41864967/article/details/84926141
 * 没有用2分法查找
 *
 * [Nice_Solution]
 * https://leetcode-cn.com/submissions/detail/12250434/
 *
 * 经典的二分查找问题！！
 */
public class Test251 {
    public static void main(String[] args) {
        Test251 test251 = new Test251();
        int[] nums = {0, 1, 1, 1, 2, 3, 6, 7, 8, 9};
        int k = 9;
        int x = 4;
        List<Integer> res = test251.findClosestElements(nums, k, x);
        System.out.println(res);
    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //找到最近的点进行扩散，先选左侧点
        List<Integer> res = new ArrayList<>();
        int mid = findMid(arr, x);
        int count = 0;
        if (count < k) {
            res.add(arr[mid]);
            count++;
        }
        int curRight = mid + 1, curLeft = mid - 1;
        while (count < k) {
            int leftDiff = Integer.MAX_VALUE, rightDiff = Integer.MAX_VALUE;
            if (curLeft >= 0)
                leftDiff = Math.abs(x - arr[curLeft]);
            if (curRight < arr.length)
                rightDiff = Math.abs(arr[curRight] - x);
            res.add(leftDiff <= rightDiff ? arr[curLeft--] : arr[curRight++]);
            count = res.size();
        }
        Collections.sort(res);
        return res;
    }

    private int findMid(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x == arr[mid]) {
                left = mid;
                break;
            } else if (x > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int res = left;
        int diff = Math.abs(arr[left] - x);
        int leftDiff = Integer.MAX_VALUE, rightDiff = Integer.MAX_VALUE;
        if (left + 1 < arr.length)
            rightDiff = Math.abs(arr[left + 1] - x);
        if (left > 0)
            leftDiff = Math.abs(arr[left - 1] - x);

        if (leftDiff <= diff) res = left - 1;
        if (rightDiff < diff) res = left + 1;


        return res;
    }
}

class Leet_Test251 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        //Nice_Core 首位指针范围以k为单位
        int L = 0, R = arr.length - k; //Core rigth,因为找连续k的子数组，所以减去k
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x))
                L = mid + 1;
            else
                R = mid;
        }
        for (int i = L; i < L + k; i++)
            list.add(arr[i]);
        return list;
    }

    public List<Integer> findClosestElements_2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        //Nice_Core 首位指针范围以k为单位
        int L = 0, R = arr.length - 1 - k; //Core rigth,因为找连续k的子数组，所以减去k
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x))
                L = mid + 1;
            else
                R = mid - 1;
        }
        for (int i = L; i < L + k; i++)
            list.add(arr[i]);
        return list;
    }
}
