package com.itbaizhan.service;

import com.itbaizhan.dao.StudentDao;
import com.itbaizhan.domain.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    // SqlSession对象
    @Autowired
    private SqlSessionTemplate sqlSession;

    // 使用SqlSession获取代理对象
    public List<Student> findAllStudent(){
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        return studentDao.findAll();
    }
}
