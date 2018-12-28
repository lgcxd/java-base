package com.company.bank3;

/**
 * @Author: chenbj
 * @Description: 储蓄账户
 * @Date: 2018/5/23 15:01
 * @Version:
 */
public class SavingAccount extends Account {
    private double interestRate;//利率
    public SavingAccount(double rate,double balance){
        super(balance);
        this.interestRate = rate;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
