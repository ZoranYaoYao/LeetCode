package com.zoran.jvm.����������;

/**
 * GcRoot
 *
 * refer:
 * https://blog.csdn.net/u010798968/article/details/72835255
 *
 * 1. ����ȥ����ľ�̬�������ö���
 * 2. ����������ĳ������ö��󣨱����ַ�����
 * 3. jvm����ջ��������ö���
 * 4. ���ط���ջ��JNI����һ��˵��Native�����������õĶ���
 */
public class GcRoot {

    /**
     * ??
     */
    static class Test {
        private static int _10MB = 1 * 1024 * 1024;
        private final Test t = new Test((int) (10 * _10MB));
//       private static final Test t;
        private byte[] memory;

        public Test(int size) {
            memory = new byte[size];
//            t = new Test(size);
        }

        public static void main(String[] args) {
            System.out.println("aa");
            Test t3 = new Test(4 * _10MB);
            t3 = null;
//            Test t4 = new Test(4 * _10MB);
//            t4 = null;
//            Test t5 = new Test(4 * _10MB);
//            t5 = null;
//            Test t6 = new Test(4 * _10MB);
//            t6 = null;

            System.gc();
        }

    }
}
