package com.zoran.enu;




public class Singleton {



    static {
        System.out.println("22222222");
    }

    // 1. ������̬�ڲ��� -> ��̬�ڲ��� ���ⲿ�����κι�ϵ
    private static class Singleton2 {
        // �ھ�̬�ڲ����ﴴ������
        private static  Singleton ourInstance  = new Singleton();

        static{
            System.out.println("11111");
        }
    }

    // ˽�й��캯��
    private Singleton() {
    }

    // �ӳټ��ء����贴��
    public static  Singleton newInstance() {
        return Singleton2.ourInstance;
    }

}

