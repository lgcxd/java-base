package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName B1
 * @Author: ChenBJ
 * @Description: StreamAPI 流概念 对数据传输操作
 * @Date: 2018/8/15 13:53
 * @Version:
 */
public class B1 {
    /*数据源
    * 集合 数组等  转化为流 一系列流水线式的中间操作  将产生新的结果数据流 不影响数据源
    * 三步操作步骤
    * 1.创建Stream
    * 2.中间操作
    * 3.终止操作
    * */
    //创建Stream
    @Test
    public void test1(){
        //1.通过Collection系列集合提供的Stream()或 paralleStream()并行流
        List<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream(); //获取流

        //2,通过Array中的静态方法stream() 获取数组流
        Employee[] e = new Employee[10];
        Stream<Employee> s2 = Arrays.stream(e); //数组 Arrays.Stream(e)

        //3.通过Stream类中的静态方法 of()  创建对象
        Stream<String> s3 = Stream.of("Aa","sss","sfaw");//创建对象

        //4.创建无限流
        //迭代
       Stream<Integer> s4 = Stream.iterate(0,(x)->x+2);
        //s4.forEach(System.out::println);
        s4.limit(10).forEach(System.out::println);//遍历    s4.limit(10).中间操作 提取前10条

        //生成
        Stream.generate(()->Math.random()).limit(5).forEach(System.out::println);
    }
}
