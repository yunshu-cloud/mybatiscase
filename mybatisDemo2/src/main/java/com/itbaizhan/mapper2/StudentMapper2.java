package com.itbaizhan.mapper2;

import com.itbaizhan.pojo.Student;

import java.util.List;

public interface StudentMapper2 {
//    List<Student> findAll();

    List<Student> findByClassId(int classId);
}
