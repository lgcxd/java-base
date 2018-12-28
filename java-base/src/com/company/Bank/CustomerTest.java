package com.company.Bank;


/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 13:33
 * @Version:
 */
public class CustomerTest {
    public static void main(String[] args) {
       Account account = new Account(500);
       Customer customer = new Customer("lily" ,"harry");
       customer.setAccount(account);
       customer.getAccount().deposit(12);
        System.out.println(customer.getFirstName());
        customer.getAccount().withdraw(200);
        System.out.println(customer.getFirstName());
        customer.getAccount().query();
    }
}
