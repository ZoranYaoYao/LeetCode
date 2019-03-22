package com.zoran.encryption.md5;

/**
 * MD5 (Message Digest 5) 消息摘要算法
 *
 * http://www.cnblogs.com/second-tomorrow/p/9129043.html
 * https://blog.csdn.net/nzfxx/article/details/51804193
 *
 * 算法原理：
 * https://blog.csdn.net/sinat_27933301/article/details/79538169
 *
 * 介绍：
 * 大家都知道，地球上任何人都有自己独一无二的指纹，这常常成为司法机关鉴别罪犯身份最值得信赖的方法；与之类似，
 * MD5就可以为任何文件（不管其大小、格式、数量）产生一个同样独一无二的“数字指纹”，如果任何人对文件做了任何改动，其MD5值也就是对应的“数字指纹”都会发生变化。
 *
 * 作用：
 * 1.作为文件的唯一id，成为数字指纹，如果文件被篡改，则MD5值也会改变
 * 2.用作网络请求的参数的加密，生成一个数字签名， 服务器进行验证
 *
 * 不可逆性：
 * https://blog.csdn.net/lspq35k7o5aj21l1h9o/article/details/81073726
 * 它在大多数时候都是不可逆的，即你经过哈希算法得出的数据，无法再经过任何算法还原回去。
 * 所以，既然不能将数据还原，也就不能称之为可以解密；既然不能解密，那么哈希的过程自然也就不能称作是「加密」了。
 */
public class MD5 {
}
