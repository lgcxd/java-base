package com.company.FanShe;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/25 11:17
 * @Version:
 */
public class Persons {
    public String name;
    private int age;

    public Persons() {
    }
    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println("我是一个好人!");
    }
    public void display(String nation){
        System.out.println("我是一个什么国际的"+nation);
    }
    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
