package com.zoran.leetcode.simple5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Ա������Ҫ��
 * https://leetcode-cn.com/submissions/detail/5072065/
 * 
 * [Solution]
 * https://blog.csdn.net/u011775905/article/details/79090243
 * 
 * ����HashMap���� ����һ����������ӳ���ϵ, �������ֵ
 */
public class Test155 {
	
	/**
	 * ��ʱ 
	 */
	public int getImportance(List<Employee> employees, int id) {
		int result = 0; LinkedList<Integer> subEmployee = new LinkedList<>();
		for(Employee item: employees) {
			if(item.id == id) {
				result += item.importance;
				subEmployee.addAll(item.subordinates);   
				break;
			}
		}

		while (!subEmployee.isEmpty() ) {
			for(Employee item: employees) {
				if(subEmployee.contains(item.id)) {
					result += item.importance;
					subEmployee.remove((Integer) item.id);  //Core. �����ܵ�employees, ɾ�����ڵ�subEmployee,���Բ������concurrentModifyException
					subEmployee.addAll(item.subordinates);  
				}
			}
		}
		return result;
	}

	private Map<Integer, Employee> map;
	public int Nice_getImportance(List<Employee>  employees, int id) {
		map = new HashMap<>();
		for (Employee e: employees) {
			map.put(e.id, e);
		}
		return sum(map.get(id));
	}
	
	private int sum(Employee employee) {
		int result = employee.importance;
		for (Integer i: employee.subordinates) {
			result +=sum(map.get(i)); //Nice. �ݹ��ȡ��Ա����ֵ���ܺ�!
		}
		return result;
	}
}

//Employee info
class Employee {
	// It's the unique id of each node;
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;
};