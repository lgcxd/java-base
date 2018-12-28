package com.testJava8;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.concurrent.RecursiveTask;

/**
 * @ClassName ForkJoinCalulate
 * @Author: ChenBJ
 * @Description: RecursiveTask有返回值的
 * @Date: 2018/8/17 15:17
 * @Version:
 */
public class ForkJoinCalulate extends RecursiveTask<Long> {
    private static final long serialVersionUID = 12375679780L;
    private long start;
    private  long end;

    private static final long THRESHOLLD = 1000L;//临界值

    @Override
    protected Long compute() {
        long lenth = end - start;

        if (lenth <= THRESHOLLD){
            long sum = 0;
            for (long i = start;i <= end;i++){
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end)/2;
            ForkJoinCalulate left = new ForkJoinCalulate(start, middle);
            left.fork();//拆分,并将该子任务压入线程队列
            ForkJoinCalulate right = new ForkJoinCalulate(middle+1, end);
            right.fork();

            return left.join() + right.join();
        }
    }

    public ForkJoinCalulate(long start, long end) {
        this.start = start;
        this.end = end;
    }
}
