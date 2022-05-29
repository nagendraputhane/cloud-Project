package com.example.demo;

import javax.persistence.*;
//creating table, use annotations entity and table
@Entity
@Table(name = "student")
public class Student {
    //id is for primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//primay key is auto incre
    private Integer aid;//prinary key
    @Column(nullable = false,length = 35)
    private String name;
    @Column(nullable = false,length = 50)
    private String email;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private float grade;
    @Column(nullable = false)
    private String phone;

    public Student(){}

    public Student(Integer aid, String name, String email, int age, float grade, String phone) {
        this.aid = aid;
        this.name = name;
        this.email = email;
        this.age = age;
        this.grade = grade;
        this.phone = phone;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student:\n" +
                "Student Id=" + aid +//studentobj.getAid();, studentobj.aid
                "\nName='" + name + '\'' +
                "\nEmail='" + email + '\'' +
                "\nAge=" + age +
                "\nGrade=" + grade +
                "\nContact Details='" + phone + '\'' +
                '\n';
    }//sop(studentobj); o/p: S8028308150
    //studentobj.toString();
}
