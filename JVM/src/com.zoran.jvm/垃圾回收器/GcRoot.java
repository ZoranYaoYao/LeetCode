package com.zoran.jvm.垃圾回收器;

/**
 * GcRoot
 *
 * refer:
 * https://blog.csdn.net/u010798968/article/details/72835255
 *
 * 1. 方法去里面的静态变量引用对象
 * 2. 方法区里面的常量引用对象（比如字符串）
 * 3. jvm方法栈里面的引用对象
 * 4. 本地方法栈中JNI（即一般说的Native方法）中引用的对象
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
