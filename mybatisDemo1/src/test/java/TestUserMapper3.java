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

        // ͬһ��session��ȡ������mapper
        UserMapper userMapper1 = session.getMapper(UserMapper.class);
        UserMapper userMapper2 = session.getMapper(UserMapper.class);

        User user1 = userMapper1.findById(1);
        System.out.println(user1);
        System.out.println(user1.hashCode());
        System.out.println("============");
        //���һ������ �����ַ���
//        session.clearCache();
//        session.close();
//        session.commit();
        // һ��������Թ��� �ڶ��β�ѯ����Ҫsql
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

        // ��ȡ������ͬsession ÿ��session��ȡһ��mapper
        UserMapper userMapper1 = session1.getMapper(UserMapper.class);
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);

        User user1 = userMapper1.findById(1);
        System.out.println(user1);
        System.out.println(user1.hashCode());
        System.out.println("============");

        // �ڶ���session��ȡ��mapper��������ȡ���ݿ���Ҫ���½���sql��ѯ ��ͬsqlsession���ܹ���һ������
        User user2 = userMapper2.findById(1);
        System.out.println(user2);
        System.out.println(user2.hashCode());

    }
}
