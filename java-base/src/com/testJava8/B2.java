package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName B2
 * @Author: ChenBJ
 * @Description: Stream API
 * @Date: 2018/8/15 14:26
 * @Version:
 */
public class B2 {
    //中间操作
    /*筛选与切片
        filter --接收Lambda,从流中排除某些元素
        limit -- 截断流,使元素不超过给定数量.
        skip(n) -- 跳过元素,返回一个扔掉了前n个的元素,若流中元素不足n个,则返回一个空流,与limit(n)互补
        distinct -- 筛选,通过流所生成元素的HashCode()和 equals() 去除重复元素(重写)
    */
    List<Employee> emp = Arrays.asList(
            new Employee("张三",18,1234.9),
            new Employee("小李",38,18954.9),
            new Employee("小胡",42,8567.55),
            new Employee("小马",78,7859.5),
            new Employee("小赖",58,8855.33),
            new Employee("张三",20,18569.9),
            new Employee("小王",20,18569.9)

    );
    //内部迭代:StreamAPI 完成
    @Test
    public void test1(){
        //中间操作:不会执行任何操作(实例中年龄大于35的员工信息)
        Stream<Employee> s1 =emp.stream()
                .filter((e)->{
                    System.out.println("中间操作");
                    return e.getAge()>35;
                });
        //终止操作:一次性执行全部内容,即惰性求职
        s1.forEach(System.out::println);
    }
    //外部迭代
    @Test
    public void test2(){
        Iterator<Employee> a = emp.iterator();//Iterator 迭代器
        while(a.hasNext()){
            System.out.println(a.next());
        }
    }

    @Test
    public void test3(){
        emp.stream()
                /*.filter((e)->e.getSalary()>5000)*/
                .filter((e)->{
                    System.out.println("duanlu");
                    return  e.getSalary()>=5000;
                })
                .limit(3) //截取前三条数据 skip(2)截取后面的两条数据
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
        emp.stream()
                /*.filter((e)->e.getSalary()>5000)*/
                .filter((e)->{
                    System.out.println("短路");
                    return  e.getSalary()>=5000;
                })
                .distinct() //去重 实体类必须重写HashCode和equals 否则去不掉
                .forEach(System.out::println);
    }

    //映射
    //map --接收Lambda 将元素转换成其他形式或提取信息.接收一个函数作为参数,该函数会被应用到每个元素上,并将其映射成一个新的元素.
    //flatMap --接收一个函数作为参数,将流中的每个值都换成另一个流,然后把所有流连接成一个流
    @Test
    public void test5(){
        List<String> list = Arrays.asList("aaa","aaawwe","ccc","wewrw");

        list.stream()
                .map((str)->str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("---------------------");
        emp.stream()
                //.map((str)->str.getName())
                .map(Employee::getName)
                .distinct()
                .forEach(System.out::println);

        System.out.println("---------------------");

        Stream<Stream<Character>> ss = list.stream()
                .map(B2::filterCharacter);//{{a,a,a},{b,b,b}....}
        //遍历流
        ss.forEach((sm) -> sm.forEach(System.out::println));
        System.out.println("---------------------");

        Stream<Character> stream = list.stream()
                .flatMap(B2::filterCharacter);//{a,a,a,b,b,b........}
        stream.forEach(System.out::println);
    }
    //拆分成单个字符方法
    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
    /* sorted()-- 自然排序
    *  sorted(Comparator com) -- 定制排序
    *  */
    @Test
    public void test6(){
        emp.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);
        System.out.println("-------定制排序------");
        emp.stream()
                .sorted((x,y)->{
            if (x.getAge().equals(y.getAge())){
                return x.getName().compareTo(y.getName());
            }else {
                return x.getAge().compareTo(y.getAge());
            }
        }).forEach(System.out::println);
    }

}
