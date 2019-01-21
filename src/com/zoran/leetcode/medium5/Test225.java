package com.zoran.leetcode.medium5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 砖墙
 * https://leetcode-cn.com/submissions/detail/11892444/
 *
 * [Solution]
 * https://blog.csdn.net/mupengfei6688/article/details/79057848
 */
public class Test225 {

    /**
     * 31 / 85 个通过测试用例
     * 状态：解答错误
     */
    public int leastBricks(List<List<Integer>> wall) {
        //一定有间隙，遍历所有间隙值，在一次算最小值

        boolean single = true;
        for (List<Integer> item : wall) {
            if (item.size() != 1) {
                single = false;break;
            }
        }
        if (single) return wall.size();

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<wall.size(); i++) {
            int sum = 0;
            for (int j =0; j<wall.get(i).size()-1; j++) {
                sum += wall.get(i).get(j);
                set.add(sum);
            }
        }

        int res = 3;
        for (Integer item : set) {
            System.out.println("item=" + item);
            int temp = 0;
            for (int i=0; i<wall.size(); i++) {
                int sum = 0;
                if (wall.get(i).size() == 1) {
                    temp++;
                    break;
                }

                for (int j=0; j<wall.get(i).size()-1; j++) {
                    sum += wall.get(i).get(j);
                    if (sum == item) break;
                    if (sum >item) {
                        temp++;
                        break;
                    }
                    if (j == wall.get(i).size()-2) temp++;
                }
            }
            res = Math.min(res, temp);

        }

        return res;
    }
}

class Nice_Test225 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i=0; i<row.size()-1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = wall.size();
        for (int key : map.keySet()) {
            res = Math.min(wall.size()-map.get(key), res);
        }
        return res;
    }
}
