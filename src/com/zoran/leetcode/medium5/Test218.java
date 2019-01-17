package com.zoran.leetcode.medium5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL �ļ��������
 * https://leetcode-cn.com/submissions/detail/11738874/
 *
 * [Solution]
 * https://blog.csdn.net/mrbcy/article/details/62038367
 */
public class Test218 {
    //�ԳƼ���
    //���ܣ����ÿ���ַ���������10
    //���ܣ����ÿ���ַ����м�ȥ10
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] arr = longUrl.toCharArray();
        for (char item : arr) item += 10;
        return new String(arr);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        char[] arr = shortUrl.toCharArray();
        for (char item : arr) item -= 10;
        return new String(arr);
    }
}

class Nice_Test218 {
    private static Map<String,String> dict = new HashMap<String,String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = "http://tinyurl.com/" + longUrl.hashCode();
        dict.put(tinyUrl,longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return dict.get(shortUrl);
    }
}
