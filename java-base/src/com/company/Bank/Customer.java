package com.company.Bank;


/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 13:26
 * @Version:
 */
public class Customer {
    private String firstName;
    private String lastName;
    private com.company.Bank.Account account;
    public Customer(String f, String l){
        firstName = f;
        lastName = l;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public com.company.Bank.Account getAccount() {
        return account;
    }
    public void setAccount(Account acc) {
        account = acc;
    }
}
