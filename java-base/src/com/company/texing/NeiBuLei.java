package com.company.texing;

import java.util.concurrent.BrokenBarrierException;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/16 15:45
 * @Version:
 */
public class NeiBuLei {
    /*
    * 内部类特性:可以声明为抽象类,so可以被其他类继承,也可以声明为final
    * 和外层类不同,inner class 可以声明为private protected
    * 也可以声明为static 但此时就不能再使用外层封装类的非static的成员变量
    * 非static的内部类中的成员不能声明为static,只有在顶层类或static的内部类中才可声明static成员*/
    private int n1;
    private int n2 = 111;
    public class B{
        private int n2 = 222;
        public void m(){
            n1 = 100;
            System.out.println("b中n1"+ n1);
        }
        public void m2(int n2){
            System.out.println(n2);//局部变量n2
            System.out.println(this.n2); //内部类对象的n2
            System.out.println(NeiBuLei.this.n2); //外层类对象的n2
        }
    }
    public void ma(){
        B b =new B();
        b.m();
    }

    public static void main(String[] args) {
        NeiBuLei a= new NeiBuLei();
        a.ma();
        NeiBuLei.B bb = a.new B();
        bb.m();
        bb.m2(333);
    }
}
