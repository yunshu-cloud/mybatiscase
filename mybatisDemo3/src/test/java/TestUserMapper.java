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
}
