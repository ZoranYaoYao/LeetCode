package com.zoran.leetcode;

import java.util.HashMap;
import java.util.Map;

import sun.tools.jar.resources.jar;

/**
 * ������Ʊ�����ʱ��
 * https://leetcode-cn.com/submissions/detail/2878623/
 */
public class Test29 {


	//	����: [7,1,5,3,6,4]
	//	���: 5
	//	����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
	//	ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�\

	public static void main(String[] args) {
		//int[] prices = new int[] {7,1,5,3,6,4};
		//int[] prices = new int[] {7,6,4,3,1};
		//int[] prices = new int[] {2,4,1};
		int[] prices = new int[] {2,4,1,2};
		System.out.println(Nice_maxProfit(prices));
	}

	//����: �������һ���� ����Сֵ ��ʼ��
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length ==0) return 0;

		int minPrice =prices[0]; int maxPrice = prices[0];
		int minIndex = 0;int maxIndex = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > maxPrice) {
				maxPrice = prices[i];
				maxIndex = i;
			} else if (prices[i] < minPrice) {
				minPrice = prices[i];
				minIndex = i;
			}
		}

		if(minIndex < maxIndex) {
			return maxPrice - minPrice;
		} else if(minIndex == maxIndex) {
			return 0;
		} else if (minIndex > maxIndex) {
			int tmp = minPrice;
			for(int j = minIndex; j < prices.length; j++) {
				if(prices[j] > tmp) {
					maxPrice = prices[j];
					maxIndex = j;
					tmp = maxPrice;
				}
			}

			if (maxIndex > minIndex) return maxPrice - minPrice;
		}

		return 0;
	}

	// ��ٷ� �ҵ�2������С��ֵ
	public static int maxProfit_2(int[] prices) {
		if (prices == null || prices.length ==0) return 0;

		int max = 0;

		for(int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				int tmp = prices[j] - prices[i];
				if( tmp > max) {
					max = tmp;
				}
			}
		}
		
		return max;
	}
	
	//	case:	int[] prices = new int[] {2,4,1,2};  //��Сֵ,��һ��������������
	/**
	 * nice�ط�: ��Сֵ���滻�ط�, ��������и�С��ֵ, ��ô��Сֵ�ض����滻
	 * 			  ��Ϊ������������� ���� ��������ֵ,ǰȥǰ�����Сֵ!
	 */
    public static int Nice_maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else{
                if(profit<prices[i]-min){
                    profit = prices[i]-min; // ��ȡ����ǰ�ڵ�, ��������жԱ�, �������,�����
                }
            }
        }
        return profit;
    }
}
