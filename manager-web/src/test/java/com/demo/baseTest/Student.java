package com.demo.baseTest;

/**
 * 请添加描述
 *
 * @author ZeMing Zhu
 * @date Create in 2021/1/26 10:13
 */
public class Student implements Cloneable {
    private int id;
    private Score score;

    public Student(int id, Score score) {
        this.id = id;
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
                ", score=" + score +
                '}';
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
