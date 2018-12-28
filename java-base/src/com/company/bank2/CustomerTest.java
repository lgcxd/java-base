package com.company.bank2;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 14:22
 * @Version:
 */
public class CustomerTest {
    public static void main(String[] args) {
        Account account = new Account(600);
        Customer customer = new Customer("jony","taly");
        customer.setAccount(account);//accout=null 会报空指针异常
        System.out.println("名字为"+customer.getFirstName()+customer.getLastName()+
                customer.getAccount().getpost(20));
    }
}
