package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description:  睡眠超时
 * @Date: 2018/5/18 15:16
 * @Version:
 */
public class InterruptThread extends Thread {
   /*
   * 线程生命周期方法:
   * 解除阻塞
   * 睡眠超时
   * 调用join后等待其他线程执行完毕
   * I/O操作执行完毕
   * 调用阻塞线程的interrupt方法(线程睡眠时,调用该线程的interrupt方法会抛出InterruptdException)*/
    public void run() {
        try{
            sleep(10000000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        //线程睡眠一段时间后打印5个数
        for (int i = 0; i <= 5 ; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        InterruptThread thread = new InterruptThread();
        thread.start();
        //调用睡眠线程(叫醒睡眠线程)
        thread.interrupt();
    }
}
