package com.zoran.dp.action.command;

/**
 * Command 命令模式
 * 命令模式把发出命令的责任和执行命令的责任分割开，委派给不同的对象
 *
 * 通用方法：
 * Command execute();
 *
 * refer：
 * http://www.cnblogs.com/java-my-life/archive/2012/06/01/2526972.html
 *
 * 底层原理
 * 命令对象关联接受者对象
 *
 * 类图关系：
 * Client,Invoker,Command,Receiver
 *
 * 分类：
 * 1.单条命令
 * 2.宏命令 (MacroCommand)
 */
public class Command {
}
