package com.testJava8;

/**
 * @ClassName FilterEmployeeByX
 * @Author: ChenBJ
 * @Description: 实现类
 * @Date: 2018/8/14 15:14
 * @Version:
 */
public class FilterEmployeeByX implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee t){
        return t.getAge()>=35;
    }
}
