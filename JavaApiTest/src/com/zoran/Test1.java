package com.zoran;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
public class Test1 {
    //ByteArrayInputStream本身操作的是一个数组，并没有打开文件描述之类的，所有不需要关闭流

    public static void main(String[] args) {
        ByteArrayInputStream bais=null;
        StringBuilder sb=new StringBuilder();
        int temp=0;
        int num=0;
        long date1=System.currentTimeMillis();
        try{
            byte[] b="你好".getBytes();
            //从字符数组b中读取数据，从下标为2开始计数读8个
            bais=new ByteArrayInputStream(b,2,2);
            while((temp=bais.read())!=-1){
                sb.append((char)temp);
                num++;
            }
            System.out.println(sb);
            System.out.println("读取的字节数："+num);
        }finally{
            try{
                bais.close();//不需要关闭流的，但是调用close没有任何影响，close不做任何事情
            }catch(IOException e){
                e.printStackTrace();
            }
            new File("d:"+File.separator+"a.txt");//File.separator是一个文件分隔符，在windows和linux平台下运行都没有问题
        }
        long date2=System.currentTimeMillis();
        System.out.println("耗时:"+(date2-date1));

    }

}
