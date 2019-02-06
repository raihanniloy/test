package com.niloy.test.dao;

import com.niloy.test.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsDAO extends JpaRepository<Student,Integer> {
    Student findById(Integer id);
}
