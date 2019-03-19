package com.zoran.leetcode.medium6;

/**
 * ��������������
 * https://leetcode-cn.com/submissions/detail/15011207/
 *
 * [Solution]
 * https://blog.csdn.net/jackzhang_123/article/details/78894361
 *
 * �ұ任���� Ȼ�� ת���code
 */
public class Test276 {


}

class Nice_Test276 {

    public static void main(String[] args) {
        Nice_Test276 nice_test276 = new Nice_Test276();
        int res = nice_test276.monotoneIncreasingDigits(120);
        System.out.println(res);
    }

    public int monotoneIncreasingDigits(int N) {
        String str = "" + N;
        char[] num = str.toCharArray();
        int begin = num.length;
        for (int i=num.length-1; i>=1; i--) {
            if (num[i] >= num[i-1])
                continue;

            num[i-1]--;
            begin = i;
        }

        //Core. ��¼����������ͬʱ����¼��ǰλ����Ҫ���'9'�����ֵ����
        for (int i = begin; i<num.length; i++) {
            num[i] = '9';
        }

        return Integer.valueOf(new String(num));

    }
}

