package com.company.texing;

import java.util.Date;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 14:49
 * @Version:
 */
public class Person {
    public String name;
    public int age;
    public Date birDate;
    private  char sex;
    public void getInfo(){
        System.out.println("名字:"+name+"年龄"+age+"出生日"+birDate+"性别"+sex);
    }
}
