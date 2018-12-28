package com.testJava8;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @ClassName D2
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/23 16:12
 * @Version:
 */
public class D2 {
    //6.ZonedDate ZonedTime ZonedDateTime: 带时区的时间或日期
    @Test
    public void test7(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));//上海时间
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));//美国时间
        System.out.println(zdt);
    }

    @Test
    public void test6(){
        Set<String> set = ZoneId.getAvailableZoneIds();//所有时区
        set.forEach(System.out::println);
    }

    //5.DateTimeFormatter : 解析和格式化日期或时间
    @Test
    public void test5(){
        //DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;//默认
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");

        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);

        System.out.println(strDate);

        LocalDateTime newLdt =ldt.parse(strDate,dtf);
        System.out.println(newLdt);
    }

    //4.TemporalAdjuster: 时间校正器
    @Test
    public void test4(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);//2018-08-23T16:54:26.903

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);//未来10天后
        System.out.println(ldt2);//2018-08-10T16:55:36.815

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));//下个周天时间 2018-08-26T16:57:47.049
        System.out.println(ldt3);

        //自定义下个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;

            DayOfWeek dow = ldt4.getDayOfWeek();

            if(dow.equals(DayOfWeek.FRIDAY)){
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }
    //3.
    //Duration: 用于计算两个'时间' 间隔
    //Period: 用于计算两个'日期' 间隔
    @Test
    public void test3(){
        Instant ins = Instant.now();
        System.out.println("------------");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        System.out.println("所耗费时间为:"+Duration.between(ins,ins2));

        System.out.println("-----------");

        LocalDate ld = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2019,8,25);//差值

        Period pe = Period.between(ld,ld2);
        System.out.println(pe.getYears());//当前时间2018年 8月23号 1
        System.out.println(pe.getMonths());//0
        System.out.println(pe.getDays());//2
    }

    //2.Instant : 时间戳 (使用Unix元年 1970年1月1日 00:00:00 所经历的毫秒值)
    @Test
    public void test2(){
        Instant ins = Instant.now(); ////默认使用 UTC 时区
        System.out.println(ins); // 2018-08-23T08:30:30.606Z

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));//时区 差
        System.out.println(odt);

        System.out.println(ins.getNano());

        Instant ins2 = Instant.ofEpochSecond(5);
        System.out.println(ins2);
    }

    //1. LocalDate、LocalTime、LocalDateTime
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();//获取当前时间 "2018-08-23T16:16:09.790"
        System.out.println(ldt);

        LocalDateTime ld2 = LocalDateTime.of(2018,8,07,10,10,10);
        System.out.println(ld2);//自定义的 2018-08-07T10:10:10

        LocalDateTime ld3 = ld2.plusYears(20);//未来的时间 2038-08-07T10:10:10
        System.out.println(ld3);

        LocalDateTime ld4 = ld2.minusMonths(2);//过去的时间
        System.out.println(ld4);//2018-06-07T10:10:10

        System.out.println(ldt.getYear());// 年 2018
        System.out.println(ldt.getMonthValue());// 月 8
        System.out.println(ldt.getDayOfMonth());//天 23
        System.out.println(ldt.getHour());//时 16
        System.out.println(ldt.getMinute());//分 26
        System.out.println(ldt.getSecond());//秒 44
    }
}
