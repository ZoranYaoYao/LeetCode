package com.zoran.enu;




public class Singleton {



    static {
        System.out.println("22222222");
    }

    // 1. 创建静态内部类 -> 静态内部类 与外部类无任何关系
    private static class Singleton2 {
        // 在静态内部类里创建单例
        private static  Singleton ourInstance  = new Singleton();

        static{
            System.out.println("11111");
        }
    }

    // 私有构造函数
    private Singleton() {
    }

    // 延迟加载、按需创建
    public static  Singleton newInstance() {
        return Singleton2.ourInstance;
    }

}

