package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.swing.event.ListSelectionEvent;

/**
 * ����ܺ� II
 * https://leetcode-cn.com/submissions/detail/6320528/
 * 
 * get: �����ж��Ƿ���� list.equals() �� Set.equals()����
 * 
 * �ѵ�:���ȥ��List�е��ظ���
   ArrayList<Integer> Դ��
	    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof List))
            return false;

        ListIterator<E> e1 = listIterator();
        ListIterator<?> e2 = ((List<?>) o).listIterator();
        while (e1.hasNext() && e2.hasNext()) {  
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1==null ? o2==null : o1.equals(o2))) //�Ƚϵ�ʱÿһ�������equals()����: 1.������� 2.ÿ�������еĶ���equals���
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }
 * [Solution]
 * lists.contain(list) return;
 */
public class Test21 {
	
	public static void main(String[] args) {
		Test21 test21 = new Test21();
		int[] nums = {4,1,1,4,4,4,4,2,3,5};
		System.out.println(test21.combinationSum2(nums, 10));
	}

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //�л���ѡ���Ч��, �����㷨
        List<List<Integer>> list = new ArrayList<>();
        if ((candidates == null && candidates.length ==0) || target<0) return list;
        Arrays.sort(candidates);
        backTrace(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
    
    public void backTrace(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int startIndex) {
        if(remain < 0) return;
        else if (remain == 0) {
        	boolean repeat = false;
        	//Core. ���ȥ���ظ��� -> ���ʱ, �Ա�ÿһ��ȥ��
        	for(int i=0; i<list.size();i++) {
        		if(list.get(i).size() == tempList.size()) {
        			for(int j=0; j< list.get(i).size(); j++) {
        				if(list.get(i).get(j) != tempList.get(j))  break;
        				if(j == list.get(i).size()-1) repeat =true;
        			}
        		}
        		if(repeat) break;
        	}
        	if(!repeat) list.add(new ArrayList(tempList));
        }
        else {
            for(int i = startIndex; i<candidates.length; i++) {
                tempList.add(candidates[i]);
                backTrace(list, tempList, candidates, remain-candidates[i], i+1); //Core. iλ�õ�ֵ�����ظ�;
                tempList.remove(tempList.size()-1); //Core. ����
            }
        }
    }
}

class Nice_Test21 {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
		System.out.println(list1.equals(list2));
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> listRom = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return listRom;
		
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		
		combinationSum2(candidates, listRom, list, 0, target);
		return listRom;
	}

	private static void combinationSum2(int[] candidates, List<List<Integer>> listRom, List<Integer> list, int index,
			int target) {
		//������ݵ���ֹ����
		if (target <0) return;
		else if(target ==0) {
			//Ҫ���ǳ���
			if(listRom.contains(list)) return;
			listRom.add(new ArrayList<>(list));
		} else {
			for (int i= index; i<candidates.length; i++) {
				list.add(candidates[i]);
				combinationSum2(candidates, listRom, list, i+1, target-candidates[i]);
				list.remove(list.size()-1);
			}
		}
		
	}
	
	
	
}
