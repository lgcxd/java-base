package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName A2
 * @Author: ChenBJ
 * @Description: Lambda 表达式的基础语法
 * @Date: 2018/8/14 16:12
 * @Version:
 */
public class A2 {
    /**java8引入了一个新的操作符"->"该操作符称为箭头操作符或Lambda操作符
            箭头操作符将Lambda 表达式拆分成两部分:
    左侧:lambda 表达式的参数列表
    右侧:Lambda 表达中所需执行的功能,即Lambda体

    语法:
    无返回值无参数
    */
    @Test
    public void  test1(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world!");
            }
        };
        r.run();
        System.out.println("------------");
        Runnable r1 = ()->System.out.println("Hello Lambda");
        r1.run();
    }
    /**有一个参数并且无返回值
    * 只有一个参数的话,()可以省略不写*/
    @Test
    public void  test2(){
        /*Consumer<String> c = (x)-> System.out.println(x);*/
        Consumer<String> c = x-> System.out.println(x);
        c.accept("买不起房");
    }
    /**有多个参数并且Lambda体中有多条语句,就按着下面的方式写*/
    @Test
    public void test3(){
        Comparator<Integer> co = (x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    /**若lambda语句只有一条语句,大括号和return 也是可以省略不写*/
    public void  test4(){
        Comparator<Integer> co = (x,y)->Integer.compare(x,y);
    }
    /**语法格式6:Lambda参数列表的数据类型可以省略不写,因为jvm可以通过上下文推断出,若写全部都要写*/
    @Test
    public void  test5(){
      /*  String[] str;
        str = new String[]{"aa", "bb", "cc"};*/
        List<String> list = new ArrayList<>();
        //放在jdk1.7是编译通不过的
        show(new HashMap<>());
    }
    public void  show(Map<String,Integer> map){

    }
    /**Lambda表达式 需要函数式接口的支持
    * 函数式接口:接口只能一个抽象方法,可以使用注解@FunctionalInterface修饰 检查函数时接口
    * */

    /**需求:对一个数进行运算*/
    @Test
    public void test6(){
        Integer sum = op(100,(x)->x*x);
        System.out.println(sum);
        System.out.println(op(100,(z)->z+2*z));
    }
    public Integer op(Integer num,MyFun mf){
        return mf.getVlue(num);
    }
}
