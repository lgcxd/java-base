package com.testJava8;

import java.util.*;
import java.util.stream.Collectors;

import com.testJava8.Employee2.Status;
import org.junit.jupiter.api.Test;

/**
 * @ClassName B4
 * @Author: ChenBJ
 * @Description: 终止操作
 * @Date: 2018/8/16 16:21
 * @Version:
 */
public class B4 {
    List<Employee2> emps = Arrays.asList(
            new Employee2(100,"张三",18,1234.9, Status.BUSY),
            new Employee2(101,"小李",38,18954.9, Status.FREE),
            new Employee2(102,"小胡",42,8567.55, Status.VOCATION),
            new Employee2(103,"小马",78,7859.5, Status.VOCATION),
            new Employee2(104,"小赖",58,8855.33, Status.FREE),
            new Employee2(105,"张三",20,18569.9, Status.BUSY),
            new Employee2(106,"小王",20,18569.9, Status.BUSY)

    );
    /* 归约
        reduce(T identity,BinaryOperator) / reduce(BinaryOperator) -- 可以将流中元素反复结合起来,得到一个值*/
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream()
                .reduce(0,(x,y)->x+y);
        System.out.println(sum);
        //工资总和
        Optional<Double> op = emps.stream()
                .map(Employee2::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }
    //需求:搜索名字中"小"出现的次数
    @Test
    public void test2(){
        Optional<Integer> sum = emps.stream()
                .map(Employee2::getName)
                .flatMap(B2::filterCharacter)
                .map((ch) -> {
                    if(ch.equals('小'))
                        return 1;
                    else
                        return 0;
                }).reduce(Integer::sum);

        System.out.println(sum.get()); // 5
    }
    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test3(){
        List<String> list = emps.stream()
                .map(Employee2::getName)
                .collect(Collectors.toList());//以list形式获取该实例中的名称
        list.forEach(System.out::println);

        System.out.println("-------这个是set形式接收-------");
        Set<String> set = emps.stream()
                .map(Employee2::getName)
                .collect(Collectors.toSet());//以set形式获取该实例中的名称 去重
        set.forEach(System.out::println);

        System.out.println("---------HashSet形式接收---------");
        HashSet<String> hs = emps.stream()
                .map(Employee2::getName)
                .collect(Collectors.toCollection(HashSet::new)); //以HashSet形式获取该实例中的名称 去重
        hs.forEach(System.out::println);

    }
    @Test
    public void test4(){
        Optional<Double> max = emps.stream()
                .map(Employee2::getSalary)
                .collect(Collectors.maxBy(Double::compare));
        System.out.println(max.get());//求这个实例中薪资最高值

        Optional<Employee2> op = emps.stream()
                .collect(Collectors.minBy((e,e2)->Double.compare(e.getSalary(),e2.getSalary())));
        System.out.println(op.get());//求这个实体中薪资最低的员工信息

        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee2::getSalary));
        System.out.println(sum);//求实例中薪资的总和

        Double avg =emps.stream()
                .collect(Collectors.averagingDouble(Employee2::getSalary));
        System.out.println(avg);//求平均薪资

        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println(count);//实例的个数

        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee2::getSalary));
        System.out.println(dss.getMax());//获得薪资最大值
    }
    //以状态分组
    @Test
    public void test5(){
        Map<Status,List<Employee2>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee2::getStatus));
        System.out.println(map);
    }
    //多级分组  先状态分组,再年龄分组
    @Test
    public void test6(){
        Map<Status,Map<String,List<Employee2>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee2::getStatus,Collectors.groupingBy((e)->{
                    if (e.getAge()>60)
                        return "老年";
                    else if (e.getAge()>=35)
                        return "中年";
                    else
                        return "成年";
                })));
        System.out.println(map);
    }
    //分区 大于5000薪资的为一个区
    @Test
    public void test7(){
        Map<Boolean,List<Employee2>> map = emps.stream()
                .collect(Collectors.partitioningBy((e)->e.getSalary()>=5000));
        System.out.println(map);
    }
    //获取实例的所有名字,并且用,号分开  一个,号就是每个名字后面都会添加一个 结果:张三,小李,小胡,小马,小赖,张三,小王
    // 三个参数时  结果:====张三,小李,小胡,小马,小赖,张三,小王====
    @Test
    public void test8(){
        String str = emps.stream()
                .map(Employee2::getName)
                .collect(Collectors.joining(",","====","===="));
        System.out.println(str);
    }
    //获取实例薪资的总和2
    @Test
    public void test9(){
        Optional<Double> sum = emps.stream()
                .map(Employee2::getSalary)
                .collect(Collectors.reducing(Double::sum));
        System.out.println(sum.get());
    }
   /* 给定一个数字列表,如何返回一个由每个数的平方构成的列表呢?
    给定一个数组 [ 1,2,3,4,5] 结果为[1,4 9 16,25]*/
   @Test
   public void test10(){
       Integer[] num = new Integer[]{1,2,3,4,5};
       Arrays.stream(num)
               .map((e)-> e * e)
               .forEach(System.out::println);
   }
    //怎样用map和reduce 方法数一数流中有多少个Employee2
    @Test
    public void test11(){
       Optional<Integer> count = emps.stream()
               .map((e)->1)
               .reduce(Integer::sum);
        System.out.println(count.get());
    }
}
