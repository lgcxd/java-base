package com.testJava8;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName A5
 * @Author: ChenBJ
 * @Description: 方法引用:若Lambda体中的内容有方法已经实现了,我们可以使用"方法引用
 * @Date: 2018/8/14 18:34
 * @Version:
 */
public class A5 {
    /*主要有三种语法格式:
    * 对象::实例方法名
    * 类::静态方法名
    * 类::实例方法名
    *
    *  注意:Lambda 体中调用方法的参数列表与返回值类型,要与函数式接口中的抽象方法的函数列表和返回值类型需要一致
        若Lambda 参数列表中的第一参数是 实例方法的调用者,而第二个参数是实例方法的参数时,可以使用ClassName::method

       构造器引用
       格式:
       ClassName::new
       */
    //对象::实例方法:
    @Test
    public void test1(){
        PrintStream ps1 = System.out;//实例
        Consumer<String> con = (c)-> ps1.println(c);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
        con1.accept("哈哈哈哈哈哈");
    }

    @Test
    public void  test2(){
        Employee ep = new Employee();
       /* Supplier<String> sp = ()->ep.getName();
        String str = sp.get();
        System.out.println(str);*/

        Supplier<Integer> sup = ep::getAge;
        Integer num = sup.get();
        System.out.println(num);
    }
    /*类::静态方法名*/
    @Test
    public void test3(){
        Comparator<Integer> c = (x,y)->Integer.compare(x,y);

        Comparator<Integer> c2 = Integer::compare;
    }

    //类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> bp = (x,y)->x.equals(y);

        BiPredicate<String,String> bp2 = String::equals;
    }
    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sp = ()->new Employee();

        //构造器引用
        Supplier<Employee> sp2 =Employee::new;
        Employee e = sp2.get();
        System.out.println(e);
    }
    //一个参数的构造器,根据函数式接口中抽象方法的参数列表保持一致
    @Test
    public void test6(){
        Function<Integer,Employee> fun = (x)->new Employee();

        Function<Integer,Employee> fun2 = Employee::new;
        Employee e = fun2.apply(101);
        System.out.println(e);
    }

    /*数组引用:
    * */
    @Test
    public void test7(){
        Function<Integer,String[]> function = (x)->new String[x];
        String[] str = function.apply(10);
        System.out.println(str.length);

        Function<Integer,String[]> fun = String[]::new;
        String[] s = fun.apply(20);
        System.out.println(s.length);
    }
}
