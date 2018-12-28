package com.company.Bank4;


/**
 * @Author: chenbj
 * @Description: 客户类
 * @Date: 2018/5/24 15:56
 * @Version:
 */
public class Customer {
    private String name;//姓名
    //private Account account;//账户
    private Account[] account;
    private int accountNumber;
    public Customer(String n){
        name = n;
        account = new Account[5];
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //添加一个账户到account数组
    public void addAccount(Account acct){
        account[accountNumber] = acct;
        accountNumber++;
    }
    //账户数
    public int getAccountNumber(){
        return accountNumber;
    }
    //返回指定索引的账户
    public Account getAccount(int index){
        return account[index];
    }
}
