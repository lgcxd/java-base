package com.company.bank2;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 14:15
 * @Version:
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(500);
        System.out.println(account.getpost(12));
        System.out.println(account.withdraw(600));
        System.out.println(account.withdraw(400));
    }
}
