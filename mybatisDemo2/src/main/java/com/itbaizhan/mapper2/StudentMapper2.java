package com.itbaizhan.mapper2;

import com.itbaizhan.pojo.Student;

import java.util.List;

public interface StudentMapper2 {
    List<Student> findAllStudent();

    List<Student> findByClassId(int classId);
}
