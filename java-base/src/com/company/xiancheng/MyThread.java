package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description: 继承Thread类
 * @Date: 2018/5/18 13:44
 * @Version:
 */
public class MyThread extends Thread{
    /**
     * 进程是程序的一次执行过程,是系统运行程序的基本单位,进程是动态的.
     * 线程是进程中负责程序执行的执行单元(进程的最小单元)
     * 进程执行中的程序(一个进程至少包含一个线程)
     * 单线程:程序中只存在一个线程,即主线程
     * 多线程:在一个程序中运行多个任务
     * 目的:是更好的利用cpu资源
     * run方法执行定义需要执行的任务(调用线程用start()方法,不能用run()因为run方法不会创建线程他会直接在主线程中运行)
     * 为何要多线程:开发高并发系统的基础,利用好多线程机制可以大大提高系统整体的并发能力以及性能.
     * 为什么提倡多线程而不是多进程:线程就是轻量级的进程,是程序执行的最小单位.线程间的切换和调度成本远远小于进程.
     */
    @Override
    public void run(){
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("线程"+getName()+"正在打印"+i);
        }
        System.out.println("执行完毕");
    }

    public static void main(String[] args) {
        //获取当前线程的名字
        String name = Thread.currentThread().getName();
        System.out.println(name+"--开始执行中"); //主线程

        for (int i = 0; i <= 10 ; i++) {
            System.out.println("线程"+name+"正在打印"+i);
        }
        System.out.println(name+"--执行完毕" + "线程id--"+Thread.currentThread().getId()); //主线程执行完毕

        MyThread myThread2 = new MyThread();
        myThread2.run();
        System.out.println(myThread2.getName()+"----" +myThread2.getId());

        //创建线程对象
        MyThread myThread = new MyThread();
        //启动线程

        myThread.start();//thread-0
        System.out.println("开始执行中--"+myThread.getName()+"线程id--"+myThread.getId());


    }
}
