package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * ��ƽ��Ƕ���б������
 * https://leetcode-cn.com/submissions/detail/9108527/
 * 
 * ������ȱ����㷨
 */
public class Test137 {

	public class NestedIterator implements Iterator<Integer> {

	    //NestedInteger Ƕ�׼���?
		//�ⲿ�ĵ�����ʵ�� ���ʵ��??
	    
	    List<NestedInteger> nestedList;
	    NestedInteger nextNestedInteger;
	    int index = 0;
	    int innerIndex = 0;
	    public NestedIterator(List<NestedInteger> nestedList) {
	        this.nestedList = nestedList;
	        if (nestedList != null) nextNestedInteger = nestedList.get(0);
	    }

	    @Override
	    public Integer next() {
	        int next = 0;
	        if (nextNestedInteger.isInteger()) {
	            next = nextNestedInteger.getInteger();
	            index++;
	            nextNestedInteger = nestedList.get(index);
	        } else {
	            List<NestedInteger> list = nextNestedInteger.getList();
	            if (list.get(innerIndex).isInteger()) {
	            	next = list.get(innerIndex).getInteger();
	            	innerIndex++;
	            } else {
	            	List<NestedInteger> list2 = list.get(innerIndex).getList(); //�����: 3��Ƕ�����ʵ��
	            }
	        }
	        return next;
	    }

	    @Override
	    public boolean hasNext() {
	         return index < nestedList.size();
	    }
	}
}

class Zqs_Test137 {
	public class NestedIterator implements Iterator<Integer> {
	    //�ȱ��������н�� ���뵽�б���,ͳһ����
	    List<Integer> list;
	    int index = 0;
	    public NestedIterator(List<NestedInteger> nestedList) {
	        list = new ArrayList<>();
	        if (nestedList == null || nestedList.size() == 0) return;

	        dfs(nestedList);
	    }
	    
	    private void dfs(List<NestedInteger> nestedList) {
	        
	        for (int i=0; i<nestedList.size(); i++) {
	            if (nestedList.get(i).isInteger()) {
	                list.add(nestedList.get(i).getInteger());
	            } else {
	                dfs(nestedList.get(i).getList());
	            }
	        }
	    }

	    @Override
	    public Integer next() {
	        return list.get(index++);
	    }

	    @Override
	    public boolean hasNext() {
	        return index < list.size();
	    }
	}
}

 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
 interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
