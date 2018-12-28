package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description: Runnable实现
 * @Date: 2018/5/18 14:11
 * @Version:
 */
public class MyRunnable implements Runnable{
    //实现Runnable接口的run方法
    @Override
    public void run(){
        //获取当前线程的名字
        String name = Thread.currentThread().getName();
        for (int i = 0; i <= 100; i++) {
            System.out.println("线程--"+name+"正在打印"+i);
        }
    }

    public static void main(String[] args) {
        /*
        线程的运行状态:
        新建（New）
        可执行（Runnable）:即线程调用了start()方法,拥有了cpu控制权,处在等待调度阶段
        运行（Running):获得cpu后转换为执行状态,可以调用yield方法(让线程让出cpu处于等待调度阶段)
        阻塞（Blocking):由于受某些条件的影响会被迫让权,进入阻塞状态(调用sleep(毫秒)方法,调用join方法,执行I/O操作)
        死亡（Dead)
        */
        //获取当前线程的名字
        String name = Thread.currentThread().getName();
        System.out.println("正在执行的线程"+name);
        //创建线程运行的目标对象
        MyRunnable myRunnable = new MyRunnable();
        //myRunnable.run();

        //创建线程对象1
        Thread thread = new Thread();
        //创建线程2
        thread.start();
        for (int i = 0; i <= 100 ; i++) {
            System.out.println("线程"+name+"正在打印"+i);
        }
        System.out.println(name+"执行完毕");
    }
}
