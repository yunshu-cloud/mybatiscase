import com.itbaizhan.mapper.UserMapper;
import com.itbaizhan.pojo.PageQuery;
import com.itbaizhan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 利用junit前置后置方法优化测试方法
 */
public class TestUserMapper2 {
    InputStream is = null;
    SqlSession session = null;
    UserMapper userMapper = null;
    @Before
    public void init() throws IOException {
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
         SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
         SqlSessionFactory factory = builder.build(is);
         session = factory.openSession();
         userMapper = session.getMapper(UserMapper.class);
    }
    @After
    public void after() throws IOException {
        session.close();
        is.close();
    }

    @Test
    public void testFindAll() throws IOException {
        List<User> all = userMapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testAdd() throws Exception{
        User user = new User("程序员3", "男", "上海");
        userMapper.add(user);
        session.commit();
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = new User(8,"程序员","女","深圳");
        userMapper.update(user);
        session.commit();
    }

    @Test
    public void testDelete(){
        userMapper.delete(8);
        session.commit();
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(1);
        System.out.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testFindByNameLike(){
        List<User> users = userMapper.findByNameLike("%尚%");
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 分页查询 顺序传参
     */
    @Test
    public void testFindPage(){
        List<User> users = userMapper.findPage(0,3);
        users.forEach(System.out::println);
    }


    /**
     * 分页查询 使用@Param定义变量名称
     */
    @Test
    public void testFindPage1(){
        List<User> users = userMapper.findPage1(0,3);
        users.forEach(System.out::println);
    }

    /**
     * 分页查询 使用对象传参
     */
    @Test
    public void testFindPage2(){
        PageQuery pageQuery = new PageQuery(3,3);
        List<User> users = userMapper.findPage2(pageQuery);
        users.forEach(System.out::println);
    }

    /**
     * 分页查询 使用map传参
     */
    @Test
    public void testFindPage3(){
        Map<String,Object> params = new HashMap<>();
        params.put("startIndex",0);
        params.put("pageSize",4);
        List<User> users = userMapper.findPage3(params);
        users.forEach(System.out::println);
    }

    /**
     * 查询用户总数
     */
    @Test
    public void testFindCount(){
        System.out.println(userMapper.findCount());
    }


    /**
     * 主键回填
     */
    @Test
    public void testAdd2(){
        User user = new User("developer", "female", "beijing");
        System.out.println(user);
        userMapper.add2(user);
        session.commit();
        System.out.println(user);
    }

    /**
     * 动态sql
     */
    @Test
    public void testFindByCondition(){
        User user = new User();
        List<User> users = userMapper.findByCondition(user);
        users.forEach(System.out::println);

        user.setUsername("%尚学堂%");
        List<User> users1 = userMapper.findByCondition(user);
        users1.forEach(System.out::println);

        user.setAddress("北京");
        List<User> users2 = userMapper.findByCondition(user);
        users2.forEach(System.out::println);
    }
}
