package com.example.mapper;


import com.example.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentMapper extends CrudRepository<Student,String> {}