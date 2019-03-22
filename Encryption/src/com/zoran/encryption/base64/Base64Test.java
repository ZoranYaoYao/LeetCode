package com.zoran.encryption.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64
 *
 * https://www.cnblogs.com/diligenceday/p/6002382.html base
 * https://blog.csdn.net/alex_81d/article/details/80997146
 *
 * 作用：
 * 在json格式中，不允许传递不可见字符。 所以这个时候需要将二进制转换成base64编码的格式！
 *
 */
public class Base64Test {


    public static void main(String[] args) throws UnsupportedEncodingException {
        Base64.Decoder decoder = Base64.getDecoder();
        Base64.Encoder encoder = Base64.getEncoder();

        String text = "字串文字";
        byte[] textByte = text.getBytes("UTF-8");
        String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);

        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }
}
