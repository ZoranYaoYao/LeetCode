package com.zoran.leetcode.medium3;

/**
 * 验证二叉树的前序序列化
 * https://leetcode-cn.com/submissions/detail/8939008/
 * 
 * [Solution]
 * https://blog.csdn.net/LaputaFallen/article/details/80025590
 * 
 *  根据性质, 出度,入度来看关系
 * 验证是否是以个树: if (--diff < 0) return false; 如果<0 , 则不会构成一棵树!! 
 */
public class Test132 {

}

class Nice_Test132 {
	
	public static void main(String[] args) {
		Nice_Test132 test132 = new Nice_Test132();
		boolean res = test132.isValidSerialization("1"); //1不是满二叉树
		System.out.println(res);
	}
	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
		int diff = 1; //Core. diff = 当前遍历节点出度和 - 当前遍历节点入度和
		
		for (String node: nodes) {
			if (--diff < 0) return false;
			if (!node.equals("#")) diff += 2;
		}
		
		return diff == 0;
	}
}
