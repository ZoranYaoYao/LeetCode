package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 单词接龙
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
	
	最后死于超时
	 */
    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //回溯,纪录访问位置是否替换, 然后回退进行从新尝试.
        //if (!wordList.contains(endWord)) return 0;
        //char[] begins = beginWord.toCharArray();
        //char[] ends = endWord.toCharArray();
        //backTrace(begins, ends, wordList, 0, )
        
        //根据字典进行变化
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
            backTrace(begins, ends, wordList, temp, count+1, visited); //不能用++count 会影响下一次for循环的值!!, 使用count+1
            //重置条件
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
        HashSet<String> wordSet = new HashSet<>(wordList); //替换掉题目中List结构，加速查找
        if (!wordSet.contains(endWord)) return 0; //如果目标顶点不在图中，直接返回0
        HashMap<String, Integer> map = new HashMap<>(); //用来存储已访问的节点，并存储其在路径上的位置，相当于BFS算法中的isVisted功能
        Queue<String> q = new LinkedList<>(); //构建队列，实现广度优先遍历
        q.add(beginWord); //加入源顶点
        map.put(beginWord, 1); //添加源顶点为“已访问”，并记录它在路径的位置
        while (!q.isEmpty()) { //开始遍历队列中的顶点
            String word = q.poll(); //记录现在正在处理的顶点
            int level = map.get(word); //记录现在路径的长度
            for (int i = 0; i < word.length(); i++) {
                char[] wordLetter = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (wordLetter[i] == j) continue; 
                    wordLetter[i] = j; //对于每一位字母，分别替换成另外25个字母
                    String check = new String(wordLetter);
                    if (check.equals(endWord)) return map.get(word) + 1; //如果已经抵达目标节点，返回当前路径长度+1
                    if (wordSet.contains(check) && !map.containsKey(check)) { //如果字典中存在邻接节点，且这个邻接节点还未被访问
                        map.put(check, level + 1); //标记这个邻接节点为已访问，记录其在路径上的位置
                        q.add(check); //加入队列，以供广度搜索
                    }
                }
            }
        }
        return 0;
    }
}
