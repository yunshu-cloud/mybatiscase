import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itbaizhan.mapper.UserMapper;
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
import java.util.List;

public class TestUserMapper {
    InputStream is = null;
    SqlSession session = null;
    UserMapper userMapper = null;
    @Before
    public void before() throws IOException {
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
    public void testFindAll(){
        List<User> all = userMapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testAdd(){
        User user = new User("北京程序员", "女", "朝阳区");
        userMapper.add(user);
        session.commit();
    }

    @Test
    public void testUpdate(){
        User user = new User(7,"上海程序员", "女", "黄埔区");
        userMapper.update(user);
        session.commit();
    }


    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setUsername("%北京%");
        List<User> all = userMapper.findByCondition(user);
        all.forEach(System.out::println);

    }


    @Test
    public void testFindPage(){
        PageHelper.startPage(1,3);
        List<User> all = userMapper.findAll();
        PageInfo pageInfo = new PageInfo(all);
        System.out.println("结果集："+pageInfo.getList());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
    }
}
