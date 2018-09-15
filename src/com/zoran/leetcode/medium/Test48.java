package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ױ���
 * https://leetcode-cn.com/submissions/detail/7115538/
 * 
 * [Solution]
 * https://www.cnblogs.com/acbingo/p/9427661.html
 * https://blog.csdn.net/wutingyehe/article/details/51155231
 * 
 * ����û������ ʲô�Ǹ��ױ���
 * ���ױ�����һ������������ϵͳ���ڸ�ϵͳ�У�������������ֵ����һ��λ���Ĳ��졣
 */
public class Test48 {

    public List<Integer> grayCode(int n) {
        //1. 0�ʼ
        //2. ���������λ��Ϊn ��ʮ������
        
        int count = (int) Math.pow(2, n);
        int end = 1 << n;
        
        List<Integer> res = new ArrayList<>();
        res.add(0); //Core. 0��ͷ
        for(int i=1; i<count; i++) {
            int temp = end-i;
            res.add(temp);
        }
        
        return res;
    }
}


class LeetCode_Test48 {
	
	public static void main(String[] args) {
		LeetCode_Test48 test48 = new LeetCode_Test48();
		List<Integer> res = test48.grayCode(3);
		System.out.println(res);
	}
	
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
       int len = 1 << n;
       for (int i = 0; i < len; i++) {
           list.add(i ^ (i >> 1)); //Nice. ���
       }
       return list;
   }
}