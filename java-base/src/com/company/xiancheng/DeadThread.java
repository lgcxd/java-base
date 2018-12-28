package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description: 判断线程是否活着
 * @Date: 2018/5/18 15:23
 * @Version:
 */
public class DeadThread extends Thread{
    /**
    * 死亡状态:
    * 处于"执行状态"的线程一旦从run方法返回(无论是正常退出还是抛出异常),就会进入死亡状态
    * 已经死亡的线程不能重新运行,否则会抛出IllegalThreadStateException
    * 可以使用Thread类的isAlive方法判断线程是否活着*/
    @Override
    public void run() {
        for (int i = 0; i <= 3 ; i++) {
            System.out.println("正在执行...........");
        }
        try{
            sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeadThread deadThread = new DeadThread();
        System.out.println("未启动线程"+(deadThread.isAlive()?"正在活动":"没有活动"));//未启动线程没有活动
        deadThread.start();
        System.out.println("已启动线程"+(deadThread.isAlive()?"正在活动":"没有活动"));//已启动线程正在活动
        try{
            //挂起当前主线程,直到thread执行完毕
            deadThread.join();
        }catch (InterruptedException e){
           e.printStackTrace();
        }
        System.out.println("已终止"+(deadThread.isAlive()?"正在活动":"没有活动"));//已终止没有活动
    }
}
