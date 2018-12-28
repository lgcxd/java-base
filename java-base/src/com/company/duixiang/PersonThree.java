package com.company.duixiang;

import java.util.Date;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 14:16
 * @Version:
 */
public class PersonThree {
    private String name;
    private int age;
    private Date birthDate;
    //构造方法的重载
    public PersonThree(String name,int age,Date date){
        this.name = name;
        this.age = age;
        this.birthDate = date;
    }
    public PersonThree(String name,int age){
        this(name,age,null);//this.name = name,this.age = age,this.birthDate = null
    }
    public PersonThree(String name,Date date){
        this(name,30,date);
    }
    public PersonThree(String name){
        this(name,30);
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
