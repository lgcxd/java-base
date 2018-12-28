package com.company.duixiang;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 11:29
 * @Version:
 */
public class Person1 {
    private String name;
    private int age;
    private int sex;
    public Person1(){//构造器 必须与类名相同.修饰符:public private protected
  /*
  * 构造器不是方法,没有返回值
  * */
        age = 18;
    }
    public void setAge(int a) {
        if (a<0 && a>130 ){
            System.out.println("年龄不存在");
            return;
        }
        age = a;
    }

    public int getAge() {
        return age;
    }
}
