package com.zoran.dp.action.visitor;

/**
 * http://www.cnblogs.com/java-my-life/archive/2012/06/14/2545381.html
 * 访问者模式
 *
 * 目的：解决双重分派的问题
 * =================================
 *
 * 1.变量的类型
 * (1)变量被声明时的类型叫做变量的静态类型(Static Type)，有些人又把静态类型叫做明显类型(Apparent Type) -> 申明类型
 * (2)变量所引用的对象的真实类型又叫做变量的实际类型(Actual Type)
 *
 * 2.分派的概念
 * 根据对象的类型而对方法进行的选择，就是分派(Dispatch)，分派(Dispatch)又分为两种，即静态分派和动态分派
 * (1)静态分派(Static Dispatch)发生在编译时期，分派根据??静态类型信息发生。静态分派对于我们来说并不陌生，方法重载就是静态分派。
 * (2)动态分派(Dynamic Dispatch)发生在运行时期，动态分派动态地置换掉某个方法 ->重写方法
 *
 * 3.方法的宗量
 * 一个方法所属的对象叫做方法的接收者，方法的接收者与方法的参数统称做方法的宗量
 *
 * 4.单分派语言(Uni-Dispatch)和多分派语言(Multi-Dispatch)
 * 单分派语言根据一个宗量的类型进行对方法的选择，多分派语言根据多于一个的宗量的类型对方法进行选择。
 * ??Java就是动态的单分派语言，静态的多分派语言
 *
 * 5.双重分派
 * 一个方法根据两个宗量的类型来决定执行不同的代码，这就是“双重分派”。
 * Java语言不支持动态的多分派，也就意味着Java不支持动态的双分派。但是通过使用设计模式，也可以在Java语言里实现动态的双重分派。
 *
 * Visitor 访问者模式
 * 数据结构的每一个节点都可以接受一个访问者的调用，此节点向访问者对象传入节点对象，而访问者对象则反过来执行节点对象的操作。这样的过程叫做“双重分派”
 *
 * 行为方法:
 * visit(Node node) accept(Visitor visitor)
 *
 * refer:
 *
 * 作用:
 * 相当于对数据结构的一个组合过程！
 * 在实际系统中访问者模式通常是用来处理复杂的对象树结构的
 *
 * 好处:
 * 1.能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能
 */
public class Visitor {
}
