package a1_1;

import java.time.LocalDate;

/**
 * A1-1 优良品质的马。
 * 类图对应：属性 mother、father、birthyear 均为私有（-）；
 * 操作 getCurrentAge()、getFather()、getMother() 均为公有（+）。
 */
public class Thoroughbred {

    /** 母亲（-） */
    private Thoroughbred mother;
    /** 父亲（-） */
    private Thoroughbred father;
    /** 出生年份（-） */
    private int birthyear;

    public Thoroughbred(Thoroughbred mother, Thoroughbred father, int birthyear) {
        this.mother = mother;
        this.father = father;
        this.birthyear = birthyear;
    }

    /** 以当前年份与出生年份之差计算年龄（+） */
    public int getCurrentAge() {
        return LocalDate.now().getYear() - birthyear;
    }

    /** 返回父亲（+） */
    public Thoroughbred getFather() {
        return father;
    }

    /** 返回母亲（+） */
    public Thoroughbred getMother() {
        return mother;
    }

    @Override
    public String toString() {
        return "Thoroughbred{birthyear=" + birthyear
                + ", age=" + getCurrentAge()
                + ", father=" + (father == null ? "未知" : father.birthyear)
                + ", mother=" + (mother == null ? "未知" : mother.birthyear) + "}";
    }
}
