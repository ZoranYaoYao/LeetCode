package com.zoran.leetcode.medium2;

import java.util.HashMap;

/**
 * ʵ�� Trie (ǰ׺��)
 * https://leetcode-cn.com/submissions/detail/8108900/
 * 
 * [Solution]
 * http://www.cnblogs.com/acbingo/p/9391172.html
 * 
 * ��Ҫ���˽�ʲô��ǰ׺��
 */
public class Test94 {

}

class Nice_Tset94 {
	public class Trie {

	    private class Node {
	        private int dumpli_num;////���ִ����ظ���Ŀ��  ������ͳ���ظ�������ʱ������,ȡֵΪ0��1��2��3��4��5����
	        private int prefix_num;///�Ը��ִ�Ϊǰ׺���ִ����� Ӧ�ð������ִ�������������
	        private Node childs[];////�˴�������ʵ�֣���ȻҲ����map��listʵ���Խ�ʡ�ռ�
	        private boolean isLeaf;///�Ƿ�Ϊ���ʽڵ�

	        public Node() {
	            dumpli_num = 0;
	            prefix_num = 0;
	            isLeaf = false;
	            childs = new Node[26];
	        }
	    }


	    private Node root;///����

	    public Trie() {
	        ///��ʼ��trie ��
	        root = new Node();
	    }


	    /**
	     * �����ִ�����ѭ���������ʵ��
	     *
	     * @param words
	     */
	    public void insert(String words) {
	        insert(this.root, words);
	    }

	    /**
	     * �����ִ�����ѭ���������ʵ��
	     *
	     * @param root
	     * @param words
	     */
	    private void insert(Node root, String words) {
	        words = words.toLowerCase();////ת��ΪСд
	        char[] chrs = words.toCharArray();

	        for (int i = 0, length = chrs.length; i < length; i++) {
	            ///�������a��ĸ��ֵ��Ϊ�±�������Ҳ��ʽ�ؼ�¼�˸���ĸ��ֵ
	            int index = chrs[i] - 'a';
	            if (root.childs[index] != null) {
	                ////�Ѿ������ˣ����ӽڵ�prefix_num++
	                root.childs[index].prefix_num++;
	            } else {
	                ///���������
	                root.childs[index] = new Node();
	                root.childs[index].prefix_num++;
	            }

	            ///��������ִ���β���������
	            if (i == length - 1) {
	                root.childs[index].isLeaf = true;
	                root.childs[index].dumpli_num++;
	            }
	            ///rootָ���ӽڵ㣬��������
	            root = root.childs[index];
	        }

	    }

	                                                                                                                                               
	    public HashMap<String, Integer> getAllWords() {
	        return preTraversal(this.root, "");
	    }

	    /**
	     * ǰ�����������
	     *
	     * @param root    �������ڵ�
	     * @param prefixs ��ѯ���ýڵ�ǰ����������ǰ׺
	     * @return
	     */
	    private HashMap<String, Integer> preTraversal(Node root, String prefixs) {
	        HashMap<String, Integer> map = new HashMap<String, Integer>();

	        if (root != null) {

	            if (root.isLeaf == true) {
	                ////��ǰ��Ϊһ������
	                map.put(prefixs, root.dumpli_num);
	            }

	            for (int i = 0, length = root.childs.length; i < length; i++) {
	                if (root.childs[i] != null) {
	                    char ch = (char) (i + 'a');
	                    ////�ݹ����ǰ�����
	                    String tempStr = prefixs + ch;
	                    map.putAll(preTraversal(root.childs[i], tempStr));
	                }
	            }
	        }

	        return map;
	    }

	    /**
	     * ��ѯĳ�ִ��Ƿ����ֵ�����
	     *
	     * @param word
	     * @return true if exists ,otherwise  false
	     */
	    public boolean search(String word) {
	        char[] chs = word.toLowerCase().toCharArray();
	        Node tmpRoot = root;
	        for (int i = 0, length = chs.length; i < length; i++) {
	            int index = chs[i] - 'a';
	            if (tmpRoot.childs[index] == null) {
	                ///��������ڣ������ʧ��
	                return false;
	            }
	            tmpRoot = tmpRoot.childs[index];
	        }

	        // �����к�����
	        return tmpRoot.isLeaf;
	    }

	    public boolean startsWith(String prefix) {
	        char[] chrs = prefix.toLowerCase().toCharArray();
	        Node tmpRoot = root;
	        for (int i = 0, length = chrs.length; i < length; i++) {
	            int index = chrs[i] - 'a';
	            if (tmpRoot.childs[index] == null) {
	                return false;
	            }
	            tmpRoot = tmpRoot.childs[index];
	        }
	        return true;
	    }

	    /**
	     * �õ���ĳ�ִ�Ϊǰ׺���ִ����������ִ����� ���Ƶ������뷨�����빦��
	     *
	     * @param prefix �ִ�ǰ׺
	     * @return �ִ����Լ����ִ���������������򷵻�null
	     */
	    public HashMap<String, Integer> getWordsForPrefix(String prefix) {
	        return getWordsForPrefix(this.root, prefix);
	    }

	    /**
	     * �õ���ĳ�ִ�Ϊǰ׺���ִ����������ִ�����
	     *
	     * @param root
	     * @param prefix
	     * @return �ִ����Լ����ִ���
	     */
	    private HashMap<String, Integer> getWordsForPrefix(Node root, String prefix) {
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        char[] chrs = prefix.toLowerCase().toCharArray();
	        ////
	        for (int i = 0, length = chrs.length; i < length; i++) {

	            int index = chrs[i] - 'a';
	            if (root.childs[index] == null) {
	                return null;
	            }

	            root = root.childs[index];

	        }
	        ///���������ǰ׺����
	        ///�˴�����֮ǰ��ǰ������������������
	        return preTraversal(root, prefix);
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}