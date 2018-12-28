package com.company;

/**
 * Created by Administrator on 2018/4/18.
 */
public class ForExmple {
    public static void ju() {
        for (int i = 0; i < 3; i++) {//最外层控制循环打印矩形个数
            for (int j = 0; j < 8; j++) {//矩形宽

                for (int k = 0; k < 10; k++) {//矩形长

                    System.out.print("*");//

                }
                //System.out.println();//tongli
                System.out.print("\n");//打印出一行10个*后换行

            }
            System.out.println("-----第" + i + "个矩形打印完成-----");
        }
    }
    public static void san(){
        //正直三角
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //倒直三角
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j < 4-i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void zsan(){
        for (int i = 0; i <5 ; i++) {
            for (int j = 1; j <10 ; j++) {
                    if (j >= 5 - i && j <= i + 5) {
                        int n = i + j;
                        if (n % 2 == 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print(" ");
                    }

            }
            System.out.print("\n");
        }
        for (int i = 0; i <4 ; i++) {
            for (int j = 8; j > 0; j--) {
                if (j <= 8- i && j >= i) {
                    int n = i + j;
                    if (n % 2 == 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(" ");
                }

            }
            //System.out.print("\n");
            System.out.println();
        }

        }
    public static void zsan2(){
        for (int i = 0; i <5 ; i++) {
            for (int j = 1; j <10 ; j++) {
                if (j >= 5 - i && j <= i + 5) {
                    int n = i + j;
                    if (n % 2 == 1) {
                        System.out.print("*");
                    } else {
                        System.out.print("*");
                    }
                } else {
                    System.out.print(" ");
                }

            }
            System.out.print("\n");
        }
        for (int i = 0; i <4 ; i++) {
            for (int j = 8; j > 0; j--) {
                if (j <= 8- i && j >= i) {
                    int n = i + j;
                    if (n % 2 == 1) {
                        System.out.print("*");
                    }else{
                        System.out.print("");
                    }
                } else {
                    System.out.print(" ");
                }

            }
            //System.out.print("\n");
            System.out.println();
        }
    }
    public static void ling(){
        for (int i = 0; i <= 5 ; i++) {
            for (int k = 0; k <= 5; k++) {
                System.out.print("");
            }
            for (int j = 1; j <=2*i-1 ; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        /*for (int i = 0; i <=4 ; i++) {
            for (int k = i-1; k <=2*i-1 ; k++) {
                System.out.print("");
            }
            for (int j = 7; j >= i*2-1; j--) {
                System.out.print("*");
            }
            System.out.print("\n");//换行打印
        }*/
    }

    public static void main(String[] args) {
        zsan();
    }

}
