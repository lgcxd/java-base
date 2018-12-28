package com.company;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Exmple {
    public static void main(String[] args) {
        int sc=3;
        for (int i = -sc; i <= sc ; i++) {
            for (int j = -sc; j <= sc ; j++) {
                System.out.print((Math.abs(i)+Math.abs(j)<=sc)?"*":"");
            }
            System.out.println();
        }
    }
}
