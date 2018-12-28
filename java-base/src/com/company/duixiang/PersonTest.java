package com.company.duixiang;

import com.company.duixiang.Person;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 11:00
 * @Version:
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "xianghua";
        person.age = 18;
        person.sex = 1;
        person.study();
        person.showAge();
        person.addAge(2);

        Person person1 = new Person();
        person1.name = "xiaomei";
        person1.age = 15;
        person1.sex = 2;
        person1.study();
        person1.showAge();
        person1.addAge(1);
    }
}
