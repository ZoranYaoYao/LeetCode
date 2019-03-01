package com.zoran.net.应用层协议;

public class Http {

    /**
     *
     *
     * Http1.0 Http1.1 Http2.0的区别？
     * https://www.cnblogs.com/mini-coconut/p/9178595.html
     *
     * Http1.0
     *  1.每次请求时，都是非持久链接，所以会导致性能很低。
     * Http1.1
     *  1.默认时持久链接，多个请求不用每次都验证，所以性能更好
     *  2.新增的返回的状态码 比如：局部请求资源 range字段
     * Http 2.0
     *  1.多路复用，就是做到同一个连接并发处理多个请求，而且并发请求的数量比HTTP1.1大了好几个数量级。
     */
}
