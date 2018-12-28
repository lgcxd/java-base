package com.java8;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/28 15:30
 * @Version:
 */
public class Employee {
    private String name;
    private int age;
    private double money;

    public Employee() {
    }

    public Employee(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
