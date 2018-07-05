package com.zoran.leetcode.simple3;

/**
 * 压缩字符串
 * https://leetcode-cn.com/submissions/detail/3793635/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80287363
 */
public class Test93 {
	public static void main(String[] args) {
//		char[] chars = {'b','l','l','l','l','l','l','4','4','W','W','&','d','d','d','@','D','D','.','.','.','8',
//		 '8','8','U','V','>','J','J','k','H','H','=','l','[','[','[','[','[','[','[','a','a','\'','<',
//		 '[','[','y','V','l','l','\'','$','E','`','v','k','E','E','t','t','t','t','t','=','=','0','C','a',
//		 'l','l','l','r','R','M','M','c','c','c','A','A','S','9','9','9','9',')',')','\\','s','\\','\\',
//		 'y','W','W','W','J','J','J','J','6','6','<','<','E','u','e','e','e','e','e','e','e','e','e','9',
//		 '9','9','9','R','8','?','F','3','&','&','&','&','f','%','%','2','2','2',')',')',')','J','p','|',
//		 'D','D','D','s','t','V','V','?','^','^','S','3','3','3','3','h','*','|','|','b','b','a','a','a',
//		 'r','r','r','r','J','.','^','^','~','g',':',':',':','(','4','4','4','4','w','w','w','w','w','w',
//		 'w','C','?','=','d','L',':','0','0','c','w','w','w','w','w','w','{','{','t','k','k','k','&','&',
//		 '&','h','j','j','j','0','3','l',';',';',';',';',';','.','.','.','%','1','1','1','l','9','?','?',
//		 '?','t','>','E','N','N','@','>','.','.','I','a','a','a','a','B','7','7','{','o','o','-','+','+',
//		 '+','+','o','o','}','B','B','r','r','r','q','4','4','4','9','W','W','W','W','W','\'','\'','\'','g',
//		 'J','(','(','(','(','t','t','?',';','g','g','g','0',']',']',']'};
		char[]  chars = {'a','a','b','b','c','c','c'};
		System.out.println(Nice_compress(chars));
	}
	
	/**
	 * 没有做到改变字符数组 
	 */
    public static int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        if(chars.length == 1) return 1;
        
        int[] count = new int[127];
        for(int i = 0; i < chars.length; i++) {
            count[(char)chars[i] ]++;
        }
        
        int result = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0) continue;
            result++;
            while(count[i]  > 0){
                result++;
                count[i] = count[i] / 10;
            }  
        }
        
        return result;
    }
    

    public static int Nice_compress(char[] chars) {
        int index = 0; 
        if(chars.length < 2)
            return chars.length;
        for(int i = 0; i < chars.length;){
            int times = 1;
            chars[index++]  = chars[i++];
            while(i < chars.length && chars[i] == chars[i-1]){
                times++;
                i++;
            }
            if(times > 1){
                char[] chs = String.valueOf(times).toCharArray();
                for(int j = 0;j<chs.length;j++)
                    chars[index++] = chs[j]; //Core. index记录需要修改值的地方, i索引用于遍历
            }
        }
        return index;
    }

}
