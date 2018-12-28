package com.company.Bank;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 10:52
 * @Version:
 */
public class Account {

    private double balance;
    public Account(double init_balance){
        this.balance = init_balance;
    }
    //存钱
    public void deposit(double amt){
       balance += amt;
        System.out.println("存入成功---账户金额为"+balance);
    }
    //取钱
    public void withdraw(double amt){
      if(amt > balance){
          System.out.println("余额不足,请查询账户金额再取!");
      }else {
          balance -= amt;
          System.out.println("余额为"+balance);
      }
    }
    public void query(){
        System.out.println(balance);
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
