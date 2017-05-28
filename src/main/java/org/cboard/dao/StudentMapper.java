package org.cboard.dao;

import java.util.List;

import org.cboard.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    List<Student> getAll();
}