package com.zoran.dp.creater.prototype;

import java.util.Arrays;

/**
 * ԭ��ģʽ ProtoType
 *
 * refer:
 * http://www.cnblogs.com/java-my-life/archive/2012/04/11/2439387.html
 *
 * �ص㣺
 * Java�����ṩ��Cloneable�ӿ�ֻ��һ�����ã�����������ʱ��֪ͨJava��������԰�ȫ�����������ʹ��clone()����
 *
 * 1.ͨ�����л�ʵ�����
 * ǰ���Ƕ���ʵ����Serilizeable�ӿ�
 *
 * 2.��һЩ���󣬱����߳�(Thread)�����Socket�����ǲ��ܼ򵥸��ƻ���ġ�������ʹ��ǳ�ȿ�¡������ȿ�¡
 * ��ֻҪ�漰�����ļ�Ӷ��󣬾ͱ���Ѽ�Ӷ������transient�����踴�ƣ������ɳ������д������൱��ͬ�ֶ���Ȩ�ҵ������Ƽ�ʹ�á�
 */
public class ProtoType implements Cloneable{
    int age; //��������
    String name; //����
    String[] source; //����

    public ProtoType(int age, String name, String[] source) {
        this.age = age;
        this.name = name;
        this.source = source;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        String[] source  = null;
        ProtoType protoType = new ProtoType(29,"zqs", source = new String[]{"1","2"});
        ProtoType protoType1 = (ProtoType) protoType.clone();
        protoType.age = 24;
        protoType.name = "zsy";
        protoType.source[1] = "3";


        // ?clone()��¡֮��Ĭ��ǳ����
        // �������������´���
        // ���������ǹ���ָ������ַ
        System.out.println(protoType1.name); //zqs
        System.out.println(protoType1.age); //0
        System.out.println(Arrays.toString(protoType1.source));  //null

    }
}
