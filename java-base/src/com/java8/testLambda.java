package com.java8;

import org.junit.jupiter.api.Test;

import java.util.*;


/**
 * @Author: ChenBJ
 * @Description:
 * @Date: 2018/5/28 15:10
 * @Version:
 */
public class testLambda {
    //
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<Integer>(com);
    }
    //lambda 表达式
    @Test
    public void test2(){
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<Integer>(comparable);
    }
    List<Employee> employees = Arrays.asList(
            new Employee("张三",13,2323.33),
            new Employee("李四",17,1234.22),
            new Employee("王五",20,2323.33),
            new Employee("赵六",30,2323.33),
            new Employee("喝喝",45,6666.12),
            new Employee("嘻嘻",45,10000.23)
    );
    //需求:获取当前公司的工龄大于35
     /* @Test
    public void test3(){
        List<Employee> list = employees1(employees);
        for (Employee e : list) {
            System.out.println(e);
        }
    }
  public List<Employee> employees1(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp:list) {
            if (emp.getAge()>=35){
                emps.add(emp);
            }
        }
        return emps;
    }
    //需求:获取工资5000以上的信息
    public List<Employee> employees2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp:list) {
            if (emp.getMoney()>=5000){
                emps.add(emp);
            }
        }
        return emps;
    }*/
    //优化1.策略设计模式
  /*  @Test
    public void test4(){
        List<Employee> list =fileEmp(employees,new File2());
        for (Employee e:list
             ) {
            System.out.println(e);
        }
    }*/
    public List<Employee> fileEmp(List<Employee> list,Mypr<Employee> mp){
        List<Employee> employees = new ArrayList<>();
        for (Employee e: list) {
            if (mp.test(e)){
                employees.add(e);
            }
        }
        return employees;
    }
    //优化方式2:匿名内部类
    @Test
    public void test5() {
        List<Employee> list = fileEmp(employees,new Mypr<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getMoney()>=5000;
            }
        });
        for (Employee e: list) {
            System.out.println(e);
        }
    }
    //优化3:Lambda
    @Test
    public void test6(){
       List<Employee> list=fileEmp(employees,(e)->e.getMoney()>=5000);
       list.forEach(System.out::println);
    }
    //优化4:Stream API(上面什么都没有,除了实体类和集合)
    @Test
    public void test7(){
        employees.stream()
                .filter((e)->e.getMoney()>=5000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("--------------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }
}
