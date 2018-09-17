package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * ��ת���� II
 * https://leetcode-cn.com/submissions/detail/7189160/
 * 
 * [Solution]
 * https://blog.csdn.net/xygy8860/article/details/47074087
 * 
 * ���б� ��Ҫ��һЩ���������λ��
 */
public class Test51 {

}

class Nice_Test51 {
	//����������ת ʵ�ַ�ת
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode first = new ListNode(0);
		//ͷ���,����ͳһ����
		first.next = head;
		
		ListNode temp = null;
		ListNode p = null;
		ListNode pHead = first; //����Ҫ��ת�����һ���ڵ�  //Core. ��¼λ��
		ListNode pLast = null; //��Ҫ��ת�ڵ�ĵ�һ���ڵ�, ����ת����� //Core. ��¼λ��
		
		int len =0;
		while (head != null) {
			if (++len < m) {
				pHead = head; //��¼δ�䶯�Ľڵ�ĩλֵ, ��������1
				head = head.next;
			} else if (len == m) {
				//��¼��ʼλ��
				p = pLast = head;
				head = head.next;
				pLast.next = null; // �˾����Ҫ, ն��֮�������
			} else if (len>=m && len<=n) {
				//�²���ڵ�
				temp = head;
				head = head.next;
				temp.next = p;
				pHead.next = p;
			} else if (len>n) {
				pLast.next = head;
				break;
			}
		}
		
		return first.next;
	}
}
