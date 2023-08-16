package com.itbaizhan.mapper;

import com.itbaizhan.pojo.PageQuery;
import com.itbaizhan.pojo.Teacher;
import com.itbaizhan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    List<Teacher> findAll();

    List<Teacher> findById(int id);

}
