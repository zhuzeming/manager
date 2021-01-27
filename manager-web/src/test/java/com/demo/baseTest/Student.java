package com.demo.baseTest;

import java.io.Serializable;

/**
 * 请添加描述
 *
 * @author ZeMing Zhu
 * @date Create in 2021/1/26 10:13
 */
public class Student implements Cloneable, Serializable {

    private static final long serialVersionUID = -605668423999264147L;
    private int id;
    private String name;
    private Score score;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, Score score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.setScore(this.score.clone());
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
