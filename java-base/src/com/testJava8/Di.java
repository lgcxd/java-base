package com.testJava8;

public interface Di {
    //默认实现方法(类优先)
    default String getName(){
        return "哈哈哈哈";
    }
}
