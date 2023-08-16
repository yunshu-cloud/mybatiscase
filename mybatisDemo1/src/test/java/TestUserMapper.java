import com.itbaizhan.mapper.UserMapper;
import com.itbaizhan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserMapper {

    @Test
    public void testFindAll() throws IOException {

        // 读取核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 工厂模式获取SqlSession对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();

        // SqlSession对象获取 代理对象 动态代理
        UserMapper userMapper = session.getMapper(UserMapper.class);

        // 代理对象执行方法
        List<User> all = userMapper.findAll();
        all.forEach(System.out::println);
        session.close();
        is.close();
    }

    @Test
    public void testAdd() throws Exception{
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("程序员", "男", "上海");
        userMapper.add(user);
        // 数据库连接池事务方式为JDBC 则事务不自动提交 新增方法需要手动commit
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
}
