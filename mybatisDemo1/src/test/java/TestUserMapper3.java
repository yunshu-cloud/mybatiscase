import com.itbaizhan.mapper.UserMapper;
import com.itbaizhan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestUserMapper3 {
    @Test
    public void testCache1() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();

        // 同一个session获取的两个mapper
        UserMapper userMapper1 = session.getMapper(UserMapper.class);
        UserMapper userMapper2 = session.getMapper(UserMapper.class);

        User user1 = userMapper1.findById(1);
        System.out.println(user1);
        System.out.println(user1.hashCode());
        System.out.println("============");
        //清空一级缓存 有三种方法
//        session.clearCache();
//        session.close();
//        session.commit();
        // 一级缓存可以共享 第二次查询不需要sql
        User user2 = userMapper2.findById(1);
        System.out.println(user2);
        System.out.println(user2.hashCode());
    }


    @Test
    public void testCache2() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();

        // 获取两个不同session 每个session获取一个mapper
        UserMapper userMapper1 = session1.getMapper(UserMapper.class);
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);

        User user1 = userMapper1.findById(1);
        System.out.println(user1);
        System.out.println(user1.hashCode());
        System.out.println("============");

        // 第二个session获取的mapper代理对象获取数据库需要重新进行sql查询 不同sqlsession不能共享一级缓存
        User user2 = userMapper2.findById(1);
        System.out.println(user2);
        System.out.println(user2.hashCode());

    }
}
