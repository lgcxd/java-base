package com.java8;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @Author: chenbj
 * @Description: Lambda表达式的学习
 * 1.Lambda 表达式的基础语法:
 * java8中引入了一个新的操作符"->"该操作符称为箭头操作符或Lamda操作符
 * 该操作符分拆分为两部分:
 * 左侧:lambda 表达式的参数列表
 * 右侧:lambda 表达式所需执行的功能,即lambda体
 * 语法格式1:
 * 无参数 无返回值 ()-> System.out.println("hello world");
 *有一个参数 无返回值 (x)-> System.out.println(x);
 * 若只有一个参数小括号可以不写 x-> System.out.println(x);
 * 有两个参数,有返回值,并且Lambda体中有多条语句  Comparator<Integer> com=(x,y)->{
                                                System.out.println("函数式接口");
                                                return Integer.compare(x,y);
                                                };
*若Lambda体中只有一条语句,return 和 大括号 可以不写 Comparator<Integer> com=(x,y)->Integer.compare(x,y);
 * 6:Lambda表达式的数据类型可以不写,因为jvm可以根据上下文中推断出数据类型
 * 左右遇1括号省
 * 左侧推断类型省
 * Lambda表达式需要"函数式"接口
 * 函数时接口:接口中只有一个抽象方法的接口,称为函数式接口,可以使用注解@FunctionalIterface 修饰
 *      可以检查是否是函数式接口
 * @Date: 2018/5/28 16:55
 * @Version:
 */
public class TestLambda1 {
    @Test
    public void test(){
        int num =0;//java1.7前,必须是final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world"+num);
            }
        };
        System.out.println("-----------");
        //Lambda表达式
        Runnable r1=()-> System.out.println("hello world");
        r1.run();
    }
    /* @Test
    public void test2(){

    }*/
    @Test
    public void test2(){
        Consumer<String> com = (x)-> System.out.println(x);
        com.accept("hahah1");
    }
    @Test
    public void test3(){
        Comparator<Integer> com=(x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    @Test
    public void test4(){
        //String[] str={"aaa","bb"};
       /* String[] str;
        str={"aaa","bb"};*/
       Integer a=opera(100,x->x*x);
        System.out.println(a);
    }
    public Integer opera(Integer num,MyFunction mf){
       return mf.getVale(num);
    }
    //1.调用Collection.sort()方法,通过定制排序比较两个Employee(先按年龄比,年龄相同按姓名比),使用Lambda作为参数传递
    List<Employee> employees = Arrays.asList(
            new Employee("张三",13,2323.33),
            new Employee("李四",17,1234.22),
            new Employee("王五",20,2323.33),
            new Employee("赵六",30,2323.33),
            new Employee("喝喝",45,6666.12),
            new Employee("嘻嘻",45,10000.23)
    );
    @Test
    public void tes5(){
        Collections.sort(employees,(e1,e2)->{
            if (e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee e:employees) {
            System.out.println(e);
        }
    }
    //2.1.声明函数式接口,接口中声明抽象方法,public String getValue(String str);
    //2.2声明类TestLambda,类中编写方法使用接口作为参数,将一个字符串转换成大写,并作为方法的返回值.
    //2.3再将一个字符串的第2个和第4个索引位置进行截取子串.
    @Test
    public void test6(){
        String strTrim=getStrVale("  hi,你好嘻嘻!",(str)->str.trim());
        System.out.println(strTrim);
        String a=getStrVale("嘻嘻,你是最棒的" ,str -> str.substring(2,5));
        System.out.println(a);
        String as=getStrVale("abdc",str -> str.toUpperCase());
        System.out.println(as);
    }
    public String getStrVale(String str,MyFun mf){
        return mf.getValue(str);
    }
    //3.1声明一个带两个泛型的函数时接口,泛型类型为<T,R> T为参数,R为返回值
    //3.2接口中声明对应抽象方法
    //3.3在TestLambda类中声明方法,使用接口作为参数,计算两个long型参数的和.
    //3.4再计算两个long型参数的乘积
    @Test
    public void test7(){
        op(1000000L,30000000L,(x,y)->x+y);
        op(1000000L,30000000L,(x,y)->x*y);
    }
    public void op(Long l1,Long l2,Myfun2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }

}
