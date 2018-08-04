package com.zoran.leetcode.simple5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * 员工的重要性
 * https://leetcode-cn.com/submissions/detail/5072065/
 * 
 * [Solution]
 * https://blog.csdn.net/u011775905/article/details/79090243
 * 
 * 利用HashMap功能 建立一个快速索引映射关系, 方便查找值
 */
public class Test155 {
	
	/**
	 * 超时 
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
					subEmployee.remove((Integer) item.id);  //Core. 遍历总的employees, 删除存在的subEmployee,所以不会存在concurrentModifyException
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
			result +=sum(map.get(i)); //Nice. 递归获取子员工的值的总和!
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