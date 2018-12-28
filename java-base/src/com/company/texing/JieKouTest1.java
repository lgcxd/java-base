package com.company.texing;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/16 15:12
 * @Version:
 */
class JieKouTest extends Anima implements JieKou,Swing,Runner {
    //实现接口中类的全部方法,否则将此类定义为抽象类
    //接口也可以继承接口,实现接口是实现全部接口(包括父接口)
    public void start(){
        System.out.println("开始");
    }
    public void run(){
        System.out.println("跑");
    }
    public void stop(){
        System.out.println("停止");
    }

    public void swing(){
        System.out.println("游泳");
    }
    public void eat(){
        System.out.println("会吃");
    }

}
public class JieKouTest1{
    public static void main(String[] args) {
        JieKouTest1 jieKouTest1 = new JieKouTest1();
        JieKouTest jieKouTest = new JieKouTest();
        jieKouTest1.m1(jieKouTest);
        jieKouTest1.m2(jieKouTest);
        jieKouTest1.m3(jieKouTest);
    }
    public void m1(Runner r){r.run();}
    public void m2(Swing s){
        s.swing();
    }
    public void m3(Anima a){a.eat();}
}
