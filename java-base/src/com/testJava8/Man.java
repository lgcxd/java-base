package com.testJava8;

/**
 * @ClassName Man
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/17 18:27
 * @Version:
 */
public class Man {
    private Godness god;
    public Man() {
    }
    public Man(Godness god) {
        this.god = god;
    }
    public Godness getGod() {
        return god;
    }
    public void setGod(Godness god) {
        this.god = god;
    }
    @Override
    public String toString() {
        return "Man [god=" + god + "]";
    }
}
