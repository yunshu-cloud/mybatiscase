package com.itbaizhan.mapper;

import com.itbaizhan.pojo.PageQuery;
import com.itbaizhan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
// 映射文件与接口名称相同，目录结构也要相同
public interface UserMapper {
    List<User> findAll();
    void add(User user);
    void update(User user);
    void delete(int userId);
    User findById(int userId);

    List<User> findByNameLike(String username);

    List<User> findPage(int startIndex, int pageSize);

    List<User> findPage1(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    List<User> findPage2(PageQuery pageQuery);

    List<User> findPage3(Map<String,Object> params);

    int findCount();

    void add2(User user);

}
