package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.Interval;

/**
 * �ϲ�����
 * https://leetcode-cn.com/submissions/detail/6568517/
 * 
 * [Solution]
 * https://www.cnblogs.com/simplepaul/p/6666489.html
 * https://www.cnblogs.com/jimmycheng/p/7215622.html
 */
public class Test30 {
	
	public static void main(String[] args) {
		Test30 test30 = new Test30();
		List<Interval> list = new ArrayList<>();
		Interval interval1 = new Interval(1, 4); list.add(interval1);
		Interval interval2 = new Interval(2, 3); list.add(interval2);
		
		System.out.println(test30.merge(list));
	}

    public List<Interval> merge(List<Interval> intervals) {
        //���������, ���кϲ�
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return result;
        
        for(Interval item: intervals) {
            boolean merge = false;
            for(int i=0; i< result.size(); i++) {
                if(item.start>=result.get(i).start && item.start<=result.get(i).end && item.end >= result.get(i).end) {
                    int newStart = result.get(i).start; int newEnd = item.end;
                    result.get(i).start = newStart;
                    result.get(i).end = newEnd;
                    merge = true;
                    break;
                } else if (item.start<=result.get(i).start && item.end >= result.get(i).start) {
                    int newStart = item.start; int newEnd = Math.max(item.end, result.get(i).end);
                    result.get(i).start = newStart;
                    result.get(i).end = newEnd;
                    merge = true;
                    break;
                } else if(result.get(i).start<=item.start && result.get(i).end>=item.end) { //��©case, ���������
                	merge =true;
                	break;
                }
            }
            
            if(!merge) result.add(item);
        }
        
        //[[2,3],[4,5],[6,7],[8,9],[1,10]]  ���һ��, �Ա���ǰ����
        //[[2,3],[4,6],[5,7],[3,4]] ��������
        for(int i=0; i<result.size(); i++) {
        	for(int j=i+1; j<result.size(); j++) {
        		if(result.get(i).start<=result.get(j).start && result.get(i).end>=result.get(j).end) {
        			result.remove(result.get(j));
                    j--;
        		} else if (result.get(i).end >= result.get(j).start) {
                    //������!!! 
                }
        	}
        }
        return result;
    }
}

class Nice_Test30 {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return res;
        
        //Core!!  ����start �������� Ĭ������ ��Ȼ����: ��С����
        Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
        
        Interval temp = intervals.get(0);
        
        if(intervals.size() == 1) {
        	res.add(temp); 
        	return res;
        }
        
        for (int i=1; i<intervals.size(); i++) {
        	if (temp.end >= intervals.get(i).start) {
        		temp.end = Math.max(temp.end, intervals.get(i).end);
        	} else {
        		res.add(temp); //CCore. ��ӵ���һ��Ԫ��
        		temp = intervals.get(i); //Core. �Ƚϵ�Ԫ�ؽ��иı�
        	}
        }
        
        //add the lase temp into list
        //��һ����:
        res.add(temp);
        
        return res;
	}
	
	/**
	 * ������Ԫ�ز�һ����
	 */
    public List<Interval> LeetCode_merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if(intervals.size() == 0 || intervals == null) return res;
        
    	
    	Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
    	
    	Interval out = null;
    	for (Interval i : intervals) {
			if(out == null || i.start > out.end){ //Core. ��һ��Ԫ������ ==null ʱ ��������ж�
				res.add(i);
				out = i;
			}else{
				out.end = out.end < i.end ? i.end : out.end;
			}
		}
        
        return res;
    }
	
	
}





























