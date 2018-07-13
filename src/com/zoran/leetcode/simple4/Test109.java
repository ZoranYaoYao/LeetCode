package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 键盘行
 * https://leetcode-cn.com/submissions/detail/4112398/
 */
public class Test109 {
	
	public static void main(String[] args) {
		String[] words = {"Hello","Alaska","Dad","Peace"};
		String[] items = findWords(words);
		System.out.println(Arrays.toString(items));
	}
	
    public static String[] findWords(String[] words) {
        char[] chrs1 = {'q','w','e','r','t','y','u','i','o','p'};
        char[] chrs2 = {'a','s','d','f','g','h','j','k','l'};
        char[] chrs3 = {'z','x','c','v','b','n','m'};
//        List<Character> list1 = new ArrayList(Arrays.asList(chrs1)); //基本类型不能做泛型
        List<Character> list1 = new ArrayList<Character>( Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        List<Character> list2 = new ArrayList<Character>(Arrays.asList('a','s','d','f','g','h','j','k','l'));        
        List<Character> list3 = new ArrayList<Character>(Arrays.asList('z','x','c','v','b','n','m'));  

        
        List<String> result = new ArrayList<>();
        for(String item : words) {
        	char[] chrs = item.toLowerCase().toCharArray();
        	int type = 0; boolean inSameRow = true;
            for(int i = 0; i < chrs.length; i++) {
                if(list1.contains(chrs[i])) {
                	if(type == 0 || type == 1) {
                		type = 1;
                	} else {
                		inSameRow = false;
                		break;
                	}
                } else if(list2.contains(chrs[i])) {
                	if(type == 0 || type == 2) {
                		type = 2;
                	} else {
                		inSameRow = false;
                		break;
                	}
                } else if (list3.contains(chrs[i])) {
                	if(type == 0 || type == 3) {
                		type = 3;
                	} else {
                		inSameRow = false;
                		break;
                	}
                }
            }
            if(inSameRow) result.add(item);
        }
        
        String[] arr = new String[result.size()];
        return  result.toArray(arr);
    }
}
