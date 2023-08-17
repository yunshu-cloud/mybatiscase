package com.itbaizhan.mapper2;

import com.itbaizhan.pojo.Classes;

import java.util.List;

public interface ClassesMapper2{
    // 查询所有班级
    List<Classes> findAll();

    // 根据ID查询班级
    Classes findByCid(int cid);
}
