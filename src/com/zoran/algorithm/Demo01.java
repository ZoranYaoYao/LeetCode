package com.zoran.algorithm;

//���־�����, Լɪ������
public class Demo01 {

	public static void main(String[] args) {
		Child child = new Child(1);  
		Child child2 = new Child(2); child.next = child2;
		Child child3 = new Child(3); child2.next = child3;
		Child child4 = new Child(4); child3.next = child4;
		Child child5 = new Child(5); child4.next = child5; child5.next = child;

		Child tmp = getfinalChild(child,3);
		System.out.println("���һ������" + tmp.val);
	}

	public static Child getfinalChild(Child head,int num) {
		Child pre = head;
		Child iterator = head;
		int count = 0;
		while (iterator != null) {
			count++;
			iterator = iterator.next;
			if(iterator == head) break;
		}

		int tmp = 0;
		while(count != 1) { 
			tmp++;
			if(tmp == num) {
				pre.next = iterator.next;  //core : �Ƴ�ȥ,�Ͳ���������
				pre = iterator.next;
				count--;
				tmp = 0;
			} else {
//				pre.next = iterator; //�����: �����next ָ���Լ�,�Լ��γɻ�!!
				pre = iterator;
			}

			iterator = iterator.next;
		}
		
		return iterator;
	}

	static class Child {
		int val;
		Child next;
		Child(int x) { val = x; }
	}
}
