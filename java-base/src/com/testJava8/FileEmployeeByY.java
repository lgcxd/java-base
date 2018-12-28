package com.testJava8;

/**
 * @ClassName FileEmployeeByY
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/14 15:22
 * @Version:
 */
public class FileEmployeeByY implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee t){
        return  t.getSalary() >= 2000;
    }
}
