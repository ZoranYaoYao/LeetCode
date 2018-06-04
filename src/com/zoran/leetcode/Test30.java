package com.zoran.leetcode;

/**
 * ������Ʊ�����ʱ�� II
 * https://leetcode-cn.com/submissions/detail/2898441/
 */
public class Test30 {
	//	����: [7,1,5,3,6,4]
	//	���: 7
	//	����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
	//	����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6-3 = 3 ��
	//	ʾ�� 2:
	//	����: [1,2,3,4,5]
	//	���: 4
	//	����: �ڵ� 1 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �� ����Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
	//	ע���㲻���ڵ� 1 ��͵� 2 ����������Ʊ��֮���ٽ�����������
	//	��Ϊ��������ͬʱ�����˶�ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ��
	//	ʾ�� 3:
	//	����: [7,6,4,3,1]
	//	���: 0
	//	����: �����������, û�н������, �����������Ϊ 0��

	public static void main(String[] args) {
		//int[] prices = new int[] {7,1,5,3,6,4};
		int[] prices = new int[] {1,2,3,4,5};
		System.out.println(Nice_maxProfit(prices));
	}

	/**
	 *  �㷨: 
	 *  1. �����һλ����ǰһλ, ��ֱ�ӵ�����һλ���м���
	 *  2. ���ǰһλ���ں�һλ, �����ǰ�������
	 *  
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length ==0) return 0;

		int profit = 0;int startIndex = 0;int endIndex = 0;
		for (int i = 0; i < prices.length; i++) {
			if(i == prices.length - 1) {
				if (prices[startIndex] < prices[i]) profit += prices[i] - prices[startIndex];
				continue;
			}

			if(prices[i] < prices[i+1]) {
				endIndex = i;
			} else if (prices[i] > prices[i+1]) {
				//������һ��
				endIndex = i;
				profit += prices[endIndex] - prices[startIndex];
				startIndex = endIndex + 1;
			}
		}

		return profit;
	}

	/**
	 *  ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
	 *  core: ����֮��, ������һֻ��Ʊ
	 */
	public static int Nice_maxProfit(int[] prices) {
		int totalSum = 0;
		for(int i=1;i<prices.length;i++){
			if(prices[i] > prices[i-1]){  //��Ϊ�����������, ���ֵ�ǵ�����,2�����������ܺ;���(��һ���� - ǰһ����)
				totalSum += prices[i] - prices[i-1];
			}
		}

		return totalSum;
	}
}
