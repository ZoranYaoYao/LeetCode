package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ���ʽ���
 * https://leetcode-cn.com/submissions/detail/7524790/
 * 
 * [Solution]
 * http://www.cnblogs.com/tengdai/p/9249543.html
 */
public class Test67 {
	
	public static void main(String[] args) {
//		"a"
//		"c"
//		["a","b","c"]
		String[] strs = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm",
				"le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn",
				"ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt",
				"lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li",
				"ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na",
				"la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb",
				"ni","mr","pa","he","lr","sq","ye"};
		Test67 test67 = new Test67();
		List<String> list = new ArrayList<>(Arrays.asList(strs));
		int res = test67.ladderLength("qa", "sq", list);
		System.out.println(res);
	}

	/*
	"qa"
	"sq"
	["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm",
	"le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn",
	"ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt",
	"lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li",
	"ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na",
	"la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb",
	"ni","mr","pa","he","lr","sq","ye"]
	
	������ڳ�ʱ
	 */
    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //����,��¼����λ���Ƿ��滻, Ȼ����˽��д��³���.
        //if (!wordList.contains(endWord)) return 0;
        //char[] begins = beginWord.toCharArray();
        //char[] ends = endWord.toCharArray();
        //backTrace(begins, ends, wordList, 0, )
        
        //�����ֵ���б仯
        if (!wordList.contains(endWord)) return 0;
        if (wordList.contains(beginWord)) wordList.remove(beginWord);
        char[] begins = beginWord.toCharArray();
        char[] ends = endWord.toCharArray();
        boolean[] visited = new boolean[wordList.size()];
        backTrace(begins, ends, wordList, begins, 1, visited);
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public void backTrace(char[] begins, char[] ends, List<String> wordList, char[] curChars, int count, boolean[] visited) {
    	
        if (String.valueOf(curChars).equals(String.valueOf(ends)) && count<min) {
        	min = count;
        	return;
        }
        
        for(int i=0; i<wordList.size(); i++) {
            if(visited[i]) continue;
            char[] temp = wordList.get(i).toCharArray();
            boolean flag = isNext(curChars, temp);
            if(!flag) continue;
            
            visited[i] = true;
            System.out.println(String.valueOf(temp));
            backTrace(begins, ends, wordList, temp, count+1, visited); //������++count ��Ӱ����һ��forѭ����ֵ!!, ʹ��count+1
            //��������
            visited[i] = false;
        }
    }
    
    public boolean isNext(char[] curChars, char[] temp) {
        int diff = 0; boolean flag = true;;
        for(int j=0; j<curChars.length; j++) {
            if(curChars[j] != temp[j]) {
                diff++;
                if(diff>1) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}


class Nice_Test67 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //�滻����Ŀ��List�ṹ�����ٲ���
        if (!wordSet.contains(endWord)) return 0; //���Ŀ�궥�㲻��ͼ�У�ֱ�ӷ���0
        HashMap<String, Integer> map = new HashMap<>(); //�����洢�ѷ��ʵĽڵ㣬���洢����·���ϵ�λ�ã��൱��BFS�㷨�е�isVisted����
        Queue<String> q = new LinkedList<>(); //�������У�ʵ�ֹ�����ȱ���
        q.add(beginWord); //����Դ����
        map.put(beginWord, 1); //���Դ����Ϊ���ѷ��ʡ�������¼����·����λ��
        while (!q.isEmpty()) { //��ʼ���������еĶ���
            String word = q.poll(); //��¼�������ڴ���Ķ���
            int level = map.get(word); //��¼����·���ĳ���
            for (int i = 0; i < word.length(); i++) {
                char[] wordLetter = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (wordLetter[i] == j) continue; 
                    wordLetter[i] = j; //����ÿһλ��ĸ���ֱ��滻������25����ĸ
                    String check = new String(wordLetter);
                    if (check.equals(endWord)) return map.get(word) + 1; //����Ѿ��ִ�Ŀ��ڵ㣬���ص�ǰ·������+1
                    if (wordSet.contains(check) && !map.containsKey(check)) { //����ֵ��д����ڽӽڵ㣬������ڽӽڵ㻹δ������
                        map.put(check, level + 1); //�������ڽӽڵ�Ϊ�ѷ��ʣ���¼����·���ϵ�λ��
                        q.add(check); //������У��Թ��������
                    }
                }
            }
        }
        return 0;
    }
}
