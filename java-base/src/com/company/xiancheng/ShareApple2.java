package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/21 17:22
 * @Version:
 */
public class ShareApple2 implements Runnable {
    private int appleCount = 5;//苹果数
    private boolean isRun = true;//控制线程运行的标识
    //取苹果的方法
    public synchronized boolean getApple(){
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
