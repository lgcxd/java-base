package com.company;

/**
 * @ClassName HelloWorld
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/12/17 15:29
 * @Version:
 */
public class HelloWorld {
    /*//Java程序的入口方法,程序将从这里开始执行
    public static void main(String[] args) {
        //向控制台打印一条语句
        System.out.println("Hello World!");
    }*/
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6,7},{9}};

        boolean found = false;

        for(int i=0;i<arr.length &&!found;i++)   {

            for(int j=0;j<arr[i].length;j++){

                System.out.println("i="+ i + ",j=" + j);

                if(arr[i][j]  == 5) {

                    found= true;

                    break;

                }

            }

        }

    }
}
