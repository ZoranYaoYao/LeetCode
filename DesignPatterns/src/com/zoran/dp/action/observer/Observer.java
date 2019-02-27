package com.zoran.dp.action.observer;

/**
 * Observer 观察者模式
 * 又叫发布-订阅(Publish/Subscribe)模式、模型-视图(Model/View)模式、源-监听器(Source/Listener)模式或从属者(Dependents)模式
 * 这个主题对象在状态上发生变化时，会通知所有观察者对象，使它们能够自动更新自己
 *
 * 行为：
 * notify()
 *
 * refer:
 * http://www.cnblogs.com/java-my-life/archive/2012/05/16/2502279.html
 *
 * 分类：
 * 1.推模型
 * 2.拉模型 (传递整个对象，推荐)
 *
 * 外观模式： 1对多
 * 中介者模式： 多对多
 * 观察者模式：一次性解决1对多关系
 *
 * 运用：
 * Java接口
 * https://blog.csdn.net/u012250875/article/details/77747878
 * 注意： 里面有个changed关键字， 每次发布时，必须调用setChanged()，才能通知到观察者！ -> 预防多线程通知问题！
 */
public class Observer {
}
