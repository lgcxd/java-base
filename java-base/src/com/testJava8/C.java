package com.testJava8;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


/**
 * @ClassName C
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/17 13:54
 * @Version:
 */
public class C {
    List<Transaction> ts = null;

    @BeforeEach
    public void before(){
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        ts = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,900)
        );
    }
    //1.找出2012年发生的所有交易,并按交易额排序(从低到高)
    @Test
    public void test1(){
        ts.stream()
                .filter((e)->e.getYear()==2012)
                .sorted((e,e2)->Integer.compare(e.getValue(),e2.getValue()))
                .forEach(System.out::println);
    }
    //2.交易员都在那个城市工作过?
    @Test
    public void test2(){
        ts.stream()
                .map((e)->e.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }
    //3.查找所有来自剑桥的交易员,并按姓名排序
    @Test
    public void test3(){
        ts.stream()
                .filter((e)->e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);
    }
    //4.返回所有交易员的姓名字符串,按字母顺序排序
    @Test
    public void test4(){
        ts.stream()
                .map((t)->t.getTrader().getName())
                .sorted()
                .forEach(System.out::println);//姓名按顺序排序

        String str = ts.stream()
                .map((t)->t.getTrader().getName())
                .sorted()
                .reduce("",String::concat);
        System.out.println(str);//转换成一个字符串

        ts.stream()
                .map((t)->t.getTrader().getName())
                .flatMap(C::filterCharacter)
                .sorted((s1,s2)->s1.compareToIgnoreCase(s2))
                .forEach(System.out::println);


    }
    public static Stream<String> filterCharacter(String str){
        List<String> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch.toString());
        }

        return list.stream();
    }
    //5.有没有交易员是在米兰工作的?
    @Test
    public void test5(){
       boolean b = ts.stream()
               .anyMatch((t)->t.getTrader().getCity()=="Milan");
        System.out.println(b);
    }
    //6.打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6(){
        Optional<Integer> sum = ts.stream()
                .filter((t)->t.getTrader().getCity()=="Cambridge")
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }
    //7.所有交易中,最高的交易额是多少
    @Test
    public void test7(){
        Optional<Integer> max = ts.stream()
                .map((t)->t.getValue())
                .max(Integer::compare);
        System.out.println(max.get());
    }
    //8.找到交易额最小的交易
    @Test
    public void test8(){
      Optional<Transaction> op =  ts.stream()
                .min((t,t2)->Integer.compare(t.getValue(),t2.getValue()));
        System.out.println(op.get());
    }
}
