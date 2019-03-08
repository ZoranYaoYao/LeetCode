package com.zoran.encryption.param;

/**
 * 由于服务器请求都是走
 *
 * 对参数的分类：
 * 1.需要加密型的 比如电话号码，密码
 * 2.不需要加密的
 * 3.验证性参数 比如
 *     token: 用户登录token
 *     vkey:用于验证数据是否被篡改
 *     sig: 用于验证数据是否被篡改
 */
public class Param {
}
