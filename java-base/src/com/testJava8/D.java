package com.testJava8;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName D
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/20 17:03
 * @Version:
 */
public class D {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*SimpleDateFormat ss = new SimpleDateFormat("YYYY/MM/DD");
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return ss.parse("2018/02/11");
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> result = new ArrayList<>();
        for (int i = 0;i <10; i++){
            result.add(pool.submit(task));
        }
        for (Future<Date> ff :result){
            try {
                System.out.println(ff.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();*/

        //解决多线程安全问题
        /*Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatLoca.convert("20180807");
            }
        };
       ExecutorService pool = Executors.newFixedThreadPool(10);

       List<Future<Date>> result = new ArrayList<>();

       for (int i = 0;i< 10;i++){
           result.add(pool.submit(task));
       }
       for (Future<Date> future : result){
           try {
               System.out.println(future.get());
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
       }
       pool.shutdown();*/

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = new Callable<LocalDate>() {

            @Override
            public LocalDate call() throws Exception {
                LocalDate ld = LocalDate.parse("20161121", dtf);
                return ld;
            }

        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }


}
