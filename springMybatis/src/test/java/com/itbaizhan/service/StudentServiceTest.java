package com.itbaizhan.service;

import com.itbaizhan.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void testFindAll(){
        List<Student> allStudent = studentService.findAllStudent();
        allStudent.forEach(System.out::println);
    }
}
