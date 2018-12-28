package com.company.texing;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 15:22
 * @Version:
 */
public class Person1 {
     /*
    * 访问控制 修饰符
    * dafault 作用范围同个包下面
    * protected 子类 同个包 整个类
    * public 作用范围是整体 同类 同包 子类
    * */
     public String name;
     private int age;
     protected char sex;
     int names;

    /*public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }*/
    public void getInfo(){
        System.out.println(name+age+sex+names);

    }


   public static void main(String[] args) {
        Person1 person1 = new Person1();
        person1.name = "小名";
        person1.age = 2;
        person1.sex = '男';
        person1.names = 1;
        System.out.println(person1.name+person1.age+person1.sex+person1.names);

    }
}
