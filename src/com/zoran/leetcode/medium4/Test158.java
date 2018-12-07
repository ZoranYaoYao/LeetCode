package com.zoran.leetcode.medium4;

/**
 * UTF-8 编码验证
 * https://leetcode-cn.com/submissions/detail/10200729/
 *
 * [Solution]
 * https://www.cnblogs.com/grandyang/p/5847597.html
 *
 * 位移大法好
 */
public class Test158 {

    public static void main(String[] args) {
        int[] nums = {197,130,1};
        Test158 test158 = new Test158();
        boolean res = test158.validUtf8(nums);
        System.out.println(res);
    }

    /**
     *  问题：
     *  每个数的范围 也是要对应字节数的：
     *  eg： 145 -》 必须要用2个字节展示。
     *
     *  2. if else 太多
     */
    public boolean validUtf8(int[] data) {
        //遍历数组，依次验证字节规范
        if (data == null || data.length == 0) return true;

        boolean isHead = true;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            String binary = Integer.toBinaryString(data[i]);
            if (binary.compareTo("11110") > 0) return false;  //255 1111 1111

            System.out.println(binary);
            if (isHead) {
                count = binary.indexOf("0");
                if (count == -1) {
                    count = 0;
                    continue;//1的二进制是1
                }
                if (count < 0 || count > 4) return false;
                isHead = false;
                count--;
            } else {
                if (binary.indexOf("0") == 1 && binary.length() == 8) {
                    count--;
                } else return false;

                if (count == 0) {
                    isHead = true;
                }
            }
        }

        return count == 0;
    }


}

class Nice_Test158 {
    boolean validUtf8(int[] data) {
        int cnt = 0;
        for (int d : data) {
            if (cnt == 0) {
                if ((d >> 5) == 0b110) cnt =1;
                else if ((d >> 4) == 0b1110) cnt = 2;
                else if ((d >> 3) == 0b11110) cnt = 3;
                else if ((d>>7) > 0) return false; //Nice_core: 如果大于了127数，则必须是多个字节！！！
            } else {
                if ((d>>6) != 0b10) return false;
                --cnt;
            }
        }

        return cnt == 0;
    }
}




























