package com.company.Bank4;

/**
 * @Author: chenbj
 * @Description: 信用卡类
 * @Date: 2018/5/24 16:23
 * @Version:
 */
public class CheckingAccount extends Account {
    private double pritection;//透支额度
    public CheckingAccount(double balance){
        super(balance);
    }
    public CheckingAccount(double balance,double protection){
        super(balance);
        this.pritection = protection;
    }
    //取钱
    @Override
    public boolean withdraw(double amt) {
        if (balance>amt){
            balance -= amt;
            System.out.println("账户剩余"+balance);
            return true;
        }if (pritection >(amt-balance)){
            pritection -= (amt -balance);
            System.out.println("信用卡剩余"+pritection);
            return true;
        }else {
            System.out.println("余额不足，不够透支，请查询后再取！");
            return false;
        }
    }

    public double getPritection() {
        return pritection;
    }
}
