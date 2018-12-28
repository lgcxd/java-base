package com.company.bank2;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 14:10
 * @Version:
 */
public class Account {
    private double balance;
    public Account(double init_balance){
        balance = init_balance;
    }
    //存钱
    public boolean getpost(double amt){
        balance += amt;
        System.out.println(balance);
        return true;
    }
    //取钱
    public boolean withdraw(double amt){
        if(amt >balance){
            System.out.println("余额不足,请查询后取钱!");
            System.out.println(balance);
            return false;
        }else {
            balance -= amt;
            System.out.println(balance);
            return true;
        }
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
