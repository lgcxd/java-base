package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description: sleep睡眠时间
 * @Date: 2018/5/18 14:42
 * @Version:
 */
public class SleepThread extends  Thread{
    public void run(){
        while (true){
            System.out.println("每隔一秒输出一次.....");
            try{
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepThread sleepThread = new SleepThread();
        sleepThread.start();
    }
}
