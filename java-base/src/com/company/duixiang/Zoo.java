package com.company.duixiang;

import com.company.duixiang.Animal;

public class Zoo{
	public static void main(String[] args){
		Animal animal=new Animal();//创建一个对象
		animal.legs=4;//给成员变量赋值
		System.out.println("几条腿:"+animal.legs);//animal.legs调用成员变量
		animal.eat();//调用成员方法
		animal.move();

		Animal animal2=new Animal();
		animal2.name="小鸭子";
		animal2.legs=2;
		System.out.println("动物名:"+animal2.name+"\n"+"几条腿:"+animal2.legs+"条");
		animal2.move();

		Animal animal3;
		animal3=animal;//调用的同一个对象
		animal3.legs=2;
		System.out.println("几条腿:"+animal3.legs+"条");
		System.out.println("几条腿:"+animal.legs+"条");
	}
}