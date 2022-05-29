package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
//main purpose is to query student table
//all those queries can be written using sql
//but jpa repo, has predefined queries
//instead of writing sql, u can extend this interface JPARepo, and use queries from there.
public interface StudentRepository  extends JpaRepository<Student,Integer> {
    public Student findByAid(int aid);
}
