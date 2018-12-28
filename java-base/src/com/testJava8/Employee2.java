package com.testJava8;

/**
 * @ClassName Employee2
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/16 15:02
 * @Version:
 */
public class Employee2 {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
    private Status status;
    public enum Status{
        FREE,BUSY,VOCATION
    }


    public Employee2(  String name, Integer age, Double salary,Status status) {

        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee2 employee2 = (Employee2) o;

        if (id != null ? !id.equals(employee2.id) : employee2.id != null) return false;
        if (name != null ? !name.equals(employee2.name) : employee2.name != null) return false;
        if (age != null ? !age.equals(employee2.age) : employee2.age != null) return false;
        if (salary != null ? !salary.equals(employee2.salary) : employee2.salary != null) return false;
        return status == employee2.status;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    public Employee2(Integer id, String name, Integer age, Double salary, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }
}
