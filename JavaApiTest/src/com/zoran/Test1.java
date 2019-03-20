package com.zoran;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
public class Test1 {
    //ByteArrayInputStream本身操作的是一个数组，并没有打开文件描述之类的，所有不需要关闭流

    public static void main(String[] args) {

        int a = Integer.valueOf(new String("23"));
        System.out.println(a);
    }


}
