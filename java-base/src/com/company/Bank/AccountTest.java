package com.company.Bank;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 11:05
 * @Version:
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account=new Account(500);
        System.out.println(account.getBalance());
        account.deposit(12);
        account.withdraw(111);
        account.withdraw(600);
        account.query();
    }
}
