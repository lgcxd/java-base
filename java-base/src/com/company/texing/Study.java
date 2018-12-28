package com.company.texing;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 14:53
 * @Version:
 */
public class Study extends Person {
    //extends 继承 不是父类的子集是父类的扩展
    //一个子类只能有一个直接父类,一个父类可以派生出多个子类
    //继承规则:子类不能继承父类的私有成员变量和方法
    public String school;

    @Override //重写的注解
    public void getInfo(){ //重写
        System.out.println("名字:"+name+"年龄"+age+"出生日"+birDate+/*"性别"+sex+*/"学校"+school);
    }
}
