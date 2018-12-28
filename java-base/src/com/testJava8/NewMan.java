package com.testJava8;

import java.util.Optional;

/**
 * @ClassName NewMan
 * @Author: ChenBJ
 * @Description: 注意：Optional 不能被序列化
 * @Date: 2018/8/17 18:28
 * @Version:
 */
public class NewMan {
    private Optional<Godness> godness = Optional.empty();

    private Godness god;

    public Optional<Godness> getGod(){
        return Optional.of(god);
    }

    public NewMan() {
    }

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public Optional<Godness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "NewMan [godness=" + godness + "]";
    }
}
