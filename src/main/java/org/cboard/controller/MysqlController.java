package org.cboard.controller;

import java.util.List;

import org.cboard.dao.StudentMapper;
import org.cboard.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql")
public class MysqlController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping(value = "/getAllStudentInfo")
    public List<Student> getAllStudentInfo() {
        List<Student> list = studentMapper.getAll();
        return list;
    }
}
