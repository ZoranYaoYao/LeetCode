package com.zoran.leetcode.simple4;

/**
 * 学生出勤纪录 I
 * https://leetcode-cn.com/submissions/detail/4358828/
 */
public class Test121 {
	public static void main(String[] args) {
		Test121 test121 = new Test121();
		System.out.println(test121.Nice_checkRecord("ALLLLLL"));
	}

	/**
	 * Note: 处理连续2个L的办法是: 判定连续2个数的值
	 */
    public boolean checkRecord(String s) {
        int aCount = 0; int continueL = 0;
        char[] chrs = s.toCharArray();
        for(int i = 0; i < chrs.length; i++) {
            if(chrs[i] == 'A') aCount++;
            if(chrs[i] == 'L' &&  i < chrs.length -1  && chrs[i + 1] == 'L') {
                continueL++;
            } else {
                continueL = 0;
            }
            if(aCount > 1 || continueL > 1) return false;
        }
        
        return true;
    }
    
    /**
     * 索引值 + 包含值
     */
    public boolean Nice_checkRecord(String s) {
        return s.indexOf("A")==s.lastIndexOf("A")&&!s.contains("LLL");
     }
}
