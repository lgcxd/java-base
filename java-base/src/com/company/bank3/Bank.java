package com.company.bank3;


/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/23 14:28
 * @Version:
 */
public class Bank {
    private Customer[] customer;//用于存放客户
    private int numberCustomer;//记录账户人数
    public Bank(){
        customer = new Customer[5];
    }
    //添加一个customer到数组中
    public void addCostomer(String f,String l){
        Customer custome = new Customer(f,l);
        customer[numberCustomer] = custome;
        numberCustomer++;
    }
    //获取costomer的个数
    public int getNumber(){
        return numberCustomer;
    }
    //返回指定索引的costomer
    public Customer getCustomer(int index){
        return customer[index];
    }
}
