package com.company.texing;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/16 11:49
 * @Version:
 */
public class StaticPersonTest {
    public static void main(String[] args) {
        System.out.println("总数为"+StaticPerson.getTotal());//没有创建对象 访问静态成员和方法  类名.方法名()的方式访问

        StaticPerson staticPerson = new StaticPerson();
        staticPerson.setTotal(100);
        System.out.println("总数为"+staticPerson.getTotal());

        System.out.println("总数"+StaticPerson.total2);
        System.out.println("总数"+StaticPerson.total2);
    }
}
