package com.zoran;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
public class Test1 {
    //ByteArrayInputStream�����������һ�����飬��û�д��ļ�����֮��ģ����в���Ҫ�ر���

    public static void main(String[] args) {
        ByteArrayInputStream bais=null;
        StringBuilder sb=new StringBuilder();
        int temp=0;
        int num=0;
        long date1=System.currentTimeMillis();
        try{
            byte[] b="���".getBytes();
            //���ַ�����b�ж�ȡ���ݣ����±�Ϊ2��ʼ������8��
            bais=new ByteArrayInputStream(b,2,2);
            while((temp=bais.read())!=-1){
                sb.append((char)temp);
                num++;
            }
            System.out.println(sb);
            System.out.println("��ȡ���ֽ�����"+num);
        }finally{
            try{
                bais.close();//����Ҫ�ر����ģ����ǵ���closeû���κ�Ӱ�죬close�����κ�����
            }catch(IOException e){
                e.printStackTrace();
            }
            new File("d:"+File.separator+"a.txt");//File.separator��һ���ļ��ָ�������windows��linuxƽ̨�����ж�û������
        }
        long date2=System.currentTimeMillis();
        System.out.println("��ʱ:"+(date2-date1));

    }

}
