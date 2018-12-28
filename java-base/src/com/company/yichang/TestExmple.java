package com.company.yichang;

import java.time.Year;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/16 16:49
 * @Version:
 */
public class TestExmple {
    /*
    * 常见异常:
    * RuntimeException
错误的类型转换
数组下标越界
空指针访问
IOExeption
从一个不存在的文件中读取数据
越过文件结尾继续读取
连接一个不存在的URL
*/
    int i=1;
    int x;
    public static void main(String[] args) {
        /*String names[] = {"lili","画画","嘻嘻"};
        for(int i= 0;i<5;i++){
            System.out.println(names[i]);//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
        }
        System.out.println("\nthis is the end");*/
        /* TestExmple t=new TestExmple();
         t=null;
        System.out.println(t.i);//Exception in thread "main" java.lang.NullPointerException*/
        int y;
        TestExmple testExmple = new TestExmple();
        y = 3/testExmple.x;//Exception in thread "main" java.lang.ArithmeticException: / by zero
        System.out.println("program ends ok!");
    }
}
