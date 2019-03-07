package com.zoran.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * https://blog.csdn.net/alex_81d/article/details/80997146
 */
public class Base64Test {


    public static void main(String[] args) throws UnsupportedEncodingException {
        Base64.Decoder decoder = Base64.getDecoder();
        Base64.Encoder encoder = Base64.getEncoder();

        String text = "×Ö´®ÎÄ×Ö";
        byte[] textByte = text.getBytes("UTF-8");
        String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);

        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }
}
