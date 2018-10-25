package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ���˵�����
 * https://leetcode-cn.com/submissions/detail/8654274/
 * 
 * LeetCode: �����õ�next()������ֵ, ���Ƕ�����һ������ȥ�����ϴε�����ֵ
 */
public class Test116 {

	class PeekingIterator implements Iterator<Integer> {
	    //����ջ�ṹ�ĵ�����
	    List<Integer> list = new ArrayList<>();
	    int curIndex = 0;
	    
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		    while (iterator.hasNext()) {
	            list.add(iterator.next());
	        }
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        return list.get(curIndex);
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    return list.get(curIndex++);
		}

		@Override
		public boolean hasNext() {
		    return curIndex < list.size();
		}
}
