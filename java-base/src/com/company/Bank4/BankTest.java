package com.company.Bank4;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.text.NumberFormat;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/24 16:30
 * @Version:
 */
public class BankTest {
    public static void main(String[] args) {
        NumberFormat cc=NumberFormat.getCurrencyInstance();
        Bank bank = new Bank();//new一个一行对象
        bank.addCustomer("祝天天");//给银行添加一个客户
        Customer customer;//客户对象
        customer = bank.gerCustomer(0);//获取第一个客户
        customer.addAccount(new SavingAccount(1000,0.3));//给客户添加一个账户
        customer.addAccount(new CheckingAccount(1000,1200));//给客户添加第二个账户
        customer.addAccount(new CheckingAccount(1300));//给客户添加第三个账户
        System.out.println("姓名为:"+customer.getName()+"**存储账户为--"+customer.getAccount(0).getBalance()+"||信用卡的余额为:"
                +customer.getAccount(1).getBalance()+"信用卡:"+customer.getAccount(2).getBalance());

        bank.addCustomer("紫凝");
        customer = bank.gerCustomer(1);
        customer.addAccount(new CheckingAccount(2000));
        System.out.println("姓名为"+customer.getName()+customer.getAccount(0).getBalance());

        bank.addCustomer("贾佳");
        customer = bank.gerCustomer(2);
        customer.addAccount(new SavingAccount(200,0.3));
        System.out.println(customer.getAccount(0).getBalance()+customer.getName());

        bank.addCustomer("米卡");
        customer = bank.gerCustomer(3);
        customer.addAccount(new SavingAccount(100,0.4));
        customer.addAccount(new CheckingAccount(1800));
        customer.addAccount(new CheckingAccount(1900,2000));
        System.out.println("姓名为:"+customer.getName()+"**存储账户为--"+customer.getAccount(0).getBalance()+"||信用卡的余额为:"
                +customer.getAccount(1).getBalance()+"信用卡:"+customer.getAccount(2).getBalance());

        bank.addCustomer("江夏");
        customer = bank.gerCustomer(4);
        customer.addAccount(new CheckingAccount(1700));
        System.out.println(customer.getName()+"账户为"+customer.getAccount(0).getBalance());

        for (int i = 0; i <=bank.getNumberofCustomer() ; i++) {
            customer = bank.gerCustomer(i);
            for (int j = 0; j <=customer.getAccountNumber() ; j++) {
                Account account = customer.getAccount(j);
                String account_type = "";
                if (account instanceof SavingAccount){
                    account_type="saving";
                }
                if (account instanceof  CheckingAccount){
                    account_type = "checking";
                }
            }
        }

    }
}
