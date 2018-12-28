package com.company.texing;

/**
 * @Author: chenbj
 * @Description: 圆的面积和周长
 * @Date: 2018/5/14 15:07
 * @Version:
 */
public class Circle {
    private double redius;//private修饰符 作用在整个类

    public double tiarea(){
        double area = 3.14 * redius * redius;
        return area;
    }
    public double lengths(){
        double lengths = 3.14 * 2 * redius;
        return lengths;
    }
    public double getRedius() {
        return redius;
    }
    public void setRedius(double redius) {
        this.redius = redius;
    }
}
