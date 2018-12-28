package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @ClassName TestOptional
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/17 16:27
 * @Version:
 */
public class TestOptional {
    /* 容器类常用方法
        Optional.of(T t):创建一个Optional实例
        Optional.empty():创建一个空的Optional 实例
        Optional.ofNullable(T t):若t 不为 null,创建Optional 实例,否则创建空实例
        isPresent():判断是否包含值
        orElse(T t): 如果调用对象包含值,返回该值,否则返回t 没有对象值是给设置默认值
        orElseGet(Supplier s):如果对象包含值,返回该值,否则返回s获取的值
        map(Function f):如果有值对其处理,并返回处理后Optional,否则返回Optional.empty()
        flatMap(Function mapper):与map类似,要求返回值必须是optional
     */
    @Test
    public void test(){
        Optional<Employee> op = Optional.of(new Employee());//若为null 则空指针异常
        Employee e = op.get();
        System.out.println(e);//结果 Employee{name='null', age=null, salary=null}
    }
    @Test
    public void test2(){
        /*Optional<Employee> op = Optional.empty();
        System.out.println(op.get());*/
        //java.util.NoSuchElementException: No value present at java.util.Optional.get(Optional.java:135)

        Optional<Employee> op = Optional.ofNullable(new Employee());
        System.out.println(op.get());
        //若为null,则java.util.NoSuchElementException: No value present at java.util.Optional.get
    }
    @Test
    public void test3(){
        Optional<Employee> op = Optional.ofNullable(null);

        if (op.isPresent()){
            System.out.println(op.get());
        }

        Employee ep = op.orElse(new Employee("zhangsan",12,1231.121));//设置默认值
        System.out.println(ep);

        Employee emp2 = op.orElseGet(()->new Employee());
        System.out.println(emp2);
    }

    @Test
    public void test4(){
        Optional<Employee2> op = Optional.of(new Employee2("zhangsan",23,9999.99, Employee2.Status.BUSY));
        //传参为null是会报空指针 java.lang.NullPointerException at java.util.Objects.requireNonNull
        /*System.out.println(op.get());*/
        Optional<String> op2 = op.map(Employee2::getName);
        System.out.println(op2.get());

        Optional<String> op3 = op.flatMap((e)->Optional.of(e.getName()));
        System.out.println(op3.get());

    }

    @Test
    public void test5(){
        Man man = new Man();

        String name = getGodnessName(man);
        System.out.println(name);
    }
    //需求：获取一个男人心中女神的名字
    public String getGodnessName(Man man){
        if(man != null){
            Godness g = man.getGod();

            if(g != null){
                return g.getName();
            }
        }
        return "哈哈哈哈";
    }

    //运用 Optional 的实体类
    @Test
    public void test6(){
        Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));
        Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
        String name = getGodnessName2(op);
        System.out.println(name);
    }

    public String getGodnessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("哈哈哈"))
                .getName();
    }
}
