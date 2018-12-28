package com.company.FanShe;

import com.company.texing.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/25 11:20
 * @Version:
 */
public class PersonsTest {
    @Test
    public void test3(){
        Persons persons = new Persons();
        Class classs=persons.getClass();//通过运行时类的对象,调用其getClass(),返回其运行时类
        System.out.println(classs);
    }
    //有了反射,可以通过反射创建一个类的对象,并调用其中的结构
    @Test
    public void test2() throws Exception{
        Class p=Persons.class;//反射的源头
        //创建Class对应的运行时类Persons类的对象
        Persons persons = (Persons)p.newInstance();
        Field field = p.getField("name");//公共的类型
        field.set(persons,"hhh");
        System.out.println(persons);
        //调用私有的
        Field field1 = p.getDeclaredField("name");//
        field1.set(persons,"嘻嘻");
        System.out.println(persons);
        //调用wucan方法
        Method method = p.getMethod("show");
        method.invoke(persons);

        Method method1 = p.getMethod("display", String.class);
        method1.invoke(persons,"hainan");
    }
    //在反射以前,如何创建一个类的对象,并调用其中的方法和属性
    @Test
    public void test1(){
        Persons persons = new Persons();
        persons.setAge(10);
        persons.setName("哈哈");
        System.out.println(persons);
        persons.show();
        persons.display("上海");
    }

    /*public static void main(String[] args) {

    }*/
}
