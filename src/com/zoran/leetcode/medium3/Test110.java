package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.List;

/**
 * Ϊ������ʽ������ȼ�
 * https://leetcode-cn.com/submissions/detail/8576500/
 * 
 * [Solution]
 * https://blog.csdn.net/foreverling/article/details/49742089
 * https://www.jianshu.com/p/fd2749518387
 * 
 * �����㷨
 * �ֶ���֮�����������ַ�������������������������Ϊ�����֣��ֱ�ݹ������ֵ��
 * Ȼ����ֵ��������ֵ���Ͻ��н������㣬�����������������У���û�����������ֱ�ӽ��ַ���ת��Ϊ���������������С�
 * ̫ţ��!
 * 
 * vector.push_back() <=> list.add()
 */
public class Test110 {
	
	public static void main(String[] args) {
		Test110 test110 = new Test110();
		List<Integer> res = test110.diffWaysToCompute("2*3-4*5");
		System.out.println(res);
	}

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
//                System.out.println("ch=" + ch);
//                System.out.println("left =" + left);
//                System.out.println("right = " + right);
                for (int n : left) {
                    for (int m : right) {
                        switch (ch) {
                        case '+':
                            res.add(n + m);
                            break;
                        case '-':
                            res.add(n - m);
                            break;

                        case '*':
                            res.add(n * m);
                            break;
                        }
                    }
                }
            }
        }

        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }

        return res;
    }
}

class CTest110 {
//	class Solution {
//		public:
//		    vector<int> diffWaysToCompute(string input) {
//		        vector<int> res;
//		        for (int i = 0; i < input.size(); ++i) {
//		            if (input[i] == '+' || input[i] == '-' || input[i] == '*') {
//		                vector<int> left = diffWaysToCompute(input.substr(0, i));
//		                vector<int> right = diffWaysToCompute(input.substr(i + 1));
//		                for (int j = 0; j < left.size(); ++j) {
//		                    for (int k = 0; k < right.size(); ++k) {
//		                        if (input[i] == '+') res.push_back(left[j] + right[k]);
//		                        else if (input[i] == '-') res.push_back(left[j] - right[k]);
//		                        else res.push_back(left[j] * right[k]);
//		                    }
//		                }
//		            }
//		        }
//		        if (res.empty()) res.push_back(atoi(input.c_str()));   //Core. C++�﷨: vector.push_back() ���� list.add();
//		        return res;
//		    }
//		};

}
