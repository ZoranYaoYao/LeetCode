package com.zoran.dp.action.memento;

/**
 * Memento 备忘录模式
 * 备忘录对象是一个用来存储另外一个对象内部状态的快照的对象
 *
 * 行为:
 * 保存备忘录状态！
 *
 * refer:
 * http://www.cnblogs.com/java-my-life/archive/2012/06/06/2534942.html
 *
 * 分类：
 * 1.“白箱”备忘录模式
 * 2.“黑箱”备忘录模式
 * 3.多重检查点
 * 4.“自述历史”模式 （由于“自述历史”作为一个备忘录模式的特殊实现形式非常简单易懂，它可能是备忘录模式最为流行的实现形式）
 *
 * 经典运用：
 * Android中的Activity的onSaveInstanceState(Bundle outState) onRestoreInstanceState(Bundle savedInstanceState)
 */
public class Memento {
}
