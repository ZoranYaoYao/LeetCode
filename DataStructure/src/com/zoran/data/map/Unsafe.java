package com.zoran.data.map;

public class Unsafe {
    //get没有使用锁同步，而是使用轻量级同步volatile原语sun.misc.Unsafe.getObjectVolatile(Object, long)，保证读到的是最新的对象。
    public native Object getObjectVolatile(Object var1, long var2);
}
