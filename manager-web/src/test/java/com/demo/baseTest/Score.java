package com.demo.baseTest;

import java.io.Serializable;

/**
 * @author ZeMing Zhu
 * @date Create in 2021/1/26 11:03
 * @description 请添加描述
 */
public class Score implements Cloneable, Serializable {

    private static final long serialVersionUID = 2363058445426648858L;
    private int id;
    private double level;

    public Score(int id, double level) {
        this.id = id;
        this.level = level;
    }

    @Override
    protected Score clone() throws CloneNotSupportedException {
        return (Score)super.clone();
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", level=" + level +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
