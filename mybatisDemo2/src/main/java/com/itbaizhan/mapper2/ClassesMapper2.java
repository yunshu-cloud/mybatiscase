package com.itbaizhan.mapper2;

import com.itbaizhan.pojo.Classes;

import java.util.List;

public interface ClassesMapper2{
    // ��ѯ���а༶
    List<Classes> findAll();

    // ����ID��ѯ�༶
    Classes findByCid(int cid);
}
