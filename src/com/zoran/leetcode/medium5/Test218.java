package com.zoran.leetcode.medium5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL 的加密与解密
 * https://leetcode-cn.com/submissions/detail/11738874/
 *
 * [Solution]
 * https://blog.csdn.net/mrbcy/article/details/62038367
 */
public class Test218 {
    //对称加密
    //加密：针对每个字符进行增加10
    //解密：针对每个字符进行减去10
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
