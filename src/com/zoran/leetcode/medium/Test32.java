package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ��k������
 * https://leetcode-cn.com/submissions/detail/6619983/
 * 
 * [Solution]
 * https://www.cnblogs.com/ariel-dreamland/p/9149577.html
 * https://blog.csdn.net/Lynn_Baby/article/details/80948414
 * 
 *  ����, ��list<Integer> ת������ String��ʽ  -> ��ʱ
 *  https://leetcode-cn.com/problems/permutations/description/
 *  
 *  ����ԭ��,: ���ڵ�n����, ����
 *   int indexList = k/factorail;  // factorail Ϊ�׳�����
 */
public class Test32 {
	public static void main(String[] args) {
		Test32 test32 =new Test32();
		String string = test32.getPermutation(9, 219601);
		System.out.println(string);
	}

	/**
	 * ��ʱ
	 * 9 219601
	 * 
	 * �㷨��ȷ, �¼���ʱ
	 */
    public String getPermutation(int n, int k) {
        //�����㷨, ��������K������
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = i+1;
        }
        
        List<String> list = new ArrayList<>();
        backTrace(nums, list, k, new StringBuilder());
        
        return list.get(k-1);
    }
    
    public void backTrace(int[] nums, List<String> list, int k, StringBuilder sb) {
        if(list.size() == k) return;
        
        if(sb.toString().length() == nums.length) {
            list.add(sb.toString());
        } else {
            for(int i=0; i<nums.length; i++) { 
            	if(sb.length() >0 && sb.indexOf(nums[i]+"") != -1) continue; //CCore. ȥ��, StringBuilder�������ַ�����
                sb.append(nums[i]);
                backTrace(nums, list, k, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}

/**
 * ���û����㷨 -> �ҹ���
 */
class Nice_Test32 {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<Integer>();//ע��洢1-n
        StringBuilder s = new StringBuilder();
        int times = n-1;
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int factorail = 1;//�׳�
        for(int i=2;i<n;i++){//��Ҫ��n
            factorail*=i;
        }
        while(times>=0){
            int indexList = k/factorail;
            s.append(list.get(indexList));
            list.remove(indexList);
            k=k%factorail;
            if(times!=0){
                factorail/=times;
            }
            times--;
        }
        return s.toString();

    }
}
