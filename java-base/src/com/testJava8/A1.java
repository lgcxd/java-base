package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName A1
 * @Author: ChenBJ
 * @Description: java8新特性的学习
 * @Date: 2018/8/14 14:24
 * @Version:
 */
public class A1 {
    /*为什么使用Lambda表达式
    * 是一个匿名函数,一段可以传递的代码*/
    //匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o,Integer o2) {
                return Integer.compare(o,o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<Integer>(com);
    }
    /**
     * @Author: ChenBJ
     * @Description: Lambda 表达式
     * @Date: 2018/9/3 10:31
     * @Param:
     * @return:
     */
    @Test
    public void test2(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        TreeSet<Integer> treeSet = new TreeSet<Integer>(com);
    }
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,1234.9),
            new Employee("小李",38,18954.9),
            new Employee("小胡",42,8567.55),
            new Employee("小马",78,7859.5),
            new Employee("小赖",58,8855.33),
            new Employee("张三",20,18569.9)

    );
    /*需求:获取当前公司员工的年龄大于35的信息*/
    @Test
    /*public void test3(){
        List<Employee> list = testMaxInfo(employees);
        for (Employee e:list) {
            System.out.println(e);
        }
    }*/
    //方法
    public List<Employee> testMaxInfo(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp:list) {
            if (emp.getAge()>=35){
                emps.add(emp);
            }
        }
        return emps;
    }
    /**需求:获取当前公司员工的薪资大于2000的信息
    * 感觉和上边的方法类似,区别就一句话,代码冗余*/
    public List<Employee> testMaxInfo2(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp:list) {
            if (emp.getSalary()>=2000){
                emps.add(emp);
            }
        }
        return emps;
    }
   /**优化方式1:策略模式优化
   缺点:每一个方法需要写一个新的接口类*/
    @Test
    public void  test4(){
        List<Employee> list = filterEmployee(employees,new FilterEmployeeByX());
        for (Employee e:list) {
            System.out.println(e);
        }

        System.out.println("---------------------------");
        List<Employee> list1 = filterEmployee(employees,new FileEmployeeByY());
        for (Employee e: list1) {
            System.out.println(e);
        }
    }
    /**
     * 只需要这一个方法 策略设计模式*/
    public List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mp){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp:list) {
            if (mp.test(emp)){
                emps.add(emp);
            }
        }
        return emps;
    }

    /**优化方式二:匿名内部类*/
    @Test
    public void  test5(){
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary()>=2000;
            }
        });
        for (Employee e:list) {
            System.out.println(e);
        }
    }
    /** 优化方式三:Lambda 表达式
    * */
    @Test
    public void  test6(){
        List<Employee> list = filterEmployee(employees,(e)->e.getSalary()>=5000);
        list.forEach(System.out::println);
    }

    /**优化方式四:当什么方法都没写的前提下,使用streamAPI*/
    @Test
    public void  test7(){
        employees.stream()
                .filter((e)->e.getSalary() >= 5000)
                .forEach(System.out::println);
    }
}
