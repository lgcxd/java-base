package com.testJava8;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @ClassName testForkJoin
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/17 16:09
 * @Version:
 */
public class testForkJoin {
    @Test
    public void test(){
        Long start = System.currentTimeMillis();//起始时间

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalulate(0L,100000000L);

        long sum = pool.invoke(task);
        System.out.println(sum);

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为:"+(end-start));//265
    }

    @Test
    public void  test2(){
        long start = System.currentTimeMillis();

        long sum = 0L;

        for (Long i = 0L;i<10000000000L;i++){
            sum += i;
        }
        System.out.println(sum);

        Long end = System.currentTimeMillis();

        System.out.println("耗费时间为"+(end - start));//50532
    }

    @Test
    public void test3(){
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L,10000000000L)
                .parallel()
                .sum();
        System.out.println(sum);
        Long end = System.currentTimeMillis();
        System.out.println("耗费的时间为:"+(end - start)); //2104

    }
}
