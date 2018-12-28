package com.company.bank2;

import com.company.texing.NeiBuLei;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 14:37
 * @Version:
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCostomer("herry","lily");
        bank.addCostomer("herry" ,"sili");
        bank.addCostomer("haha","caoxi");
        bank.addCostomer("hele" ,"sili");
        bank.addCostomer("xixi","caoxi");
        for (int i = 0; i < bank.getNumber() ; i++) {
            Customer customer = bank.getCustomer(i);
            System.out.println("Customer["+(i+1)+"]is"+customer.getLastName()+","+customer.getFirstName());
        }

    }
}
