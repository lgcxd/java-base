package com.company.texing;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/16 14:48
 * @Version:
 */
abstract class A{
    abstract void a1();
    public void a2(){
        System.out.println("A中的a2");
    }
}
class B extends A{
    void a1(){
        System.out.println("b中的a1");
    }
}
public class AbstractClass {
    /*
    * 抽象类:没有具体的实例,不能实例化.
    * abstract 关键字修饰类为-抽象类 修饰方法-抽象方法
    * 抽象方法:只有声明没有方法的实现,以分号结束
    * 含有抽象方法的类必须被声明为抽象类
    * 抽象类不能被实例化.抽象类是用来被继承的,抽象类的子类必须重写父类的抽象方法,并提供方法体.
    * 不能用abstract修饰私有方法, 构造方法,静态方法
    * */
    public static void main(String[] args) {
        A aa = new B();
        aa.a1();
        aa.a2();
    }
}
