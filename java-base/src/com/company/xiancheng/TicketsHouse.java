package com.company.xiancheng;

/**
 * @Author: chenbj
 * @Description: 售票
 * @Date: 2018/5/21 17:53
 * @Version:
 */
public class TicketsHouse implements Runnable {
    int fiveAmount = 1, tenAmout = 0, twentyAmout;

    public void run() {
        if (Thread.currentThread().getName().equals("张飞")) {
            saleTicket(20);
        } else if (Thread.currentThread().getName().equals("关羽")) {
            saleTicket(5);
        } else if (Thread.currentThread().getName().equals("刘备")) {
            saleTicket(5);
        }
    }

    private synchronized void saleTicket(int money) {
        if (money == 5) {
            fiveAmount = fiveAmount + 1;
            System.out.println("给" + Thread.currentThread().getName() + "入场券" + Thread.currentThread().getName() + "的钱正好");
        } else if (money == 20) {
            while (fiveAmount < 3) {
                try {
                    System.out.println("\n" + Thread.currentThread().getName() + "靠边等");
                    wait();
                    System.out.println("\n" + Thread.currentThread().getName() + "继续买票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            fiveAmount = fiveAmount - 3;
            tenAmout = tenAmout + 1;
            System.out.println("给" + Thread.currentThread().getName() + "入场券" + Thread.currentThread().getName() + "给20找15");

        }
        notifyAll();
    }

    public static void main(String[] args) {
        TicketsHouse ticketsHouse = new TicketsHouse();
        Thread thread = new Thread(ticketsHouse);
        thread.setName("张飞");
        Thread thread1 = new Thread(ticketsHouse);
        thread1.setName("关羽");
        Thread thread2 = new Thread(ticketsHouse);
        thread2.setName("刘备");

        thread.start();
        thread1.start();
        thread2.start();
    }

}

