package com.itbaizhan.mapper;

import com.itbaizhan.pojo.User;
import com.itbaizhan.provider.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = int.class, before=false,statement = "SELECT LAST_INSERT_ID()")
    @Insert("insert into user(username,sex,address) values(#{username},#{sex},#{address})")
    void add(User user);


    @Update("update user set username = #{username},sex = #{sex},address = #{address} where id = #{id}")
    void update(User user);

    @SelectProvider(type = UserProvider.class,method = "findByConditionSql")
    List<User> findByCondition(User user);
}
