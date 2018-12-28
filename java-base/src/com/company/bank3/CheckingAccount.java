package com.company.bank3;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 15:04
 * @Version:
 */
public class CheckingAccount extends  Account {
    private double OverdraftProtection;//透支额度
    public CheckingAccount(double balance){
        super(balance);
    }
    public CheckingAccount(double  balance,double overdraftProtection){
        super(balance);
        this.OverdraftProtection = overdraftProtection;
    }

    public double getOverdraftProtection() {
        return OverdraftProtection;
    }

    public void setOverdraftProtection(double overdraftProtection) {
        OverdraftProtection = overdraftProtection;
    }
    //取钱
    @Override
    public boolean withdraw(double amt){
        if(balance>=amt){
            balance-=amt;
            return true;
        }else if (OverdraftProtection >= amt-balance){
            OverdraftProtection-=(amt-balance);
            balance = 0;
            return true;
        }else {
            return false;
        }
    }
}
