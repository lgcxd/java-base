package com.java8;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/28 16:30
 * @Version:
 */
public class File2 implements Mypr<Employee> {
    @Override
    public boolean test(Employee employee){
        return employee.getMoney()>=5000;
    }
}
