package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.List;

/**
 * 332. 重新安排行程
 * https://leetcode-cn.com/submissions/detail/8941341/
 * 
 * [Solution]
 * https://blog.csdn.net/JackZhang_123/article/details/78151410
 */
public class Test133 {
	
	public static void main(String[] args) {
		Test133 test133 = new Test133();
//		String[][] strings = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		String[][] strings = {{"JFK","SFO"}};
		List<String> reStrings = test133.findItinerary(strings);
		System.out.println(reStrings);
	}

	/**
	 * 超出时间限制
	 */
    public List<String> findItinerary(String[][] tickets) {
        //遍历所有从JFK开始的结果
        List<String> res = new ArrayList<>();
        
        int row = tickets.length;
        int col = tickets[0].length;
        for (int i=0; i<row; i++) {
            List<String> list = null;
            if (tickets[i][0].equals("JFK")) {
                list = validRoute(tickets, "JFK");
            }
            
            if(list == null) continue;
            
            if (res.size() == 0) res = list;
            else {
                int length = Math.min(res.size(), list.size());
                for (int j=0; j<length; j++) {
                    if (list.get(j).compareTo(res.get(j)) > 0) {
                        res = list;
                        break;
                    } else if (list.get(j).compareTo(res.get(j)) < 0) {
                        break;
                    }
                    
                    if (j == length -1 && list.size() > res.size()) res = list;
                }
            }
        }
                               
        return res;
    }
    
    private List<String> validRoute(String[][] tickets, String curLoc) {
        List<String> list = new ArrayList<>();
    	list.add(curLoc);
        int row = tickets.length;
        int col = tickets[0].length;
        while (true) {
            boolean noNext = true;
            
            for (int i=0; i<row; i++) {
                if (tickets[i][0].equals(curLoc)) {
                    curLoc = tickets[i][1];
                	list.add(curLoc);
                    noNext = false;
                    break;
                }
            }
            
            if (noNext) break;
        }
        
        return list;
    }
}
