package com.company.yichang;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/16 17:25
 * @Version:
 */
public class ChuLi {
    int a =1;
    public static void main(String[] args) {
        String names[] = {"画画","祥祥","默默"};
        ChuLi chuLi = new ChuLi();
        chuLi = null;
        try{
            //System.out.println(chuLi.a);
            for (int i = 0;i<5;i++){
                System.out.println(names[i]);
            }

        }catch (ArrayIndexOutOfBoundsException  e){
            System.out.println("角标越界");
        }
        System.out.println("\nthis is the end");
    }
}
