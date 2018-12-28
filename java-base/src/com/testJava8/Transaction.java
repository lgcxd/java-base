package com.testJava8;

import sun.dc.pr.PRError;

/**
 * @ClassName Transaction
 * @Author: ChenBJ
 * @Description: 交易类
 * @Date: 2018/8/17 13:17
 * @Version:
 */
public class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction() {
    }
    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader() {
        return trader;
    }
    public void setTrader(Trader trader) {
        this.trader = trader;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
