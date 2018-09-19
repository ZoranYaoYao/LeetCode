package com.zoran.leetcode.medium2;

import java.util.HashMap;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * �����������������й��������
 * https://leetcode-cn.com/submissions/detail/7301464/
 * 
 * [Solution]
 * LeetCode rebase!
 * https://blog.csdn.net/wu2304211/article/details/54709205
 * https://blog.csdn.net/okiwilldoit/article/details/78355872
 * 
 *  �������: ��->��->�� �γɵ�����,
 *��ô����������ʱ��, ��Ӧ�� �� -> �� -> ��
 */
public class Test60 {

//    3
//   / \
//  9  20
//    /  \
//   15   7
//	������� inorder = [9,3,15,20,7]
//	������� postorder = [9,(15,7,20),3]
	
	int pIn = 0;

	HashMap<Integer,Integer> map ;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder==null ||  postorder.length == 0 )
			return null;
		pIn = postorder.length -1;
		map = new HashMap<>();
		for(int i=0;i<inorder.length;i++){
			map.put(inorder[i],i);
		}
		return buildTree(inorder,postorder,0,inorder.length-1);

	}

	/**
	 *  inS inE��Ϊ��Χ����
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder, int inS, int inE) {
		if(inS>inE) return null;
		TreeNode node = new TreeNode(postorder[pIn--]);
		if(inS == inE) return node;

		//�������Ĺ�����: �ȹ���root, Ȼ��ݹ鹹��������,Ȼ��ݹ鹹��������
		int index = map.get(node.val);
		node.right = buildTree(inorder,postorder,index+1,inE);
		node.left = buildTree(inorder,postorder,inS,index -1);
		return node;
	}
}
