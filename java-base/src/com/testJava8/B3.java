package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.testJava8.Employee2.Status;

/**
 * @ClassName B3
 * @Author: ChenBJ
 * @Description: 流的终止操作
 * @Date: 2018/8/16 14:50
 * @Version:
 */
public class B3 {

    /*终止操作:
        allMath --检查是否匹配所有元素
        anyMath --检查是否至少匹配一个元素
        noneMath --检查是否没有匹配的元素
        findFirst --返回第一个元素
        findAny -- 返回流中任意元素
        count --返回流中元素的总个数
        max --返回流中最大值
        min --最小值
    */
    List<Employee2> emps = Arrays.asList(
            new Employee2("张三",18,1234.9, Status.BUSY),
            new Employee2("小李",38,18954.9, Status.FREE),
            new Employee2("小胡",42,8567.55, Status.VOCATION),
            new Employee2("小马",78,7859.5, Status.VOCATION),
            new Employee2("小赖",58,8855.33, Status.FREE),
            new Employee2("张三",20,18569.9, Status.BUSY),
            new Employee2("小王",20,18569.9, Status.BUSY)

    );
    @Test
    public void test1(){
        //全部匹配
        boolean b1 = emps.stream()
               .allMatch((e) -> {
                   System.out.println(e);
            return e.getStatus().equals(Status.BUSY);});
        System.out.println(b1);//false
        //任意一个匹配
        boolean b2 = emps.stream()
                .anyMatch((e)->e.getStatus().equals(Status.BUSY));
        System.out.println(b2);//true
        //是否没有匹配
        boolean b3 = emps.stream()
                .noneMatch((e)->e.getStatus().equals(Status.BUSY));
        System.out.println(b3);//false
        //返回第一个元素 防止空指针
        Optional<Employee2> op = emps.stream()
                .sorted((e,e2)->Double.compare(e.getSalary(),e2.getSalary()))
                .findFirst();
        System.out.println(op.get());
        //返回任意流
        Optional<Employee2> op2 = emps.parallelStream()  //parallelStream并行流
                .filter((e)->e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(op2.get());
        //流的总数
        long count = emps.stream()
                .filter((e)->e.getSalary()>0)
                .count();
        System.out.println(count);
        //最大值
        Optional<Double> d = emps.stream()
                .map(Employee2::getSalary)
                .max(Double::compare);
        System.out.println(d.get());
        //最小值
        Optional<Employee2> min = emps.stream()
                .min((e,e2)->Double.compare(e.getSalary(),e2.getSalary()));
        System.out.println(min.get());
    }
    //注意:流进行了终止操作后,不能再次使用
    //java.lang.IllegalStateException: stream has already been operated upon or closed
    @Test
    public void test4(){
        Stream<Employee2> s = emps.stream()
                .filter((e)->e.getStatus().equals(Status.FREE));
        long count = s.count();
        System.out.println(count);
        s.map(Employee2::getSalary)
                .max(Double::compare);
    }

}
