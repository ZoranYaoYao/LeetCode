package com.zoran.leetcode.medium5;

/**
 * 出界的路径数
 * https://leetcode-cn.com/submissions/detail/11935267/
 */
public class Test230 {
    public static void main(String[] args) {
        Test230 test230 = new Test230();
//        2
//        2
//        2
//        0
//        0
        int res = test230.findPaths(2,2,2,0,0);
        System.out.println(res);
    }

    /**
     * 80 / 94 个通过测试用例
     * 状态：超出时间限制
     */
    public int findPaths(int m, int n, int N, int i, int j) {
        //递归查找
        int res = 0;
        if (i<0 || j<0 || i>=m || j>=n) {
//            System.out.println("N=" + N +", i=" + i + ", j=" + j); //CCore. 打印出满足条件的问题
            return 1;
        }
        if (N <= 0) return 0;


        res += findPaths(m,n,N-1,i-1,j);
        res += findPaths(m,n,N-1,i+1,j);
        res += findPaths(m,n,N-1,i,j-1);
        res += findPaths(m,n,N-1,i,j+1);

        return res;
    }
}
