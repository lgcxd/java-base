package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName A4
 * @Author: ChenBJ
 * @Description: java8中的四大核心的函数式接口
 * @Date: 2018/8/14 17:57
 * @Version:
 */
public class A4 {
    /*
    *   Consumer<T> 消费型接口
    *   void accept(T t)
    *
    *   Supplier<T> 供给性接口
    *   T get();
    *
    *   Function<T ,R> 函数型接口
    *   R apply(T t)
    *
    *   Predicate<T> 断言型接口
    *   boolean test(T t)
    * */
    //消费型
    @Test
    public void test1(){
        happy(1000,(m)-> System.out.println("嗨歌"+m));
    }
    public void happy(double money,Consumer<Double> com){
        com.accept(money);
    }
    //供给型接口
    @Test
    public void test2(){
        List<Integer> list = testSu(10,()->(int)(Math.random()*100));
        for (Integer num: list ) {
            System.out.println(num);
        }
    }
    /**需求:产生指定个数,并且放到集合中*/
    public List<Integer> testSu(int num, Supplier<Integer> su){
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<num;i++) {
            Integer n = su.get();
            list.add(n);
        }
        return list;
    }

    //函数型接口
    @Test
    public void  test3(){
        String ss = strTsr("\t\t\t 哈哈哈哈哈",(str)->str.trim());
        System.out.println(ss);
    }
    //用于处理字符串的需求
    public String strTsr(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    //断言型接口
    @Test
    public void  test4(){
        List<String> list = Arrays.asList("hahhahah","avawefdw","ha","xxxxxx");
        List<String> str = testStr(list,(s)->s.length()>3);
        for (String s: str) {
            System.out.println(s);
        }
    }
    //满足条件的字符串放入集合
    public List<String> testStr(List<String> list, Predicate<String> pre){
        List<String> listStr = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)){
                listStr.add(str);
            }
        }
        return listStr;
    }
}
