package com.zoran.encryption.param;

/**
 *
 * refer:
 * https://www.cnblogs.com/PerkinsZhu/p/9713836.html
 *
 * token:已登陆用户的识别码
 * 解决的问题:用户调用接口时，不用每次都带上用户名和密码，避免了频繁在网络中传输密码被截获的风险。
 * 使用场景:用户登录系统时传入用户名和密码，服务器校验成功之后，根据uuid等参数生成token返回给客户端，同时把该token和该用户的对应关系缓存在服务器端。客户端在后续的请求接口中不用每次都传入用户名和密码，只需要传入token即可。服务器会根据token确定客户端的身份。
 * 注意:token可设置生效时间，token失效之后，客户端重新请求token。
 */
public class Token {
}
