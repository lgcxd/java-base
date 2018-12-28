package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description: 让权
 * @Date: 2018/5/18 14:31
 * @Version:
 */
public class MyThread2 extends Thread{
    MyThread2(String s){
        super(s);
    }
    @Override
    public void run(){
        for (int i = 1; i < 20 ; i++) {
            System.out.println("线程"+getName()+i);
            if (i % 10 == 0){
                yield();//执行到10的备注是让权
            }
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2("bb:");
        MyThread2 myThread2 = new MyThread2("aa:");
        myThread.start();
        myThread2.start();
    }
}
