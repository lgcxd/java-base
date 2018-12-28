package com.company.bank3;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 15:16
 * @Version:
 */
public class TestBank {
    public static void main(String[] args) {
        Account account = new SavingAccount(500,0.03);//对象账户,利率
        Bank bank = new Bank();//银行对象

        bank.addCostomer("嘻嘻","和");//添加顾客
       // bank.getCustomer(0);//获取到这个人
        Customer customer;
        customer=bank.getCustomer(0);
        customer.setAccount(account);
        System.out.println(customer.getFirstName()+customer.getLastName()+account.withdraw(1200));

        bank.addCostomer("owen","simth");
        customer=bank.getCustomer(1);
        customer.setAccount(account);
        System.out.println(customer.getFirstName()+customer.getLastName()+account.withdraw(20));

        bank.addCostomer("tim","tony");
        customer = bank.getCustomer(2);
        account = new CheckingAccount(500,2000);
        customer.setAccount(account);
        System.out.println(customer.getFirstName()+customer.getLastName()+account.withdraw(200));

        bank.addCostomer("tom","tony");
        customer = bank.getCustomer(3);
        customer.setAccount(account);
        System.out.println(customer.getFirstName()+customer.getLastName()+account.withdraw(200));

        bank.addCostomer("tom","toly");
        customer = bank.getCustomer(4);
        account = bank.getCustomer(1).getAccount();//2和他用一个账户
        customer.setAccount(account);
        System.out.println(customer.getFirstName()+customer.getLastName()+account.withdraw(2000));
    }
}
