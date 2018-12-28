package com.company.duixiang;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 14:31
 * @Version:
 */
public class PersonThreeTest {
    public static void main(String[] args) {
        PersonThree personThree = new PersonThree("huihui",12);
        System.out.println(personThree.getName()+personThree.getAge());
        System.out.println(personThree.getName()+personThree.getAge()+personThree.getBirthDate());
    }
}
