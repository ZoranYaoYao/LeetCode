package com.zoran.leetcode.simple2;

/**
 * 168. Excel��������
 * https://leetcode-cn.com/problems/excel-sheet-column-title/description/
 * 
 * [Solution]
 * https://blog.csdn.net/u010183658/article/details/50947405
 */
public class Test37 {

	/**
	 * ����: 26����,ż���ݵ�ʱ�����ʾ
	 */
//    public String convertToTitle(int n) {
//        int tmp = 0; //����
//        List<Integer> list = new LinkedList<>();
//        while (tmp = (n / 26) > 0) {
//            int mod = n % 26; //����
//            list.add(mod);
//            n = tmp;
//        }
//        
//        while(list.peekLast() != null) {
//            
//        }
//    }
    
    public String Nie_convertToTitle(int n) {
    	String str = new String();
    	while(n > 0) {
    		int mod = (n-1) % 26;
    		str = (char) ('A' +mod) + str;
    		n = (n-1) / 26;
    	}
    	
    	return str;
    }
    
    /**
     * 26�������� ��ȷ�����߼�
     */
    public String LeetCode_convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int mod = n % 26;
            char c = mod == 0 ? 'Z' : (char)('A' + mod - 1); // ���� ת����Ӧ��charֵ
            sb.append(c);
            n -= (mod == 0 ? 26 : mod); //core!!!: ���� - ���� =  26�������� ����: 27 * 26;����(��һλ!!)�ļ���
            n /= 26;
        }
        return sb.reverse().toString(); //Sring ����
    }
}
