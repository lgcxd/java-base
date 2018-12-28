package com.java8;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/28 16:18
 * @Version:
 */
public class File implements Mypr<Employee> {
    @Override
    public boolean test(Employee employee){
        return employee.getAge()>=35;
    }
}
