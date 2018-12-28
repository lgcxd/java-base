package com.company.texing;

/**
 * @Author: chenbj
 * @Description:
 * @Date: 2018/5/14 15:28
 * @Version:
 */
public class Person1Test extends Person1 {
    private String school;

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public void method(Person1 p){
        /*
        * 对象类型转换*/
        //System.out.println(p.getSchool());//非法，编译时错误
        if(p  instanceof  Person1Test){
            Person1Test me = (Person1Test)p;	//将p强制转换为Student类型
            System.out.println(me.getSchool());
        }
    }
    public void getInfo(){
        super.getInfo();
    }
    public static void main(String[] args) {
        Person1Test person1Test = new Person1Test();
        person1Test.name = "HUAHUA1";
        //person1Test.age = 12;//只能用在本类
        person1Test.names = 2;//在子类也可以获取到值
        person1Test.sex = '女';

        System.out.println(person1Test.name+person1Test.sex+person1Test.names);

        /*
         *关键字super
         * 在java类中使用super来引用父类的成分
         * -super可用于访问父类中定义的属性
         * -super可用于调用父类中定义的成员方法
         * -super可用于在子类构造方法中调用父类的构造方法
         * -super的追溯不仅限于直接父类
         */
        person1Test.getInfo();
        //子类继承父类所有的成员变量和方法,但是不能继承构造方法
        //构造方法获得有两种方式 1.系统默认 2.显示定义(显示定义了系统就不提供了)
        //在子类的构造方法中可使用super(参数列表)语句调用父类的构造方法
        //若子类的构造方法中没有显示的调用父类构造方法,也没有使用this关键字调用重载的其他构造方法,则系统默认调用父类无参的构造函数
        //若子类构造方法中既未显示调用父类构造方法,而父类中又没有无参的构造函数,则编译出错
    Person1 person1 = new Person1();
        /*Person1Test person1Test1 = new Person1Test();
        person1.method(person1Test1);*/
    }
}
