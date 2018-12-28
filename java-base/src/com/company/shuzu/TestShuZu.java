package com.company.shuzu;

/**
 * @ClassName TestShuZu
 * @Author: ChenBJ
 * @Description: 数组
 * @Date: 2018/12/17 10:22
 * @Version:
 */
public class TestShuZu {
    public static void main(String[] args) {
        /**
         * 数组的定义:
         * type arrayName[];
         * type[] arrayName;
         * type是java中的任意数据类型,包括基本类型和组合类型, arrayName是数组名,必须是一个合法的标识符,[]指明该变量是一个数组类型变量:
         * 例如:
         * int testArray[]; 或者 int[] testArray;(这两种形式没区别,效果一样)
         * java数组定义时并没有为数组分配内存,即[]中无需指定数组元素的个数(长度),也不能访问数组中的任何元素,必须分配内存空间需要new:
         * testArray = new type[arraysize]; arraysize:长度;type:类型;如:testArray = new int[3];
         *
         * 数组的初始化:
         * 声明的同时进行初始化或者声明后进行初始化.
         * 静态初始化:
         * int intArray[] = {1,2,3,5};
         * 动态初始化:
         * int intArray[] = new int[3];
         * intArray[0] = 2;
         * intArray[1] = 4;
         * intArray[2] = 6;
         *
         * 数组引用:通过下标来引用数组.
         * */
        int[] test = {1,4,6,7,9};
        //遍历数组
        for(int i=0;i< test.length; i++){
            System.out.print(test[i] + ",");
        }
        //增强for循环
        for (int test1 : test) {
            System.out.print(test1+",");
        }
        //计算数组的和
        int sum = 0;
        for (int  j = 0; j < test.length; j++) {
            sum += test[j];
        }
        System.out.println(sum);

        /**
         * 二维数组:
         * 二维数组的声明,初始化和引用与一维数组相似:
         * int erTest[][] = {{1,3,5},{1,4,7},{4,6,8}}
         * java语言中,由于把二维数组看做是数组的数组,数组空间不是连续分配的,所以不要求二维数组每一维的大小相同.
         * */
        //计算两个矩阵的乘积
        int a[][] = {{1,3,5,8},{3,4,5,7},{1,4,7,9}};
        int b[][] = {{2,3},{4,2},{2,6}};
        int c[][] = new int[2][2];
        //计算矩阵乘积

    }
}
