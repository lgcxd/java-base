package com.company.texing;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/16 14:10
 * @Version:
 */
class Singleton {
    private static Singleton onlyone = new Singleton();//私有的,只能在类内访问
    private String name;
    public static Singleton getOnlyone(){//getOnlyone()为static,不用创建对象即可访问
        return  onlyone;
    }
    private Singleton(){} //私有的构造器 不能在类的外部创建该类的对象
}
public class TestSingleton{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getOnlyone();//访问静态方法
        Singleton singleton1 = Singleton.getOnlyone();
        if(singleton == singleton1){
            System.out.println("相同");
        }
    }
}
