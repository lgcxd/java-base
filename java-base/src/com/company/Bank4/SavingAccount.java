package com.company.Bank4;

import javax.xml.soap.SAAJMetaFactory;

/**
 * @Author: chenbj
 * @Description: 储蓄账户类
 * @Date: 2018/5/24 16:18
 * @Version:
 */
public class SavingAccount extends Account {
    private double rate;//利率
    public SavingAccount(double balance,double rate){
        super(balance);
        this.rate = rate;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
}
