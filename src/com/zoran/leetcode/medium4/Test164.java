package com.zoran.leetcode.medium4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * ������ֵ
 * https://leetcode-cn.com/submissions/detail/10418233/
 *
 * [Solution]
 * https://blog.csdn.net/mebiuw/article/details/52512370
 *
 * Core�� ͨ��һ��HashMap<String,List<String>> ���д�����������
 */
public class Test164 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //����queries, ��ѯֵ
        double[] res = new double[queries.length];

        /**
         * ˫������ѭ�� ������
         */
        String[] map = new String[equations.length];
        double[] go = new double[equations.length];
        for (int i=0; i<equations.length; i++) {
            String str = equations[i][0]+equations[i][1];
            String str1 = equations[i][1]+equations[i][0];
            map[i] = str; go[i] = values[i];
        }

        for(int i=0; i<queries.length; i++) {
            String fenzi = queries[i][0];
            String fenmu = queries[i][1];
            if (fenzi.equals(fenmu)) {
                res[i] = (1.0);
                continue;
            }

            res[i] = find(map, go, fenmu, values[i], fenmu);
        }

        return res;
    }


    public double find(String[] map, double[] go, String next, double count, String expected) {

        for(int i=0; i<map.length; i++) {
            String start = map[i].substring(0,1);
            String end = map[i].substring(1);
            if(start.equals(next)) { //������ͬ
                if (next.equals(expected))
                    return count*go[i];
                else {
                    return find(map, go, end, count*go[i], expected); //����㣺 ab, ba ����ѭ�����⣿�����ջ
                }
            } else if(end.equals(next)) {
                return find(map, go, start, count*(1/go[i]), expected);
            }
        }

        return -1.0;
    }
}

class Nice_Test164 {
    public class Solution {
        //�洢��ϵ������������ͷ������£�����Щ����
        /**
         * Core�� ͨ��һ��HashMap<String,List<String>> ���д�����������
         */
        HashMap<String,List<String>> divisionRelations = new HashMap<String, List<String>>();
        HashMap<String,Double> equationsResult = new HashMap<String,Double>();
        /**
         * ������Щ�ǿ���
         * Ҫô a/b ����
         * Ҫô�� ��a/c��*(c/b)���ڣ���ѡһ
         * */
        public double dfs(HashSet<String> visited, double val, String a, String b){
            double result = -1;
            visited.add(a);
            if(divisionRelations.containsKey(a) == false)
            {
                visited.remove(a);
                return result;
            }
            List<String> list = divisionRelations.get(a);
            for(String tmp:list){
                if(tmp.equals(b)){
                    result = equationsResult.get(a+"%"+tmp);
                    break;
                } else if (visited.contains(tmp) == false){
                    double midResult = dfs(visited,val,tmp,b);
                    if(midResult!=-1){
                        result = equationsResult.get(a+"%"+tmp)*midResult;
                        break;
                    }

                }
            }
            visited.remove(a);
            return result;
        }
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

            /**
             * ����ù�ϵ a/b �Լ���Ӧ�� b/a,ע��a/b = 0��ʱ��û������*/
            for(int i=0;i<equations.length;i++){
                String a = equations[i][0];
                String b = equations[i][1];
                if(divisionRelations.containsKey(a) == false) divisionRelations.put(a,new ArrayList<String>());
                if(divisionRelations.containsKey(b) == false) divisionRelations.put(b,new ArrayList<String>());
                divisionRelations.get(a).add(b);
                equationsResult.put(a+"%"+b,values[i]);
                if(values[i]!=0){
                    divisionRelations.get(b).add(a);
                    equationsResult.put(b+"%"+a,1.0/values[i]);
                }
            }
            //����
            double[] result = new double[queries.length];
            for(int i=0;i<queries.length;i++){
                result[i] = dfs(new HashSet<String>(),0,queries[i][0],queries[i][1]);
            }
            return result;


        }
    }
}
