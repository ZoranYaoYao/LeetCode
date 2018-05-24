package com.zoran.leetcode;
/**
 * x ��ƽ����
 * https://leetcode-cn.com/submissions/detail/2564411/
 */
public class Test15 {
	public static void main(String[] args) {
		//ʵ�� int sqrt(int x) ������
		//System.out.println(mySqrt2(2147395600));
		System.out.println(mySqrt3(8)); //��ʱ
	}
	
	
	public static int mySqrt3(int x) {
		if (x ==1) {
			return 1;
		} else if(x == 0) {
			return 0;
		}
		
		int left = 0; int right =x;
		int middle = 0;
		//��0��ʼ�Ա�
		while(left <= right) {  //�۰����,�������е�����, ���Ե���������߽�ʱ,ҲҪ���жԱ� ,����Ҫ�еȺ�,�� left <= right
			middle = (left + right)/2;
			if(x/middle > middle) {   //core, int������˻�������. , �ó�����ʽ�Ա�
				left = middle + 1;
			} else if(x/middle < middle) {
				right = middle -1;
			}else {
				return middle;
			}
		}
		
		//û�в��ҵ���ȵ���
		if(middle * middle > x) {
			return middle = middle -1;
		} 
		
		return middle;
		
	}

	//fail  �۰����
	public static int mySqrt2(int x) {
		if (x ==1) {
			return 1;
		}

		//�۰�Ԫ�ظ���, 
		int lenght = String.valueOf(x).length();
		int startNum = (int) Math.pow(10, (lenght/2-1));
		int resultSqr = startNum * startNum;

		while(resultSqr > x) {
			startNum--;
			resultSqr = startNum * startNum;
		}
		
		//���
		for(startNum = startNum +1; startNum*startNum < x; startNum++) {
			if (startNum*startNum > x) {
				break;
			}
		}
		
		//��һ����
		if (startNum*startNum == x) {
			return startNum;
		}else {
			return startNum -1;
		}


	}

	//fail  �۰�����,middle*middle Խ������ -> �ó��� !
	public static int mySqrt(int x) {
		if (x ==1) {
			return 1;
		}

		//�۰�Ԫ�ظ���, 
		int middle = x/2;

		/***/
		//int middleSqr = middle*middle;  //zqs. int,longԽ��
		while (middle*middle < 0) {
			middle = middle/2;
		}
		int middleSqr = middle*middle;
		/***/

		while(middleSqr > x) {
			middle = middle/2;
			middleSqr =middle*middle;
		}

		//�۰�֮��,�����
		for(int i = middle +1; middle < x; i++) {
			if (i*i <= x) {
				middle = i;
			} else {
				break;
			}
		}

		return middle;
	}
}
