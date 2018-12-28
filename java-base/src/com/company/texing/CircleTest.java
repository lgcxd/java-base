package com.company.texing;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 15:10
 * @Version:
 */
public class CircleTest extends Circle {
    private double height;
    @Override
    public double tiarea(){//重写方法必须和被重写方法的方法名相同 参数列表相同 返回值类型相同
        //重写方法的权限不能比被重写方法更严格(否则报非法错误)
        double area = 3.14 * getRedius() * getRedius();
        return area;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public static void main(String[] args) {
        CircleTest circleTest = new CircleTest();
        circleTest.setRedius(4);
        circleTest.setHeight(2);
        System.out.println("体积"+circleTest.tiarea());
    }
}
