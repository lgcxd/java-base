package com.company.Bank4;

/**
 * @Author: chenbj
 * @Description: 银行类
 * @Date: 2018/5/24 16:07
 * @Version:
 */
public class Bank {
    private Customer[] customers;//存放客户
    private int numberofCustomer;
    public Bank(){
        customers = new Customer[5];
    }
    //添加一个客户到数组中
    public void addCustomer(String name){
        Customer customer = new Customer(name);
        customers[numberofCustomer] = customer;
        numberofCustomer++;
    }
    //获取客户的记录的数量
    public int getNumberofCustomer() {
        return numberofCustomer;
    }
    //获取指定索引下的客户
    public Customer gerCustomer(int index){
        return customers[index];
    }
}
