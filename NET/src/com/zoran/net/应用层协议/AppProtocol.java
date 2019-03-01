package com.zoran.net.应用层协议;

/**
 *
 */
public class AppProtocol {
    /**
     * 1.Http 与 Https 区别？
     * http, https, ssl/tls CA授权机构，数字证书，公钥，私钥
     *
     * 2. https协议的好处：
     * 通过数字证书，可以区别是否是官网还是钓鱼网站！
     *
     * 3.https加解密过程 （混合型加解密！）
     * https://blog.csdn.net/u012852986/article/details/78873387
     * 对称加密主要对数据进行加密，非对称加密主要是对对称秘钥进行加密
     * （1）首先通过非对称公钥，私钥，对一个随机数进行加密，解密
     * （2）对解密后的随机数，进行对称加密，解密！！
     *
     * refer:
     * https://www.cnblogs.com/jesse131/p/9080925.html
     *
     * SSL协议位于TCP/IP协议与各种应用层协议之间
     * SSL协议位于TCP/IP协议与各种应用层协议之间，为数据通讯提供安全支持。SSL协议可分为两层：
     * SSL记录协议（SSL Record Protocol）：它建立在可靠的传输协议（如TCP）之上，为高层协议提供数据封装、压缩、加密等基本功能的支持。
     * SSL握手协议（SSL Handshake Protocol）：它建立在SSL记录协议之上，用于在实际的数据传输开始前，通讯双方进行身份认证、协商加密算法、交换加密密钥等
     */
}
