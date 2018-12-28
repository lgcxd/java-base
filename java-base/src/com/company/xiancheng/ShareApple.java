package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description: 演示共享对象时出现的问题
 * 问题：通过多线程解决小朋友分苹果的问题：一共有5个苹果，2个小朋友同时拿苹果，每次拿一个，拿完为止
 * @Date: 2018/5/21 15:54
 * @Version:
 */
public class ShareApple implements Runnable {
    //苹果数
    private int appleCount = 5;
    //控制线程运行的标识
    private boolean isRun = true;
    //取苹果的方法
    public boolean getApple(){
        if (appleCount == 0){
            return false;
        }
        //每次减少一个
        appleCount--;
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if(appleCount >= 0){
            System.out.println(Thread.currentThread().getName()+"小朋友拿走了一个苹果,还剩"+appleCount+"个苹果");
        }else {
            System.out.println(Thread.currentThread().getName()+"发现没有苹果了");
        }
        return true;
    }

    @Override
    public void run() {
        while (isRun){
            isRun = getApple();
        }
        if (appleCount <= 0){
            System.out.println(Thread.currentThread().getName()+"线程进入死亡状态");
            return;
        }
    }

    public static void main(String[] args) {
        //创建ShareApple对象
        ShareApple shareApple = new ShareApple();
        Thread thread = new Thread(shareApple);
        thread.setName("小名");
        Thread thread1 = new Thread(shareApple);
        thread.setName("小强");
        //启用线程对象
        thread.start();
        thread1.start();
    }
}
