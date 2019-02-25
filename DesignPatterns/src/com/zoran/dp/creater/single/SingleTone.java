package com.zoran.dp.creater.single;

/**
 * SingleTone
 *
 * refer:
 * http://www.cnblogs.com/java-my-life/archive/2012/03/31/2425631.html
 */
public class SingleTone {

    public static void main(String[] args) {
        System.out.println(Single1.getInstance());
        System.out.println(Single1.getInstance());

        System.out.println(Single2.getInstance());
        System.out.println(Single2.getInstance());

        System.out.println(Single3.getInstance());
        System.out.println(Single3.getInstance());

        System.out.println(Single4.SINGLE);
        System.out.println(Single4.SINGLE);

    }

}

/**
 * ��ʽһ��
 * ����ʽ
 */
class Single1 {
    private static final Single1 single = new Single1();

    private Single1(){
    }

    public static Single1 getInstance() {
        return single;
    }
}

/**
 * ��ʽ����
 * ����ʽ-��̬�ڲ���
 * �����༶�ڲ����ʱ�򣬲Ž��г�ʼ������
 */
class Single2 {

    private Single2(){
    }

    public static Single2 getInstance() {
        return Creator.single;
    }

    static class Creator {
        private static Single2 single = new Single2();
    }

}

/**
 * ��ʽ����
 * ����ʽ-˫�ؼ���
 * ͨ��synchronized (Single3.class) {} ����֤���԰�ȫ
 */
class Single3 {
    //Core ˫�ؼ��� ����Ҫ��ӹؼ���volatile����
    private static volatile Single3 single;

    private Single3() {
    }

    public static Single3 getInstance() {

        if (single == null) {
            synchronized (Single3.class) {
                if (single == null) {
                    single = new Single3();
                }
            }
        }
        return single;
    }
}

/**
 * ��ʽ�ģ�
 * ����ʽ-ö��
 * ö�ٵ�ÿ��ʵ������һ�������ṹ��
 */
enum Single4 {
    SINGLE,
}
