package com.company.texing;

interface JieKou {
    /*
    * 接口(interface)是抽象方法和常量值的定义的集合
    * 从本质讲,接口是特殊的抽象类,这种抽象类中只包含常量和方法的定义,而没有变量和方法的实现
    * 接口的特点:
    * interface来定义.
    * 接口中的所有成员变量都默认是有public static final修饰的
    * 接口中的所有方法都默认是有public abstract修饰的.接口没有构造函数
    * 实现接口的类中必须提供接口中所有方法的具体实现内容
    * 多个无关的类可以实现同一个接口
    * 一个类可以实现多个无关的接口
    * 与继承关系类似,接口与实现类之间存在多态性
    * 接口也可以继承另一个接口,使用extends关键字
    * */
    int id = 1;
    public void start();
    public void run();
    public void stop();
}
interface Runner{
    public void run();
}
interface Swing{
    public void swing();
}