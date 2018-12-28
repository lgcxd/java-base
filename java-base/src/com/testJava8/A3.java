package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName A3
 * @Author: ChenBJ
 * @Description: 练习Lambda 表达式
 * @Date: 2018/8/14 17:27
 * @Version:
 */
public class A3 {
    List<Employee> emp = Arrays.asList(
            new Employee("张三",18,1234.9),
            new Employee("小李",38,18954.9),
            new Employee("小胡",42,8567.55),
            new Employee("小马",78,7859.5),
            new Employee("小赖",58,8855.33),
            new Employee("张三",20,18569.9)

    );
    @Test
    public void  test1(){
        Collections.sort(emp,(e1,e2)->{
            if (e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee e : emp ) {
            System.out.println(e);
        }
    }

    @Test
    public void test2(){
        String ss = strT("\t\t\t提哈哈哈",(str)->str.trim());
        System.out.println(ss);

        String cc = strT("ascsds",(str)-> str.toUpperCase());
        System.out.println(cc);

        String dd = strT("12cwdfa",(str)->str.substring(4));
        System.out.println(dd);
    }
    //用于处理字符

    public String strT(String str, MyFun2 mf){
        return mf.getStr(str);
    }

}
