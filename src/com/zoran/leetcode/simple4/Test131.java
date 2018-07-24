package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.Node;

/**
 * N�����ĺ������
 * https://leetcode-cn.com/submissions/detail/4567227/
 */
public class Test131 {

	/**
	 * {"$id":"1",
	 * 	"children":[{"$id":"2",
	 * 				"children":[{"$id":"3","children":[],"val":5},{"$id":"4","children":[],"val":0}],"val":10},
	 * 				{"$id":"5","children":[{"$id":"6","children":[],"val":6}],"val":3}],"val":1}
	 * case�߲�ͨ
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;

		LinkedList<Node> fathers = new LinkedList<>();
		fathers.add(root);
		result.add(0,root.val);

		while(fathers.size() > 0) {
			Node node = fathers.pop();
			List<Node> children = node.children;
			for(int i = 0; i < children.size(); i++) {
				result.add(0,children.get(children.size()-1-i).val);
				fathers.add(0,children.get(i));
			}
		}

		return result;
	}

	/**
	 * Nice��������ʵ��:
	 * �������������м��� -> Ȼ������Ӹ��ڵ� -> ����ѭ��
	 */
	public List<Integer> Nice_postorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;

		List<Node> children = root.children;
		if (children != null && children.size() > 0) {
			for(int i = 0; i < children.size(); i++) {
				result.addAll(postorder(children.get(i))); //Nice: �������,�Ͳ����������˳������
			}
		}
		result.add(root.val); //Nice: ���Լ����ڵ��val
		return result;
	}

	/**
	 * ��������ʵ��:
	 * �����root -> ��������༯�� -> ������༯��-> ѭ��
	 */
    List<Integer> result = new ArrayList<>();
    boolean first = true;
    public List<Integer> Zqs_postorder(Node root) {
        if(root == null) return result;
        if(first) {
           result.add(root.val); 
           first = false;
        }
        
        List<Node> children = root.children;
        for(int i = children.size() - 1; i >= 0; i--) {
            result.add(0, children.get(i).val);
            postorder(children.get(i));
        }
        
        return result;
    }
}
