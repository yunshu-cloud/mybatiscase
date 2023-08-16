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

    // 用户通用查询
    List<User> findByCondition(User user);


    /**
     * choose{when , otherwise} 标签 分支
     * @param username
     */
    List<User> findByUsername(String username);

    /**
     * 批量删除 foreach遍历数组
     * @param ids
     */
    void deleteBatch(int[] ids);

    /**
     * 批量添加 foreach遍历Collection
     * @param users
     */
    void insertBatch(List<User> users);


    /**
     * 多条件查询
     * @param map 查询条件键值对 键：属性名 值：属性值
     * @return
     */
    List<User> findUser(@Param("queryMap") Map<String,Object> map);


}
