package com.zoran.jvm.����ع���;

/**
 * refer:
 * https://blog.csdn.net/ln152315/article/details/79223441
 *
 * 1.����: JVM����class�ļ�
 * 2.����:
 *  ��֤: ��֤class�ļ���ʽ
 *  ����: ����������ķ��������滻���ڴ��ַ��
 *  ׼��: ��������ֵĬ��ֵ
 * 3.��ʼ��: �������������飬���캯�����и�ֵ��
 */
public class �����˳�� {

    static {
        System.out.println("��̬�����");
    }


    public �����˳��(){
        System.out.println("�����˳��" + i);
        i = 5;
        System.out.println("�����˳��" + i);
    }

    int i =1;
    {
        System.out.println("�����" + i);
        i = 3;
        System.out.println("�����" + i);
    }

    public static void main(String[] args) {
        �����˳�� test = new �����˳��();
        �����˳�� test2 = new �����˳��();

    }

}
