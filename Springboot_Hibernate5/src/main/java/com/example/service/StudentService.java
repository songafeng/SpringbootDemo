package com.example.service;


import com.example.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 添加
     */
    void insertStudent(Student student);

    /**
     * 删除
     */
    void deleteStudent(String id);

    /**
     * 修改
     */
    void updateStudent(Student student);

    /**
     * 查询
     */
    List<Student> getStudent();

    /**
     * 查询单个
     */
    Student getStudentById(String id);

}