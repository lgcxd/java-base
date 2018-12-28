package com.company.duixiang;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 10:54
 * @Version:
 */
public class Person {
    public String name;
    public int age;
    public int sex;
    public void study(){
        System.out.println(name + "xingbie" + sex + "爱学习");
    }
    public void showAge(){
        System.out.println(age);
    }
    public void addAge(int i){
        i += age;
        System.out.println(i);
    }
}
