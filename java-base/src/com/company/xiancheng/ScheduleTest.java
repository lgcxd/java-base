package com.company.xiancheng;


/**
 * @Author: chenbj
 * @Description: 线程的优先级数字越大优先级越高
 * @Date: 2018/5/21 15:39
 * @Version:
 */
public class ScheduleTest extends Thread {
    private String name;
    public ScheduleTest(String name){
        this.name = name;
    }
    @Override
    public void run(){//重写父类的run方法
        for (int i = 0; i <= 1000 ; i++) {
            System.out.println("线程的名字--"+name+"输出:"+i);
        }
    }
    //重写父类的toString方法
    @Override
    public String toString(){
        return name;
    }

    public static void main(String[] args) {
        //输出主线程的优先级 5
        System.out.println("主线程的优先级--:"+Thread.currentThread().getPriority());
        //创建两个线程对象
        ScheduleTest scheduleTest = new ScheduleTest("画画");
        ScheduleTest scheduleTest1 = new ScheduleTest("天天");
        //输出两个对象的优先级 5 5
        System.out.println("线程"+scheduleTest+"的优先级"+scheduleTest.getPriority());
        System.out.println("线程"+scheduleTest1+"的优先级"+scheduleTest1.getPriority());
        //设置第一个线程的优先级最低 1
        scheduleTest.setPriority(MIN_PRIORITY);
        //设置第二个线程的优先级最高 10
        scheduleTest1.setPriority(MAX_PRIORITY);
        //输出两个线程的优先级
        System.out.println("线程"+scheduleTest+"的优先级"+scheduleTest.getPriority());
        System.out.println("线程"+scheduleTest1+"的优先级"+scheduleTest1.getPriority());
        scheduleTest.start();//优先级高的先执行 (结果也不是一定的 优先级高的优先执行完)
        scheduleTest1.start();
    }
}
