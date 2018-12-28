package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description: //调用Thread对象的join方法挂起主线程
 * @Date: 2018/5/18 14:47
 * @Version:
 */
public class JoinThread extends Thread {
    /*
    *调用join方法(合并某个线程)
    * 处于"执行状态"的线程如果调用了其他线程join方法,将被挂起进入"阻塞状态
    * 目标线程执行完毕后才会解除阻塞,回到"可执行状态"
    * 执行I/O操作
    * 线程在执行过程中如果因为访问外部资源(等待用户键盘输入,访问网络)时发生阻塞,也导致当前线程进入阻塞状态
    *
    * 解除阻塞
    * 睡眠状态超时
    * 调用join后等待其他线程执行完毕
    * I/O操作执行完毕
    * 调用阻塞线程的interrupt方法(线程睡眠时,调用该线程的interrupt方法会抛出InterruptedException)
    * */
    private int no;//线程编号
    public JoinThread(int no){
        this.no = no;
    }

    //重写父类的run方法
    @Override
    public void run() {
        for (int i = 0; i <= 50 ; i++) {
            System.out.println(no);
        }
    }

    public static void main(String[] args) {
        //创建线程
        JoinThread joinThread = new JoinThread(12);
        joinThread.start();//启动线程
        try{
            //调用Thread对象的join方法挂起主线程
            joinThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        for (int i = 0; i <= 50 ; i++) {
            System.out.println("我是老大主线程"+Thread.currentThread().getName());
        }
        System.out.println("执行结束!!!!!");
    }
}
