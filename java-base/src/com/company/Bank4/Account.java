package com.company.Bank4;


/**
 * @Author: chenbj
 * @Description: 账户类
 * @Date: 2018/5/24 15:48
 * @Version:
 */
public class Account {
    protected double balance;//账户余额
    public Account(double init_balance){//构造函数
        balance = init_balance;
    }
    //取钱
    public boolean withdraw(double amt){
        if (balance >=amt){
            balance-=amt;
            System.out.println(balance);
            return true;
        }else {
            System.out.println("余额不足,请查询后再取钱!");
            return false;
        }
    }
    //存钱
    public boolean getpost(double amt){
        balance+=amt;
        System.out.println(balance);
        return true;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
