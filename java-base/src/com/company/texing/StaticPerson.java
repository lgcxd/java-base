package com.company.texing;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/16 11:46
 * @Version:
 */
public class StaticPerson {
    private int id;
    private  static int total = 0;
    public static int total2;
    public static int getTotal(){
        //id++;//非法 static 方法内只能访问类的static属性 不能访问非static属性 因为对于非静态的属性和方法的访问需要创建实例,
        // 静态的不需要创建实例就能访问
        return total;
    }
    public static void getTotal2(){
        //this.total = total;//非法 因为不需要实例就能访问static方法,this引用的对象根本没产生 因此不能用this,也不能用super
    //例如main()方法是静态的,因此jvm在执行main方法是不创建main方法所在类的实例对象 因而在main方法中不能非静态成员 必须创建实例才可以访问
    }
    public static void setTotal(int total) {
        StaticPerson.total = total;
    }

    public StaticPerson(){
        total++;
        id = total;
    }
    /*
    静态初始化:一个类中可以使用不包含在任何方法体重的静态代码块
    * 静态代码块:当类被载入时,静态代码块被执行,且只被执行一次,静态代码块经常用来进行类属性的初始化*/
    static {
        total2 = 100;//为total附初始值
        System.out.println("在静态代码块中");
    }
}
