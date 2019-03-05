package com.zoran.dp.creater.single;

/**
 * SingleTone
 *
 * refer:
 * http://www.cnblogs.com/java-my-life/archive/2012/03/31/2425631.html
 *
 * 1.���ڵ���ģʽ�б���ʽ�����ʽ��final�ؼ���?
 * https://blog.csdn.net/qq_39986274/article/details/79215311
 * final �Ƿ��ͷŵ�����Դ�� ��������Ѿ�����Ҫ��������������ˣ���Ҫ�ͷ���Դʱ��������Ϊfinal�Ϳ��Խ�����Դ�ͷ�
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
    private static Single1 single = new Single1();

    static {
        System.out.println("Single1 static");
    }

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

    private Single2(){}

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
                    //NNNice_core: ��JDK1.5֮ǰ������new ���������Ϊ3������  ����:�������� ����:�����ڴ� ����:��ֵ��
                    // ����� Java ƽ̨�ڴ�ģ�͡��ڴ�ģ��������ν�ġ�����д�롱����Ҳ����Щϰ��ʧ�ܵ�һ����Ҫԭ�� ����ȸ�ֵ�����Ϊnull�ˣ������߼�������
                    https://blog.csdn.net/chenchaofuck1/article/details/51702129
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
