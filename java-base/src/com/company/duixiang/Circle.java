package com.company.duixiang;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 11:17
 * @Version:
 */
public class Circle {
    public double redius;
    public void area(){
        double area = 3.14 * redius * redius;
        System.out.println("圆的面积为"+area);
    }
    public void perime(){
        double perime = 2 * 3.14 * redius;
        System.out.println("圆的周长为"+perime);
    }
}
